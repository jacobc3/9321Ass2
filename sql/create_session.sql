/*
 * INCLUDE:
 * Moview Session
 * ticket_order
 * 
 */

drop table session;
create table session (
	id INT NOT NULL auto_increment,
	
	movie_id int default NULL,
	cinema_id int default NULL,	
	show_date DATE default NULL,
	PRIMARY KEY (id)
);

INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,2,"2013-05-30 15:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,2,"2013-05-30");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,3,"2013-05-30 17:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,4,"2013-05-30");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,5,"2015-06-30");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,6,"2012-07-30 19:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (2,2,"2011-01-30");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (3,2,"2013-12-30");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (4,3,"2016-05-30 20:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (5,4,"2013-05-30");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (6,5,"2013-05-30");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (7,6,"2013-05-30 23:00");


drop table booking;
create table booking (
	id integer auto_increment NOT NULL,
	
	session_id int default NULL,
	user_id int default NULL,
	
	card_number int(16) default NULL,
	order_time DATETIME default NULL,
	count int default 1,
	status ENUM('Processing','Approved','Denied') default NULL,
	PRIMARY KEY (id)
);

INSERT INTO booking (session_id,user_id) VALUES (7,6);
INSERT INTO booking (session_id,user_id) VALUES (1,7);
INSERT INTO booking (session_id,user_id) VALUES (1,8);
INSERT INTO booking (session_id,user_id) VALUES (1,7);
INSERT INTO booking (session_id,user_id) VALUES (1,6);
INSERT INTO booking (session_id,user_id) VALUES (1,5);
INSERT INTO booking (session_id,user_id) VALUES (1,4);
INSERT INTO booking (session_id,user_id) VALUES (1,3);
INSERT INTO booking (session_id,user_id) VALUES (7,6);
INSERT INTO booking (session_id,user_id) VALUES (2,7);
INSERT INTO booking (session_id,user_id) VALUES (2,8);
INSERT INTO booking (session_id,user_id) VALUES (3,7);
INSERT INTO booking (session_id,user_id) VALUES (4,6);
INSERT INTO booking (session_id,user_id) VALUES (2,5);
INSERT INTO booking (session_id,user_id) VALUES (2,4);
INSERT INTO booking (session_id,user_id) VALUES (2,3);


