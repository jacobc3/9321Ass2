/*
 * INCLUDE:
 * users
 * review
 * 
 */

drop table user;
create table user (
	id INT NOT NULL auto_increment,
	username VARCHAR(40) NOT NULL,
	email VARCHAR(50) NOT NULL,
	
	email_ok ENUM('yes','no') default NULL,	
	password VARCHAR(40) default NULL,
	firstname VARCHAR(40) default NULL,
	lastname VARCHAR(40) default NULL,
	registry_date DATE default NULL,
	PRIMARY KEY (id)
);

INSERT INTO user (username,email) VALUES ("user1","user1@gmail.com");
INSERT INTO user (username,email) VALUES ("user2","user2@gmail.com");
INSERT INTO user (username,email,password) VALUES ("user3","user2@gmail.com", "afwef23");
INSERT INTO user (username,email,firstname,lastname) VALUES ("user4","user2@gmail.com", "firstname","lastname");
INSERT INTO user (username,email,registry_date) VALUES ("user5","user2@gmail.com", "2013-03-05");
INSERT INTO user (username,email,firstname,password) VALUES ("user6","user2@gmail.com", "whatfirstname","waefa2124sf");
INSERT INTO user (username,email,password) VALUES ("user7","user2@gmail.com", "awgea3562");
INSERT INTO user (username,email,email_ok) VALUES ("user8","user2@gmail.com", "yes");
INSERT INTO user (username,email,email_ok) VALUES ("user9","user2@gmail.com", "no");

drop table review;
create table review (
	id INT NOT NULL auto_increment,
	title VARCHAR(40) NOT NULL,
	
	user_id int,
	movie_id int,	
	post_date DATE default NULL,
	content TEXT default NULL,
	PRIMARY KEY (id)
);

INSERT INTO review (title) VALUES ("New Review");
INSERT INTO review (title,user_id) VALUES ("QSWEFAWEF",1);
INSERT INTO review (title,movie_id) VALUES ("New Review",2);
INSERT INTO review (title,movie_id) VALUES ("New Review122",2);
INSERT INTO review (title,movie_id) VALUES ("New Review1243",2);
INSERT INTO review (title,user_id,movie_id) VALUES ("New Review",2,2);
INSERT INTO review (title,user_id,movie_id) VALUES ("New Review",1,2);


