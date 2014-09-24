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

drop table booking;
create table booking (
	id integer auto_increment NOT NULL,
	
	session_id int default NULL,
	user_id int default NULL,
	card_number int(16) default NULL,
	order_time DATETIME default NULL,
	count int default NULL,
	status ENUM('Processing','Approved','Denied') default NULL,
	PRIMARY KEY (id)
);

