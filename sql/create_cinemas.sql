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

INSERT INTO cinema (name,location,capacity) VALUES ("Dendy Cinemas","Pitt ST", 35);
INSERT INTO cinema (name,location,capacity) VALUES ("Grand Cinemas","George ST", 70);
INSERT INTO cinema (name,location,capacity) VALUES ("Reading Cinema","Liverpool ST", 135);
INSERT INTO cinema (name,location,capacity) VALUES ("Palace","Bondi Junction", 22);
INSERT INTO cinema (name,location,capacity) VALUES ("Metro","Randwick", 40);
INSERT INTO cinema (name,location,capacity) VALUES ("Event Cinemas","Liverpool", 50);
INSERT INTO cinema (name,location,capacity) VALUES ("Hoyts","Rhodes", 95);
INSERT INTO cinema (name,location,capacity) VALUES ("Hoyts Cinemas","Newton", 60);
INSERT INTO cinema (name,location,capacity) VALUES ("Wallis","ULTIMO", 122);


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


-- FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
-- FOREIGN KEY (amenity_id) REFERENCES amenities(id)
