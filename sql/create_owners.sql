/*
 * INCLUDE:
 * owners
 * amenities
 * cinemas_amenities
 */

/**
 * after clarification:
 * only 1 owner in whole website, it can edit anything. Like 'root' account.
 */
drop table owner;
create table owner (
	id INT NOT NULL auto_increment,
	username VARCHAR(40) NOT NULL unique,
	password VARCHAR(40) default NULL,
	PRIMARY KEY (id)
);
INSERT INTO owner (username,password) VALUES ("aaa","aaa");