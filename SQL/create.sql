/*				Project_Vaseis_Dedomenon_2023-24, CEID.UPATRAS				*/
/*				
				Christos_Dimitrakopoulos, chris.dimitrako@ac.upatras.gr
				Bertsekas_Paraskevas-Sotirios, up1093445@ac.upatras.gr
				Laurentius_Ioannis, up1093441@ac.upatras.gr


						------CONTAINS------
                                
EVERY CREATE QUERY NEEDED FOR DATABASE TO WORK. TABLES MUST NOT CHANGE FOR 
DATABASE TO WORK. REFER TO functions.sql FOR DEBUGGING.

*/


DROP DATABASE IF EXISTS PROJECT;
CREATE DATABASE project;

use project;

CREATE TABLE user (
    username VARCHAR(30),
    password VARCHAR(20),
    name VARCHAR(255),
    lastname VARCHAR(35),
    reg_date datetime,
    email VARCHAR(50),
    PRIMARY KEY (username)
);

CREATE TABLE etairia (
    AFM CHAR(9),
    DOY VARCHAR(30),
    name VARCHAR(35),
    tel VARCHAR(12),
    street VARCHAR(25),
    num INT(11),
    city VARCHAR(45),
    country VARCHAR(15),
    PRIMARY KEY (AFM)
);

CREATE TABLE evaluator (
    username VARCHAR(30),
    exp_years INT(4),
    firm char(9),
    CONSTRAINT username1 FOREIGN KEY (username) REFERENCES user(username) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT FIRM FOREIGN KEY (firm) REFERENCES etairia(AFM) ON DELETE cascade ON UPDATE cascade,
    UNIQUE (username)
);
CREATE INDEX idx_employee_user ON user(username);
CREATE TABLE employee (
    username VARCHAR(30),
    bio text,
    sistatikes VARCHAR(200),
    certificates VARCHAR(200),
    CONSTRAINT username FOREIGN KEY (username) REFERENCES user(username) ON DELETE cascade ON UPDATE cascade,
    PRIMARY KEY (username)
);

CREATE TABLE DBAs (
	username VARCHAR(30),
    start_date DATE NOT NULL,
    end_date DATE,
    CONSTRAINT  FOREIGN KEY (username) REFERENCES user(username) ON DELETE cascade ON UPDATE cascade,
    UNIQUE (username)
);

CREATE TABLE languages (
    cand_id VARCHAR(30),
    lang set("EN", "GE", "GR"),
    CONSTRAINT LANGUAGES FOREIGN KEY (cand_id) REFERENCES employee(username) ON DELETE cascade ON UPDATE cascade
);

CREATE TABLE project (
    cand_id VARCHAR(30),
    num int(4) AUTO_INCREMENT PRIMARY KEY,
    description text,
    url varchar(60),
    CONSTRAINT PROJECT FOREIGN KEY (cand_id) REFERENCES employee(username) ON DELETE cascade ON UPDATE cascade
);

CREATE table job (
    job_id INT(11) AUTO_INCREMENT,
    start_date DATETIME,
    salary FLOAT(10,2),
    position VARCHAR(60),
    edra VARCHAR(60),
    evaluator1 varchar(30) NOT NULL,
    evaluator2 varchar(30),
    announcement_date DATETIME,
    submission_date DATE,
    PRIMARY KEY (job_id),
    CONSTRAINT JOB_EVALUATOR1 FOREIGN KEY (evaluator1) REFERENCES evaluator(username) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT JOB_EVALUATOR2 FOREIGN KEY (evaluator2) REFERENCES evaluator(username) ON DELETE cascade ON UPDATE cascade
);

CREATE TABLE subject (
    title VARCHAR(36),
    description TEXT,
    belongs_to VARCHAR(36) DEFAULT NULL,
    PRIMARY KEY (title),
    CONSTRAINT BELONGS_TO FOREIGN KEY (belongs_to) REFERENCES subject(title) ON DELETE cascade ON UPDATE cascade
);

CREATE TABLE requires (
    job_id INT(11),
    subject_title VARCHAR(36),
    CONSTRAINT JOB FOREIGN KEY (job_id) REFERENCES job(job_id) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT SUBJECT_TITLE FOREIGN KEY (subject_title) REFERENCES subject(title) ON DELETE cascade ON UPDATE cascade
);

CREATE TABLE applies (
    cand_username VARCHAR(30),
    job_id INT(11),
    Application_Status ENUM('active', 'finished', 'cancelled') NOT NULL DEFAULT 'active',
    Evaluator1_user VARCHAR(30),
    Evaluator1_grade INT CHECK (Evaluator1_grade BETWEEN 0 AND 20) NOT NULL,
    Evaluator2_user VARCHAR(30),
    Evaluator2_grade INT CHECK (Evaluator2_grade BETWEEN 0 AND 20) NOT NULL,
    Sumbission_date DATE NOT NULL,
    CONSTRAINT cand_username FOREIGN KEY (cand_username) REFERENCES employee(username) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT job_id FOREIGN KEY (job_id) REFERENCES job(job_id) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT eval1_username FOREIGN KEY (Evaluator1_user) REFERENCES job(evaluator1) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT eval2_username FOREIGN KEY (Evaluator2_user) REFERENCES job(evaluator2) ON DELETE cascade ON UPDATE cascade
);

CREATE TABLE degree (
    titlos VARCHAR(150),
    idryma VARCHAR(140),
    bathmida enum("BSc", "MSc", "PhD"),
    PRIMARY KEY (titlos, idryma)
);

CREATE TABLE has_degree(
    degr_title VARCHAR(150),
    degr_idryma VARCHAR(140),
    cand_username VARCHAR(30),
    etos year(4),  
    grade FLOAT(3,1),
    CONSTRAINT DEGREE FOREIGN KEY (cand_username) REFERENCES employee(username) ON DELETE cascade ON UPDATE cascade,
    CONSTRAINT DEGREE_FK FOREIGN KEY (degr_title, degr_idryma) REFERENCES degree(titlos, idryma) ON DELETE cascade ON UPDATE cascade
);

CREATE INDEX idx_App_status ON applies (Application_Status);
CREATE TABLE ApplicationsHistory(
	candi_username_history VARCHAR(30) NOT NULL,
    Eval1_username VARCHAR(30) NOT NULL DEFAULT 'Unknown',
	Eval2_username VARCHAR(30) NOT NULL DEFAULT 'Unknown',
    job_id INT(11) NOT NULL,
    App_status ENUM('active', 'finished', 'cancelled') NOT NULL DEFAULT 'finished',
    Average_grade DECIMAL(3,1) CHECK (Average_grade BETWEEN 0 AND 20),
    Got_the_job BOOL DEFAULT FALSE,
    PRIMARY KEY (candi_username_history, job_id)
);

CREATE TABLE logFiles(
	DBAusername VARCHAR(30) NOT NULL, #Username
    Edited ENUM('insert','update','delete') NOT NULL, #energeia
    Table_ ENUM('job','user','degree') NOT NULL, #poion pinaka
    Date datetime NOT NULL
);

CREATE INDEX vaggel ON ApplicationsHistory(candi_username_history,job_id);