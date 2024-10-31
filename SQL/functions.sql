/*				Project_Vaseis_Dedomenon_2023-24, CEID.UPATRAS				*/
/*				
				Christos_Dimitrakopoulos, chris.dimitrako@ac.upatras.gr
				Bertsekas_Paraskevas-Sotirios, up1093445@ac.upatras.gr
				Laurentius_Ioannis, up1093441@ac.upatras.gr


						------CONTAINS------
                                
EVERY FUNCTION, PROCEDURE AND TRIGGER AS DESCRIBED ON THE PDF FILE FOUND ON 
PARENT FOLDER. DEBUG PROCEDURE DECLARED IN THE END. USE CALL debuggg(); TO 
						TEST EVERY FUNCTIONALITY.

*/

use project;


# 3.1.2.1 #
#Elegxei an h mera pou paei na ginei h kainourgia aithsh einai 15 meres prin thn enarksh ths douleias
DROP FUNCTION IF EXISTS ApplicationDeadlineCheck; #WORKING
DELIMITER $$
CREATE FUNCTION ApplicationDeadlineCheck (_job_id INT(11)) 
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	DECLARE Job_start_date DATE;
  DECLARE DateDifference INT;
  SELECT start_date FROM job WHERE Job_id = _job_id INTO Job_start_date;
  IF((SELECT DATEDIFF(Job_Start_date, CURDATE()) AS DAYS) >=15)THEN
		RETURN TRUE;
	ELSE
		RETURN FALSE;
	END IF;
END$$
DELIMITER ;


#Elegxei an o ekastote user exei kanei 3 aithseis (an exei kanei 3 epistrefei false)
DROP FUNCTION IF EXISTS CheckIfApplicantHasLessThan3ApplicationsActive; #WORKING
DELIMITER $$
CREATE FUNCTION CheckIfApplicantHasLessThan3ApplicationsActive (username VARCHAR(30))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	DECLARE NoJobsApplied INT;
	SELECT COUNT(*) INTO NoJobsApplied FROM APPLIES WHERE cand_username = username AND application_status = 'active';
  IF NoJobsApplied < 3 THEN
		RETURN TRUE;
  ELSE
		RETURN FALSE;
	END IF;
END$$
DELIMITER ;


#Elegxei an kapoia aithsh kapoiou user mporei na akurwthei
#Elegxei an h mera pou paei na ginei cancell kapoia aithsh einai 10 meres prin thn enarksh (an einai 10 epistrefei true)
DROP FUNCTION IF EXISTS CheckIfApplicationIsCancellable; #WORKING
DELIMITER $$
CREATE FUNCTION CheckIfApplicationIsCancellable (username VARCHAR(30), _job_id INT(11))
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
	DECLARE Job_start_date DATE;
	#DECLARE DateDifference INT;
	SELECT start_date INTO Job_start_date FROM job WHERE job_id = _job_id;
	
    IF((SELECT DATEDIFF(Job_Start_date, CURDATE()) AS DAYS) >=10)THEN
		RETURN TRUE;
	ELSE
		RETURN FALSE;
	END IF;
END $$
DELIMITER ;





# 3.1.2.2 #
DROP PROCEDURE IF EXISTS CalculateAndAssignGrades;
DELIMITER $$
CREATE PROCEDURE CalculateAndAssignGrades(IN _job_id INT(11))
BEGIN
	
DECLARE done INT DEFAULT FALSE;
DECLARE candi_username VARCHAR(30);
DECLARE username_on_ltable VARCHAR(30);
DECLARE avg_grade FLOAT;
DECLARE high_avg_grade DECIMAL(3,1);
DECLARE v1_grade INT;
DECLARE v2_grade INT;
DECLARE ev1_usr VARCHAR(30);
DECLARE ev2_usr VARCHAR(30);
DECLARE total_points FLOAT;
DECLARE total_points_lang INT;
DECLARE total_points_degree_ INT;
DECLARE points_projects INT;
DECLARE calculated_ev_1_points DECIMAL(2,1);
DECLARE calculated_ev_2_points DECIMAL(2,1);
DECLARE cur CURSOR FOR SELECT cand_username, Evaluator1_user, Evaluator1_grade, Evaluator2_user, Evaluator2_grade FROM applies WHERE job_id = _job_id AND application_status = 'ACTIVE';
DECLARE cur_for_cancelled CURSOR FOR SELECT cand_username, Evaluator1_user, Evaluator2_user FROM applies WHERE job_id = _job_id AND application_status = 'CANCELLED'; 
DECLARE cursOnlocal_table CURSOR FOR SELECT name_ FROM Users_and_theirAverage WHERE job_id = _job_id; 
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

DROP TABLE IF EXISTS Users_and_theirAverage ;
CREATE TABLE Users_and_theirAverage (
	name_ VARCHAR(30),
    average DECIMAL(3,1),
    job_id INT(11)
);

	OPEN cur_for_cancelled;
    cancelled_applications: LOOP
		FETCH cur_for_cancelled INTO candi_username, ev1_usr, ev2_usr;
        IF done THEN LEAVE cancelled_applications; END IF;
        INSERT INTO ApplicationsHistory (candi_username_history, Eval1_username, Eval2_username, job_id, App_status, Average_grade, Got_the_job)
			VALUES (candi_username, ev1_usr, ev2_usr, _job_id, DEFAULT, 0, FALSE);
    END LOOP;
    CLOSE cur_for_cancelled;
    SET done = FALSE;
  OPEN cur;
  read_loop: LOOP
    FETCH cur INTO candi_username, ev1_usr, v1_grade, ev2_usr, v2_grade;
    IF done THEN LEAVE read_loop; END IF;
				IF v1_grade < 1 AND v2_grade>1 THEN 
					SET total_points_degree_ = (SELECT SUM(CASE d.bathmida WHEN 'BSc' THEN 1 WHEN 'MSc' THEN 2 WHEN 'PhD' THEN 3 ELSE 0 END)
					FROM (has_degree hd JOIN degree d ON hd.degr_title = d.titlos AND hd.degr_idryma = d.idryma) WHERE hd.cand_username = candi_username);
				  
					SELECT COUNT(*) INTO points_projects FROM project WHERE cand_id = candi_username;
					SELECT COUNT(DISTINCT lang) INTO total_points_lang FROM languages 
						WHERE cand_id = candi_username AND (FIND_IN_SET('EN', lang) > 0 OR FIND_IN_SET('GE', lang) > 0); #PaRAdOxi oti def lang gr
					SET calculated_ev_1_points = total_points_degree_ + total_points_lang + points_projects;
					SET avg_grade = (calculated_ev_1_points + v2_grade) / 2;
						
				ELSEIF v2_grade < 1 AND v1_grade > 1 THEN
					SET total_points_degree_ = (SELECT SUM(CASE d.bathmida WHEN 'BSc' THEN 1 WHEN 'MSc' THEN 2 WHEN 'PhD' THEN 3 ELSE 0 END)
					FROM (has_degree hd JOIN degree d ON hd.degr_title = d.titlos AND hd.degr_idryma = d.idryma) WHERE hd.cand_username = candi_username);
					
					SELECT COUNT(*) INTO points_projects FROM project WHERE cand_id = candi_username;
					SELECT COUNT(DISTINCT lang) INTO total_points_lang FROM languages 
						WHERE cand_id = candi_username AND (FIND_IN_SET('EN', lang) > 0 OR FIND_IN_SET('GE', lang) > 0); #PaRAdOxi oti def lang gr
					SET calculated_ev_2_points = total_points_degree_ + total_points_lang + points_projects;
					SET avg_grade = (v1_grade + calculated_ev_2_points) / 2;
                    
				ELSEIF v2_grade < 1 AND v1_grade < 1 THEN
					SET total_points_degree_ = (SELECT SUM(CASE d.bathmida WHEN 'BSc' THEN 1 WHEN 'MSc' THEN 2 WHEN 'PhD' THEN 3 ELSE 0 END)
					FROM (has_degree hd JOIN degree d ON hd.degr_title = d.titlos AND hd.degr_idryma = d.idryma) WHERE hd.cand_username = candi_username);
					
					SELECT COUNT(*) INTO points_projects FROM project WHERE cand_id = candi_username;
					SELECT COUNT(DISTINCT lang) INTO total_points_lang FROM languages 
						WHERE cand_id = candi_username AND (FIND_IN_SET('EN', lang) > 0 OR FIND_IN_SET('GE', lang) > 0); #PaRAdOxi oti def lang gr
					SET calculated_ev_2_points = total_points_degree_ + total_points_lang + points_projects;
					SET calculated_ev_1_points = total_points_degree_ + total_points_lang + points_projects;
					SET avg_grade = (v1_grade + v2_grade) / 2;
			ELSE
				SET avg_grade = (v1_grade + v2_grade) / 2;
				SET avg_grade = (SELECT CONVERT(avg_grade, DECIMAL(3,1)));
			END IF;

        INSERT INTO ApplicationsHistory (candi_username_history, Eval1_username, Eval2_username, job_id, App_status, Average_grade, Got_the_job)
			VALUES (candi_username, ev1_usr, ev2_usr, _job_id, DEFAULT, avg_grade, FALSE);
        
        INSERT INTO Users_and_theirAverage VALUES (candi_username,avg_grade,_job_id);
	END LOOP;
    SET done = FALSE;
	CLOSE cur;
    
    SET high_avg_grade = (SELECT MAX(average) FROM Users_and_theirAverage WHERE job_id = _job_id);
	OPEN cursOnlocal_table;
    
    Update_application_history: LOOP #Me got the job true opou high_average_grade = me average
        FETCH cursOnlocal_table INTO username_on_ltable;
        IF done THEN LEAVE Update_application_history; END IF;
		UPDATE ApplicationsHistory SET Got_the_job = TRUE WHERE job_id = _job_id AND username_on_ltable = candi_username_history AND average_grade = high_avg_grade;
    END LOOP;
	DROP TABLE IF EXISTS Users_and_theirAverage;
    CLOSE cursOnlocal_table;
END $$
DELIMITER ;



#Checks got_the_job and assigns correct got_the_job
DROP PROCEDURE IF EXISTS WhatDidHeSaaaay; #WORKING
DELIMITER $$
CREATE PROCEDURE WhatDidHeSaaaay (IN jobid INT(11))
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE temp_applicant_username1 VARCHAR(30);
    DECLARE temp_applicant_username2 VARCHAR(30);
	DECLARE PosaGotTheJobUparxoun INT;
	DECLARE temp_date1 DATE;
	DECLARE temp_date2 DATE;
    DECLARE datedif INT;
	DECLARE GotTheJobC bool;
    DECLARE usr VARCHAR(30);
	DECLARE got_the_job_true_cursor CURSOR FOR SELECT Got_the_job, candi_username_history FROM ApplicationsHistory WHERE job_id = jobid AND Got_the_job = TRUE;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    SET temp_applicant_username1 = NULL;
    SET temp_applicant_username2 = NULL;
  
		OPEN got_the_job_true_cursor;
		SELECT COUNT(*) FROM ApplicationsHistory WHERE Got_the_job = TRUE INTO PosaGotTheJobUparxoun;
			IF (PosaGotTheJobUparxoun > 1) THEN
            
				Loopa: LOOP
					FETCH got_the_job_true_cursor INTO GotTheJobC, usr;
                    IF done THEN LEAVE Loopa; END IF;
						IF (temp_applicant_username1 IS NULL) THEN
							SET temp_applicant_username1 = usr;
                            SELECT Sumbission_date INTO temp_date1 FROM applies WHERE cand_username = temp_applicant_username1 AND job_id = jobid;
							
                            IF(temp_applicant_username2 IS NULL) THEN
								FETCH NEXT FROM got_the_job_true_cursor INTO GotTheJobC, usr;
                                SELECT Sumbission_date INTO temp_date2 FROM applies WHERE cand_username = usr AND job_id = jobid;
								set temp_applicant_username2 = usr;
                                END IF;
                                
						ELSEIF (temp_applicant_username2 IS NULL) THEN
							FETCH NEXT FROM got_the_job_true_cursor INTO GotTheJobC, usr;
							SELECT Sumbission_date INTO temp_date2 FROM applies WHERE cand_username = usr AND job_id = jobid;
                            set temp_applicant_username2 = usr;
						END IF;
                     
                        IF((SELECT DATEDIFF(temp_date1, temp_date2)) < 0) THEN
							UPDATE ApplicationsHistory SET Got_the_job = FALSE WHERE candi_username_history = temp_applicant_username2 AND job_id = jobid;
                            SET temp_applicant_username2 = NULL;
                            
						ELSEIF ((SELECT DATEDIFF(temp_date1, temp_date2)) > 0) THEN
                            UPDATE ApplicationsHistory SET Got_the_job = FALSE WHERE candi_username_history = temp_applicant_username1 AND job_id = jobid;
                            SET temp_applicant_username1 = NULL;
						ELSE
							SELECT 'Dates are the same. Contact DBA.' AS MESSAGE;
                        END IF;
				END LOOP Loopa;
				CLOSE got_the_job_true_cursor;
			END IF;
        DELETE FROM applies WHERE job_id = jobid;
END$$ 
DELIMITER ;



# 3.1.3.1 #
DROP procedure IF EXISTS EvaluatorGradeCheck; #WORKING
DELIMITER $$
CREATE PROCEDURE EvaluatorGradeCheck(IN eval_username VARCHAR(30), empl_username VARCHAR(30), id_job INT(11), OUT grade DECIMAL(2,1))
BEGIN
	DECLARE evaluator VARCHAR(30);
	DECLARE employee VARCHAR(30);
	DECLARE id INT(11);
	DECLARE total_points_degree_ INT;
	DECLARE final_grade INT;
	DECLARE points_projects INT;
	DECLARE total_points_lang INT;
	DECLARE eval1_user VARCHAR(30);
	DECLARE eval2_user VARCHAR(30);
  
	IF ((SELECT Evaluator1_user FROM applies WHERE job_id = id_job AND cand_username = empl_username) IS NOT NULL) THEN
		SET eval1_user = (SELECT evaluator1_user FROM applies WHERE job_id = id_job AND cand_username = empl_username);
		IF (eval1_user = eval_username) THEN
			SET final_grade = (SELECT Evaluator1_grade FROM applies WHERE job_id = id_job AND cand_username = empl_username);
			IF (final_grade < 1) THEN
				#ypologismos vathmou apo pinaka 2
				SET total_points_degree_ = (SELECT SUM(CASE d.bathmida WHEN 'BSc' THEN 1 WHEN 'MSc' THEN 2 WHEN 'PhD' THEN 3 ELSE 0 END)
											FROM has_degree hd JOIN degree d ON hd.degr_title = d.titlos AND hd.degr_idryma = d.idryma 
											WHERE hd.cand_username = empl_username);
				SELECT COUNT(*) INTO points_projects FROM project WHERE cand_id = empl_username;
				SELECT COUNT(DISTINCT lang) INTO total_points_lang FROM languages 
					WHERE cand_id = empl_username AND (FIND_IN_SET('EN', lang) > 0 OR FIND_IN_SET('GE', lang) > 0); #PaRAdOxi oti def lang gr
                SET final_grade = total_points_degree_ + total_points_lang + points_projects;
			END IF;
		ELSEIF ((SELECT Evaluator2_user FROM applies WHERE job_id = id_job AND cand_username = empl_username) IS NOT NULL) THEN
			SET eval2_user = (SELECT evaluator1_user FROM applies WHERE job_id = id_job AND cand_username = empl_username);
			IF (eval2_user = eval_username) THEN
				SET final_grade = (SELECT Evaluator2_grade FROM applies WHERE job_id = id_job AND cand_username = empl_username);
				IF (final_grade < 1) THEN
					#ypologismos vathmou apo pinaka 2
					SET total_points_degree_ = (SELECT SUM(CASE d.bathmida WHEN 'BSc' THEN 1 WHEN 'MSc' THEN 2 WHEN 'PhD' THEN 3 ELSE 0 END)
											FROM has_degree hd JOIN degree d ON hd.degr_title = d.titlos AND hd.degr_idryma = d.idryma 
                                            WHERE hd.cand_username = empl_username);
					SELECT COUNT(*) INTO points_projects FROM project WHERE cand_id = empl_username;
					SELECT COUNT(DISTINCT lang) INTO total_points_lang FROM languages 
						WHERE cand_id = empl_username AND (FIND_IN_SET('EN', lang) > 0 OR FIND_IN_SET('GE', lang) > 0); #PaRAdOxi oti def lang gr
                    SET final_grade = total_points_degree_ + total_points_lang + points_projects;
				END IF;
			ELSE
				SET final_grade = 0;
			END IF;
		END IF;
	ELSE 
		SET final_grade = 0;
	END IF;

SELECT final_grade;
END$$
DELIMITER ;





# 3.1.3.2 
#Analoga to input tou xrhsth -> Isert, cancell, reactivate
DROP PROCEDURE IF EXISTS InsertCancellREactivate_applications; # WORKING
DELIMITER $$
CREATE PROCEDURE InsertCancellREactivate_applications(IN applicant VARCHAR(30), id INT(11), selection_ CHAR(1))
BEGIN
	DECLARE selection CHAR(1);
    DECLARE firm CHAR(9);
	DECLARE eval1_uname VARCHAR(30);
	DECLARE eval2_uname VARCHAR(30);
	DECLARE ApplicationDeadlineCheck BOOL;
	DECLARE CheckIfApplicantHasLessThan3ApplicationsActive BOOL;
	DECLARE CheckIfApplicationIsCancellable BOOL;
    declare username VARCHAR(30);
    declare jobid INT(11);
    declare today date;
    SET today = (SELECT (CURDATE()));
    SET CheckIfApplicationIsCancellable = CheckIfApplicationIsCancellable(applicant,id);
	SET ApplicationDeadlineCheck = ApplicationDeadlineCheck(id);
	SET CheckIfApplicantHasLessThan3ApplicationsActive = CheckIfApplicantHasLessThan3ApplicationsActive(applicant);
	
    select CheckIfApplicationIsCancellable as message;


	CASE selection_ 
    
		WHEN 'i' THEN  #WORKING
			IF (ApplicationDeadlineCheck AND CheckIfApplicantHasLessThan3ApplicationsActive) THEN
				set eval1_uname = (SELECT evaluator1 FROM job WHERE job_id = id);
                set eval2_uname = (SELECT evaluator2 FROM job WHERE job_id = id);
                SET firm = (SELECT firm FROM evaluator WHERE username = eval1_uname);

				IF eval2_uname IS NULL THEN
					#asign eval2                    
                    set eval2_uname = (SELECT MIN(username) FROM evaluator WHERE firm = firm ORDER BY username LIMIT 1);
                    SELECT eval1_uname, eval2_uname, firm;
                    UPDATE job SET evaluator2 = eval2_uname WHERE id = id;
                    INSERT INTO applies VALUES (applicant,id,DEFAULT,eval1_uname,0,eval2_uname,0,CURDATE());
					SELECT 'Application sumbited.' AS MESAGE;
                ELSE
					#proceed to application                    
                    INSERT INTO applies VALUES (applicant,id,DEFAULT,eval1_uname,0,eval2_uname,0,CURDATE());
					SELECT 'Application sumbited.' AS MESAGE;
                END IF;
            ELSE
				SELECT 'Either deadline for applications has passed, or user already has 3 applications active.' AS MESSAGE;
			END IF;
        
        
        
    WHEN 'c' THEN #WORKING
			IF (CheckIfApplicationIsCancellable) THEN
				IF (SELECT Application_status FROM applies WHERE cand_username = applicant AND job_id = id) = 'active' THEN
					UPDATE applies SET cand_username = applicant, Application_status = 'cancelled', job_id = id WHERE cand_username = applicant AND job_id = id;
                    SELECT 'Application cancelled.' AS MESSAGE;
				ELSEIF (SELECT Application_status FROM applies WHERE cand_username = applicant AND job_id = id) = 'cancelled' THEN
					SELECT 'Application allready cancelled.' AS MESSAGE;
				ELSE 
					SELECT 'Application not found.' AS MESSAGE;
				END IF;
			ELSE
				SELECT 'Application cannot be cancelled as the 10 days before cancellation requirement have passed.' AS MESSAGE;
			END IF;
         
         
         
    WHEN 'a' THEN #WORKING
			IF (ApplicationDeadlineCheck AND CheckIfApplicantHasLessThan3ApplicationsActive) THEN   
				IF (SELECT Application_status FROM applies WHERE cand_username = applicant AND job_id = id) = 'cancelled' THEN
					UPDATE applies SET Application_status = 'active' WHERE cand_username = applicant AND job_id = id;
                    SELECT 'Application activated' AS MESSAGE;
				ELSEIF (SELECT Application_status FROM applies WHERE cand_username = applicant AND job_id = id) = 'active' THEN
					SELECT 'Application allready active.' AS MESSAGE;
				ELSE 
					SELECT 'Application not found.' AS MESSAGE;
				END IF;
			ELSE
				SELECT 'Either deadline for applications has passed, or user already has 3 applications active.' AS MESSAGE;
			END IF;
    ELSE
		SELECT 'Wrong input' AS MESSAGE;
	END CASE;
END$$
DELIMITER ;


# 3.1.3.3 #
DROP PROCEDURE IF EXISTS CallAllToFinishJob;
DELIMITER $$
create procedure CallAllToFinishJob (IN jobid INT(11))
BEGIN
	CALL CalculateAndAssignGrades(jobid);
    CALL WhatDidHeSaaaay(jobid);
END $$
DELIMITER ;


# 3.1.3.4 A#
DROP procedure if exists procedure2; # WORKING
DELIMITER $$
create procedure procedure2 (IN vathmos1 Decimal(3,1), vathmos2 Decimal(3,1))
BEGIN
	SELECT candi_username_history, job_id FROM ApplicationsHistory WHERE (Average_grade BETWEEN vathmos1 AND vathmos2);
END $$
DELIMITER ;

# 3.1.3.4 B# 
DROP procedure if exists procedure3; # WORKING
DELIMITER $$
create procedure procedure3 (IN eva_username varchar(30))
BEGIN
	SELECT candi_username_history, job_id FROM ApplicationsHistory WHERE Eval1_username = eva_username OR Eval2_username = eva_username;
END $$
DELIMITER ;



# TRIGGEERS #
# 3.1.4.1 #
DROP TRIGGER IF EXISTS job_insert_trigger; # WORKING
DELIMITER $$
CREATE TRIGGER job_insert_trigger AFTER INSERT ON job FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'INSERT', 'job', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS job_update_trigger; # WORKING
DELIMITER $$
CREATE TRIGGER job_update_trigger AFTER UPDATE ON job FOR EACH ROW
BEGIN
	INSERT INTO logfiles 
		VALUES (CURRENT_USER(),'UPDATE', 'job', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS job_delete_trigger; # WORKING
DELIMITER $$
CREATE TRIGGER job_delete_trigger AFTER DELETE ON job FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'DELETE', 'job', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS user_inserttrigger; # WORKING
DELIMITER $$
CREATE TRIGGER user_inserttrigger
AFTER INSERT ON user
FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'INSERT', 'user', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS user_updatetrigger; # WORKING
DELIMITER $$
CREATE TRIGGER user_updatetrigger
AFTER UPDATE ON user
FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'UPDATE', 'user', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS user_deletetrigger; # WORKING
DELIMITER $$
CREATE TRIGGER user_deletetrigger
AFTER DELETE ON user
FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'DELETE', 'user', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS degree_update_trigger; # WORKING
DELIMITER $$
CREATE TRIGGER degree_update_trigger
AFTER UPDATE ON degree
FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'UPDATE', 'degree', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS degree_delete_trigger; # WORKING
DELIMITER $$
CREATE TRIGGER degree_delete_trigger
AFTER DELETE ON degree
FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'DELETE', 'degree', NOW());
END $$
DELIMITER ;


DROP TRIGGER IF EXISTS degree_insert_trigger; # WORKING
DELIMITER $$
CREATE TRIGGER degree_insert_trigger
AFTER INSERT ON degree
FOR EACH ROW
BEGIN
	INSERT INTO logfiles
		VALUES (CURRENT_USER(),'INSERT', 'degree', NOW());
END $$
DELIMITER ;


# 3.1.4.2 #
DROP TRIGGER IF EXISTS CheckBeforeApply; # WORKING
DELIMITER $$
CREATE TRIGGER CheckBeforeApply BEFORE INSERT ON applies FOR EACH ROW
BEGIN
	DECLARE applications BOOL;
	DECLARE deadline BOOL;
	SET applications = CheckIfApplicantHasLessThan3ApplicationsActive(new.cand_username);
	SET deadline = ApplicationDeadlineCheck(new.job_id);
  
	IF (applications = FALSE AND deadline = FALSE) THEN
		signal sqlstate '45000' set message_text = 'Either deadline for applications has passed, or user already has 3 applications active.';
	END IF;
END $$
DELIMITER ;


# 3.1.4.3 #
DROP TRIGGER IF EXISTS UpdateApplications; # WORKING
DELIMITER $$
CREATE TRIGGER UpdateApplications BEFORE UPDATE ON applies FOR EACH ROW
BEGIN
	DECLARE applications BOOL;
	DECLARE cancellable BOOL;
	SET cancellable = CheckIfApplicationIsCancellable(new.cand_username, new.job_id);
	SET applications = CheckIfApplicantHasLessThan3ApplicationsActive(new.cand_username);
  
	IF (cancellable = FALSE) THEN
		signal sqlstate '45000' set message_text = '15 days before cancellation of application have passed. Application can not be cancelled.';
	END IF;
	IF (applications = FALSE) THEN
		signal sqlstate '45000' set message_text = 'Candidate allready has 3 active applications. Application can not be cancelled.';
	END IF;
END $$
DELIMITER ;



#################################################################################################################################

DROP PROCEDURE IF EXISTS test; #vazei 10k entries sto applications history
DELIMITER $
CREATE PROCEDURE test()
BEGIN
DECLARE i INT UNSIGNED DEFAULT 0;
declare e_uname varchar(30);
declare ev1_uname varchar(30);
declare ev2_uname varchar(30);
declare id int(11);
declare vathmos int;
declare got_or_not int;

WHILE i < 10000 DO 
	SET id = (SELECT FLOOR(RAND()*2147483647));
    SET vathmos = (SELECT FLOOR(RAND() * 20) + 1);
	set got_or_not =(SELECT FLOOR(RAND() * 2));
	set e_uname = CONCAT('user_', (SELECT FLOOR(RAND() * 1000000)));
    set ev1_uname = CONCAT('eval1_', (SELECT FLOOR(RAND() * 1000000)));
    set ev2_uname = CONCAT('eval2_', (SELECT FLOOR(RAND() * 1000000)));
    INSERT INTO applicationshistory VALUES (e_uname, ev1_uname, ev2_uname, id, 'FINISHED', vathmos, got_or_not);
    SET i = i + 1;
END WHILE;
COMMIT; 
END $
DELIMITER ;


DROP PROCEDURE IF EXISTS debuggg;
DELIMITER $$
CREATE PROCEDURE debuggg()
BEGIN
	DECLARE deadline BOOL;
    DECLARE less_than_3 BOOL;
    DECLARE cancellable BOOL;
    DECLARE test INT;
    
    #select count(*) from applicationshistory;
    #CALL test();
    
    #select 'what did he say' as message;
    call WhatDidHeSaaaay(10);
    select * from applicationshistory;
    
    #slect 'calculate and asign grades' as message;
    #select * from applies where job_id = 10;
    #select * from applicationshistory;
    #call CalculateAndAssignGrades(10);
    #select * from applicationshistory;
    
    #select 'insert on applies trigger' as message;
    #select * from applies;
    #insert into applies values ('mark.evans','11','active','vlasis_restas',0,'koukloux_klanios',0,CURDATE());
    #select * from applies where cand_username = 'mark.evans';
    #select * from logfiles;  
    
    #select 'insert on degree trigger' as message;
    #select * from logfiles;
    #insert into degree values ('true_ceidas','CEID','BSc');
    #select * from degree where idryma = 'CEID';
    #select * from logfiles;
    
    #select 'insert on user trigger' as message;
    #select * from logfiles;
    #insert into user values ('pigkouinos','pigkouinaki','kurios','pigkouinos',CURDATE(),'kurios.pigkouinos@igklou.is');
    #select * from user where username = 'pigkouinos';
    #select * from logfiles;
    
    #select 'insert on job trigger' as message;
    #select * from logfiles;
    #insert into job values (NULL,'2024-08-03',14000,'test','kolokotronitsi','vlasis_restas','sophia.lopez',CURDATE(),CURDATE());
    #select * from job where edra = 'kolokotronitsi';
    #select * from logfiles;
    
    #SELECT 'procedure3' as message;
    #CALL procedure3('vlasis_restas');
    
    #SELEECT 'procedure 2' as message;
    #CALL procedure2(5,17);
    
    #SELECT 'Call all to finish job' as message;
    #SELECT * FROM APPLIES;
    #SELECT * FROM APPLICATIONSHISTORY;
    #CALL CallAllToFinishJob(10);
    #SELECT * FROM APPLIES;
    #SELECT * FROM APPLICATIONSHISTORY;
    
    #select 'evaluator grade check' as message;
    #SELECT * from applies where cand_username = 'jessica.clark' and job_id = 10;
    #select * from languages where cand_id = 'jessica.clark';
    #select * FROM (has_degree hd JOIN degree d ON hd.degr_title = d.titlos AND hd.degr_idryma = d.idryma) WHERE hd.cand_username = 'jessica.clark';
    #CALL EvaluatorGradeCheck('vlasis_restas', 'jessica.clark', 10, test);
    
    #select 'application deadline check' as message;
    #select * from job as message;
    #SET deadline = ApplicationDeadlineCheck(1);
    #SELECT 'deadline' AS 'Procedure', '1' AS 'Job', deadline AS 'In deadline';
    #SET deadline = ApplicationDeadlineCheck(2);
    #SELECT 'Deadline' AS 'Procedure', '2' AS 'Job', deadline AS 'In deadline';
    
    #select 'check if applicant has less than 3 applications acrive' as message;
    #SET less_than_3 = CheckIfApplicantHasLessThan3ApplicationsActive('olivia.martin');
    #SELECT 'Less than 3 applications' AS 'Procedure', 'olivia.martin' AS 'User', less_than_3 AS 'True / False';
    #SET less_than_3 = CheckIfApplicantHasLessThan3ApplicationsActive('chris.jones');
    #SELECT 'Less than 3 applications' AS 'Procedure', 'chris.jones' AS 'User', less_than_3 AS 'True / False';
    
    #select 'check if application is cancellable' as message;
	#SET cancellable = CheckIfApplicationIsCancellable('dimitris_restas',10);
    #SELECT 'Cancellable' AS 'Procedure', 'dimitris_restas' AS 'User', '10' AS 'Job', cancellable AS 'Cancellable';
    #SET cancellable = CheckIfApplicationIsCancellable('jessica.clark',2);
    #SELECT 'Cancellable' AS 'Procedure', 'jessica.clark' AS 'User', '2' AS 'Job', cancellable AS 'Cancellable';
END$$
DELIMITER ;
CALL debuggg();