/*
 * INCLUDE:
 * cinemas
 * amenity
 * cinema_amenitiy
 */

drop table cinema;
create table cinema (
	id INT NOT NULL auto_increment,
	name VARCHAR(40) default NULL,
	location VARCHAR(100) default NULL,
	capacity INT default NULL,
	PRIMARY KEY (id)
);

INSERT INTO cinema (name,location,capacity) VALUES ("Dendy Cinemas","73 Benny Street, EAST DEVONPORT TAS 7310", 35);
INSERT INTO cinema (name,location,capacity) VALUES ("Grand Cinemas","26 Hebbard Street, DANDENONG NORTH VIC 3175", 70);
INSERT INTO cinema (name,location,capacity) VALUES ("Reading Cinema","87 Bresnahans Lane,PADDYS RIVER NSW 2577", 135);
INSERT INTO cinema (name,location,capacity) VALUES ("Palace","17 Decca Road, WOODROFFE NT 0830", 22);
INSERT INTO cinema (name,location,capacity) VALUES ("Metro","67 Gaffney Street, FRANKSTON VIC 3199", 40);
INSERT INTO cinema (name,location,capacity) VALUES ("Event Cinemas","73 Farrar Parade, NANGETTY WA 6522", 50);
INSERT INTO cinema (name,location,capacity) VALUES ("Hoyts","72 Bayview Road, KOOLGERA SA 5661", 95);
INSERT INTO cinema (name,location,capacity) VALUES ("Hoyts Cinemas","83 Corio Street, WARNCOORT VIC 3243", 60);
INSERT INTO cinema (name,location,capacity) VALUES ("Wallis","76 Ugoa Street, TIRI NSW 2424", 122);


--Amenities : can not be changed by website.
drop table amenity;
create table amenity (
	id INT NOT NULL auto_increment,
	name VARCHAR(100) default NULL,
	PRIMARY KEY (id)
);
INSERT INTO amenity (name) VALUES ("Parking lot");
INSERT INTO amenity (name) VALUES ("Smoking area");
INSERT INTO amenity (name) VALUES ("Pet Allowed");
INSERT INTO amenity (name) VALUES ("First Aid");
INSERT INTO amenity (name) VALUES ("private screenings");
INSERT INTO amenity (name) VALUES ("group sale");
INSERT INTO amenity (name) VALUES ("business meetings");
INSERT INTO amenity (name) VALUES ("receptions");



drop table cinema_amenity;
create table cinema_amenity(
	cinema_id INT NOT NULL,
	amenity_id INT NOT NULL,
	PRIMARY KEY (cinema_id,amenity_id)
);

INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (1,1);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (1,2);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (1,3);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (1,4);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (1,5);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (1,6);

INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (2,1);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (2,2);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (2,3);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (2,4);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (2,5);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (2,7);

INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (3,1);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (3,5);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (3,7);

INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (4,1);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (4,2);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (4,3);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (4,4);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (4,5);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (4,8);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (4,7);

INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (5,7);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (5,1);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (5,5);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (5,7);

INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (8,7);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (8,1);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (8,5);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (8,7);

INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (9,7);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (9,1);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (9,5);
INSERT INTO cinema_amenity (cinema_id,amenity_id) VALUES (9,7);

