/*
 * INCLUDE:
 * users
 * amenities
 * cinemas_amenities
 */

drop table users;
create table users (
	id INT NOT NULL auto_increment,
	name VARCHAR(40) default NULL,
	location VARCHAR(100) default NULL,
	capacity INT default NULL,
	PRIMARY KEY (id)
);
INSERT INTO users (name,location,capacity) VALUES ("ASMOF","PITT ST", 35);
INSERT INTO users (name,location,capacity) VALUES ("LMAO","GEORGE ST", 70);
INSERT INTO users (name,location,capacity) VALUES ("ZOFIMS","LIVERPOOL ST", 135);

--Amenities : can not be changed by website.
drop table amenities;
create table amenities (
	id INT NOT NULL auto_increment,
	name VARCHAR(100) default NULL,
	PRIMARY KEY (id)
);
INSERT INTO amenities (name) VALUES ("Parking lot");
INSERT INTO amenities (name) VALUES ("Smoking area");
INSERT INTO amenities (name) VALUES ("Pet Allowed");
INSERT INTO amenities (name) VALUES ("First Aid");

drop table cinemas_amenities;
create table cinemas_amenities(
	cinema_id INT NOT NULL,
	amenity_id INT NOT NULL,
	PRIMARY KEY (cinema_id,amenity_id)
);

INSERT INTO cinemas_amenities (cinema_id,amenity_id) VALUES (1,1);
INSERT INTO cinemas_amenities (cinema_id,amenity_id) VALUES (1,2);
INSERT INTO cinemas_amenities (cinema_id,amenity_id) VALUES (2,1);

-- FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
-- FOREIGN KEY (amenity_id) REFERENCES amenities(id)
