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
	show_date datetime default NULL,
	PRIMARY KEY (id)
);

INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,2,"2013-05-30 15:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,2,"2013-05-30 17:30:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,3,"2013-05-30 17:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,4,"2013-05-30 19:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,5,"2015-06-30 19:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (1,6,"2012-07-30 19:00:00");

INSERT INTO session (movie_id,cinema_id,show_date) VALUES (2,2,"2011-01-30 19:00:00");

INSERT INTO session (movie_id,cinema_id,show_date) VALUES (3,2,"2013-12-30 19:00:00");

INSERT INTO session (movie_id,cinema_id,show_date) VALUES (4,3,"2016-05-30 20:00:00");

INSERT INTO session (movie_id,cinema_id,show_date) VALUES (5,4,"2013-05-30 19:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (5,5,"2013-05-30 19:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (5,6,"2013-05-30 19:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (5,1,"2013-05-30 13:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (5,2,"2013-05-30 15:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (5,3,"2013-05-30 15:00:00");


INSERT INTO session (movie_id,cinema_id,show_date) VALUES (6,5,"2013-05-30 19:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (6,5,"2013-05-30 11:00:00");
INSERT INTO session (movie_id,cinema_id,show_date) VALUES (6,5,"2013-05-30 13:00:00");

INSERT INTO session (movie_id,cinema_id,show_date) VALUES (7,6,"2013-05-30 23:00:00");


drop table booking;
create table booking (
	id integer auto_increment NOT NULL,
	
	session_id int default NULL,
	user_id int default NULL,
	
	card_number varchar(16) default NULL,
	order_time DATETIME default NULL,
	count int default 1,
	status ENUM('Processing','Approved','Denied') default 'Processing',
	PRIMARY KEY (id)
);

INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (7,6,random_datetime(),"375117733718406");
INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (1,7,random_datetime(),"370531406032744");
INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (1,8,random_datetime(),"342702748892542");
INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (1,7,random_datetime(),"371842001046289");
INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (1,6,now(),"342921713602948");
INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (1,5,now(),"374044169344252");
INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (1,4,now(),"373809417809772");
INSERT INTO booking (session_id,user_id,order_time,card_number) VALUES (1,3,now(),"340315615921112");
INSERT INTO booking (session_id,user_id,order_time,count,card_number) VALUES (7,6,random_datetime(),2,"376291731857125");
INSERT INTO booking (session_id,user_id,order_time,count,card_number) VALUES (2,7,random_datetime(),3,"341548731569238");
INSERT INTO booking (session_id,user_id,order_time,count,card_number) VALUES (2,8,random_datetime(),2,"374256908694298");
INSERT INTO booking (session_id,user_id,order_time,count,card_number,status) VALUES (3,7,random_datetime(),6,"344148475876704","Approved");
INSERT INTO booking (session_id,user_id,order_time,count,card_number,status) VALUES (4,6,random_datetime(),3,"349937228716794","Approved");
INSERT INTO booking (session_id,user_id,order_time,count) VALUES (2,5,random_datetime(),2);
INSERT INTO booking (session_id,user_id,order_time,count) VALUES (2,4,random_datetime(),2);
INSERT INTO booking (session_id,user_id,order_time,count,status) VALUES (2,1,random_datetime(),2,"Approved");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (1,1,random_datetime(),"Approved");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (7,1,random_datetime(),"Decline");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (2,1,random_datetime(),"Approved");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (2,1,random_datetime(),"Approved");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (3,1,random_datetime(),"Approved");

