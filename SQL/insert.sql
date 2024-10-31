/*				Project_Vaseis_Dedomenon_2023-24, CEID.UPATRAS				*/
/*				
				Christos_Dimitrakopoulos, chris.dimitrako@ac.upatras.gr
				Bertsekas_Paraskevas-Sotirios, up1093445@ac.upatras.gr
				Laurentius_Ioannis, up1093441@ac.upatras.gr


						------CONTAINS------
                                
EVERY INSERT QUERY NEEDED FOR DATABASE TO WORK. DATA MAY NOT BE ENOUGH FOR
TESTING PURPOSES. REFER TO functions.sql FOR DEBUGGING.

*/

use project;

INSERT INTO user (username, password, name, lastname, reg_date, email) VALUES
("alex.green", "AlGr@2023", "Alex", "Green", "2023-02-01", "alex.green@example.com"),
("chris.jones", "ChJo!2023", "Chris", "Jones", "2023-02-02", "chris.jones@example.com"),
("jessica.clark", "JessC2023#", "Jessica", "Clark", "2023-02-03", "jessica.clark@example.com"),
("mark.evans", "MarkE!23", "Mark", "Evans", "2023-02-04", "mark.evans@example.com"),
("emma.thomas", "EmTh@1", "Emma", "Thomas", "2023-02-05", "emma.thomas@example.com"),
("olivia.martin", "OliM!2023", "Olivia", "Martin", "2023-02-06", "olivia.martin@example.com"),
("daniel.jackson", "Djackson#1", "Daniel", "Jackson", "2023-02-07", "daniel.jackson@example.com"),
("sophia.lopez", "SLopez2023!", "Sophia", "Lopez", "2023-02-08", "sophia.lopez@example.com"),
("ryan.gonzalez", "RyG!nzalez", "Ryan", "Gonzalez", "2023-02-09", "ryan.gonzalez@example.com"),
("grace.harris", "GraceH123", "Grace", "Harris", "2023-02-10", "grace.harris@example.com"),
("ethan.lewis", "EthanL#2023", "Ethan", "Lewis", "2023-02-11", "ethan.lewis@example.com"),
("isabella.robinson", "IsaR@123", "Isabella", "Robinson", "2023-02-12", "isabella.robinson@example.com"),
("vlasis_restas", "vlasis@123", "Vlasis", "Restas", "2023-02-12", "toxrusoftiari@example.com"),
("Hugh_jass", "hugh@123", "Hugh", "Jass", "2023-02-12", "megaliterospanta@example.com"),
("koukloux_klanios", "klanios@123", "Koukloux", "Klanios", "2023-02-12", "oxiotifantazesai@example.com"),
("dimitris_restas", "dimitris@123", "Dimitris", "Restas", "2023-02-12", "toxrusoftiaributbetter@example.com"),
("john_doe", "john@123", "John", "Doe", "2023-02-13", "johndoe@example.com"),
("bob_jones", "bob@123", "Bob", "Jones", "2023-02-13", "bobjones@example.com"),
("alice.smith", "ali@123", "Alice", "Smith", "2023-02-13", "alicesm@example.com");

INSERT INTO employee (username, bio, sistatikes, certificates) VALUES
('alex.green', 'Experienced network engineer with a focus on security.', 'Recommended for complex network infrastructure projects.', 'Cisco Certified Network Associate'),
('chris.jones', 'Skilled in data analysis and visualization techniques.', 'Endorsed for data-driven decision-making processes.', 'Tableau Desktop Specialist'),
('jessica.clark', 'Dedicated customer support manager with a track record of improving client satisfaction.', 'Recommended for customer engagement and retention strategies.', 'Certified Customer Experience Professional'),
('mark.evans', 'Expert in renewable energy systems and sustainable technology.', 'Endorsed for innovative solutions in sustainability.', 'Certified Energy Manager'),
('emma.thomas', 'Professional event planner with extensive experience in corporate events.', 'Highly recommended for large-scale event management.', 'Certified Meeting Professional'),
('olivia.martin', 'Veteran public relations specialist with a knack for brand building.', 'Strongly endorsed for media relations and brand awareness campaigns.', 'Accredited in Public Relations'),
('dimitris_restas', 'Veteran gravedigger, specialized in premium graves.', 'Strongly endorsed for gravedigging and brand awareness campaigns.', 'Accredited gravedigging');

INSERT INTO etairia VALUES
('234567891', 'DOY1', 'Tech Trend Innovators', '888-404-5566', 'Innovation Drive', 21, 'Innovatown', 'Germany'),
('876543219', 'DOY2', 'Eco-Friendly Solutions Inc.', '999-505-6677', 'Greenway Ave.', 43, 'EcoCity', 'Australia'),
('876543221', 'DOY3', 'restas funerals', '999-505-6578', 'nikolaou', 53, 'ksenokastro', 'GREECE'),
('234234234', 'DOY4', 'Financial Elite Advisors', '111-606-7788', 'Money Street', 65, 'Financeville', 'Singapore');

INSERT INTO evaluator (username, exp_years, firm) VALUES
('daniel.jackson', 8, '234567891'),
('sophia.lopez', 6, '876543219'),
('ryan.gonzalez', 4, '234234234'),
('grace.harris', 3, '234567891'),
('ethan.lewis', 5, '876543219'),
('isabella.robinson', 7, '234234234'),
('john_doe',11,'876543219'),
('bob_jones', 13,'234567891'),
('koukloux_klanios', 14,'876543221'),
('vlasis_restas', 14,'876543221'),
('Hugh_jass', 14,'876543221'),
('alice.smith', 3,'234234234');

INSERT INTO DBAs (username,start_date,end_date) VALUES
('isabella.robinson', '2022-07-09', '2023-07-11'),
('Hugh_jass', '2021-05-09',NULL),
('ethan.lewis', '2023-07-11',NULL);

INSERT INTO subject (title, description, belongs_to) VALUES
('Cybersecurity', 'Understanding modern cybersecurity threats and defense mechanisms.', 'Cybersecurity'),
('Network Security', 'Advanced study of secure network design and threat prevention.', 'Network Security'),
('Data Analytics', 'Comprehensive coverage of data analysis techniques and tools.', 'Data Analytics'),
('Event Management', 'Core principles and strategies for successful event planning.', 'Event Management'),
('Corporate Event Planning', 'Specialized approaches to organizing corporate events.', 'Corporate Event Planning'),
('Public Relations', 'Strategies and tactics in public relations and media engagement.', 'Public Relations'),
('To xruso ftiari', 'Strategies and tactics in better grave digging', 'To xruso ftiari');

INSERT INTO project (cand_id, description, url) VALUES
('alex.green', 'Implementation of a secure enterprise network infrastructure.', 'https://example.com/network-security'),
('chris.jones', 'Comprehensive data analysis project for market research.', 'https://example.com/data-analysis'),
('jessica.clark', 'Customer service improvement project for a retail company.', 'https://example.com/customer-service'),
('mark.evans', 'Sustainability project focusing on renewable energy adoption.', 'https://example.com/sustainability'),
('emma.thomas', 'Corporate event planning for a major tech conference.', 'https://example.com/tech-event'),
('olivia.martin', 'Public relations campaign for a new startup.', 'https://example.com/pr-campaign'),
('dimitris_restas', 'Better grave digging strategies', 'https://example.com/restasfunerals');

INSERT INTO job (start_date, salary, position, edra, evaluator1, evaluator2, announcement_date, submission_date) VALUES
('2024-03-01', 55000, 'Network Engineer', 'Berlin', 'daniel.jackson', 'john_doe', '2023-01-01', '2023-01-15'),
('2022-11-15', 68000, 'Data Analyst', 'Sydney', 'sophia.lopez', 'alice.smith', '2023-01-05', '2023-01-20'),
('2023-07-08', 72000, 'Customer Support Manager', 'Tokyo', 'ryan.gonzalez', 'bob_jones', '2023-01-10', '2023-01-25'),
('2022-05-10', 63000, 'Sustainability Coordinator', 'Amsterdam', 'grace.harris', 'john_doe', '2023-01-15', '2023-01-30'),
('2023-11-10', 76000, 'Event Planner', 'London', 'ethan.lewis', 'alice.smith', '2023-01-20', '2023-02-04'),
('2022-12-20', 81000, 'PR Specialist', 'New York', 'isabella.robinson', 'bob_jones', '2023-01-25', '2023-02-09'),
('2023-06-19', 90000, 'IT Security Analyst', 'Paris', 'daniel.jackson', 'alice.smith', '2023-02-01', '2023-02-15'),
('2023-07-08', 58000, 'Market Researcher', 'Singapore', 'sophia.lopez', 'bob_jones', '2023-02-05', '2023-02-20'),
('2023-10-17', 59000, 'arxidologos', 'bangladesh', 'sophia.lopez', 'bob_jones', '2023-02-06', '2023-02-25'),
('2024-09-01', 69696, 'Koraki', 'Greece', 'vlasis_restas', 'koukloux_klanios', '2023-02-07', '2023-02-28'),
('2025-02-09', 69696, 'Korax', 'Greece', 'vlasis_restas', 'koukloux_klanios', '2023-02-07', '2023-02-28');

INSERT INTO degree VALUES
('Network Engineering', 'Georgia Institute of Technology', 'BSc'),
('Data Science', 'University of Oxford', 'BSc'),
('Customer Relations', 'University of Toronto', 'MSc'),
('Sustainability Studies', 'University of Copenhagen', 'BSc'),
('Event Planning', 'New York University', 'PhD'),
('Public Relations', 'University of Southern California', 'BSc'),
('Korakas', 'University of funerals elladistan', 'PhD');

INSERT INTO has_degree VALUES
('Network Engineering', 'Georgia Institute of Technology', 'alex.green', 2018, 8.6),
('Data Science', 'University of Oxford', 'chris.jones', 2019, 8.4),
('Customer Relations', 'University of Toronto', 'jessica.clark', 2017, 8.7),
('Sustainability Studies', 'University of Copenhagen', 'mark.evans', 2018, 8.3),
('Event Planning', 'New York University', 'emma.thomas', 2020, 8.5),
('Public Relations', 'University of Southern California', 'olivia.martin', 2019, 8.8),
('Korakas', 'University of funerals elladistan', 'dimitris_restas', 2019, 10.0);

INSERT INTO languages VALUES
('alex.green', 'EN,GR'),
('chris.jones', 'EN,GE'),
('jessica.clark', 'GR'),
('mark.evans', 'EN,GR'),
('emma.thomas', 'EN,GR'),
('olivia.martin', 'EN,GR'),
('dimitris_restas', 'EN,GR');

INSERT INTO requires VALUES
(1, 'Network Security'),
(1, 'Cybersecurity'),
(2, 'Data Analytics'),
(3, 'Public Relations'),
(4, 'Corporate Event Planning'),
(5, 'Event Management'),
(6, 'Public Relations'),
(7, 'Network Security'),
(7, 'Cybersecurity'),
(8, 'Data Analytics'),
(9, 'Event Management'),
(10, 'To xruso ftiari');

INSERT INTO applies VALUES
('dimitris_restas', 10, default, 'vlasis_restas', 18, 'koukloux_klanios', 17, '2023-04-10'),
('chris.jones', 10, default, 'vlasis_restas', 18, 'koukloux_klanios', 17, '2023-02-01'),
('chris.jones', 11, default, 'vlasis_restas', 18, 'koukloux_klanios', 17, '2023-02-01'),
('chris.jones', 1, default, 'daniel.jackson', 18, 'john_doe', 17, '2023-02-01'),
('alex.green', 10, 'CANCELLED', 'vlasis_restas', 18, 'koukloux_klanios', 17, '2023-02-5'),
('olivia.martin', 10, 'active', 'vlasis_restas', 18, 'koukloux_klanios', 17, '2023-02-06'),
('jessica.clark', 10, default,'vlasis_restas', 0, 'koukloux_klanios', 8, '2023-02-06'),
('jessica.clark',2,default,'sophia.lopez',0, 'alice.smith',0,'2023-02-06');