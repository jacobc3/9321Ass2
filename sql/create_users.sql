/*
 * INCLUDE:
 * users
 * review
 * 
 */

drop table user;
create table user (
	id INT NOT NULL auto_increment,
	username VARCHAR(40) NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL,
	
	email_ok CHAR(1) default 'N',	
	password VARCHAR(40) default NULL,
	firstname VARCHAR(40) default NULL,
	lastname VARCHAR(40) default NULL,
	registry_date DATE default NULL,
	nickname VARCHAR(40) default NULL,
	PRIMARY KEY (id)
);

INSERT INTO user (username,email,nickname) VALUES ("user1","user1@gmail.com","nickname1");
INSERT INTO user (username,email) VALUES ("user2","user2@gmail.com");
INSERT INTO user (username,email,password) VALUES ("user3","user2@gmail.com", "afwef23");
INSERT INTO user (username,email,firstname,lastname) VALUES ("user4","user2@gmail.com", "firstname","lastname");
INSERT INTO user (username,email,registry_date) VALUES ("user5","user5@gmail.com", "2013-03-05");
INSERT INTO user (username,email,firstname,password) VALUES ("user6","user6@gmail.com", "whatfirstname","waefa2124sf");
INSERT INTO user (username,email,password,nickname) VALUES ("user7","user7@gmail.com", "awgea3562","nickname7");
INSERT INTO user (username,email,email_ok) VALUES ("user8","user8@gmail.com", "Y");
INSERT INTO user (username,email,email_ok,nickname) VALUES ("user9","user9@gmail.com", "N","nickname9");
INSERT INTO user (username,email,email_ok) VALUES ("user9","user9@gmail.com", "Y");
INSERT INTO user (username,password,email,nickname) VALUES ("user10","pass","user9@gmail.com","nickname10");
INSERT INTO user (username,password,email) VALUES ("user11","pass","user9@gmail.com");

drop table review;
create table review (
	id INT NOT NULL auto_increment,
	title VARCHAR(40) NOT NULL,
	
	user_id int default NULL,
	movie_id int  default NULL,	
	post_date DATE default NULL,
	content TEXT default NULL,
	PRIMARY KEY (id)
);

INSERT INTO review (title) VALUES ("New Review");
INSERT INTO review (title,user_id) VALUES ("QSWEFAWEF",1);
INSERT INTO review (title,user_id) VALUES ("gaergawge4areg w4etfgaw4",1);
INSERT INTO review (title,user_id) VALUES ("QSWEFawga w awgAWEF",1);
INSERT INTO review (title,movie_id) VALUES ("New Review",2);
INSERT INTO review (title,movie_id) VALUES ("New Review122",2);
INSERT INTO review (title,movie_id) VALUES ("New Review1243",2);
INSERT INTO review (title,user_id,movie_id) VALUES ("New Review",2,2);
INSERT INTO review (title,user_id,movie_id) VALUES ("New Review",1,2);


