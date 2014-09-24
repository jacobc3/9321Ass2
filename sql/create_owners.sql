/*
 * INCLUDE:
 * owners
 * amenities
 * cinemas_amenities
 */

drop table owner;
create table owner (
	id INT NOT NULL auto_increment,
	username VARCHAR(40) NOT NULL unique,
	password VARCHAR(40) default NULL,
	PRIMARY KEY (id)
);
INSERT INTO owner (username,password) VALUES ("aaa","aaa");
INSERT INTO owner (username) VALUES ("bbb");
INSERT INTO owner (username) VALUES ("ccc");
INSERT INTO owner (username) VALUES ("owner1");
INSERT INTO owner (username) VALUES ("owner2");
INSERT INTO owner (username,password) VALUES ("owner3","pass");
INSERT INTO owner (username,password) VALUES ("owner4","pass");



drop table owner_cinema;
create table owner_cinema(
	owner_id INT,
	cinema_id INT,
	PRIMARY KEY(owner_id,cinema_id)
);

INSERT INTO owner_cinema VALUES (1,1);
INSERT INTO owner_cinema VALUES (1,2);
INSERT INTO owner_cinema VALUES (1,3);
INSERT INTO owner_cinema VALUES (1,4);
INSERT INTO owner_cinema VALUES (1,5);
INSERT INTO owner_cinema VALUES (1,6);
INSERT INTO owner_cinema VALUES (1,7);
INSERT INTO owner_cinema VALUES (2,1);

-- FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
-- FOREIGN KEY (amenity_id) REFERENCES amenities(id)
