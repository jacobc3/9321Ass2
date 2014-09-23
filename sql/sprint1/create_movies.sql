/*
 * INCLUDE:
 * movies
 * genres
 * movies_genres
 */
drop table movies;
create table movies (
	id INT NOT NULL auto_increment,
	title VARCHAR(40) NOT NULL,
	release_date DATE default NULL,
	actors VARCHAR(100) default NULL,
	synopsis VARCHAR(400) default NULL,
	PRIMARY KEY (id)	
);

INSERT INTO movies (title,release_date,actors) VALUES ("BIG BANG","2011-05-20", "Luis,Pitter");
INSERT INTO movies (title,release_date,actors) VALUES ("BIG BANG2","2011-07-20", "Wow,Pitter");
INSERT INTO movies (title,release_date,actors) VALUES ("THE RIGHT","2013-12-20", "Luis,Magic");

drop table genres;
create table genres (
	id INT NOT NULL auto_increment,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO genres (name) VALUES ("action");
INSERT INTO genres (name) VALUES ("Si-Fi");
INSERT INTO genres (name) VALUES ("Love");
INSERT INTO genres (name) VALUES ("Documentation");
INSERT INTO genres (name) VALUES ("Thrill");

drop table movies_genres;
create table movies_genres(
	movie_id INT NOT NULL,
	genre_id INT NOT NULL,
	PRIMARY KEY (movie_id,genre_id)
);


INSERT INTO movies_genres (movie_id,genre_id) VALUES (1,1);
INSERT INTO movies_genres (movie_id,genre_id) VALUES (1,2);
INSERT INTO movies_genres (movie_id,genre_id) VALUES (2,1);
INSERT INTO movies_genres (movie_id,genre_id) VALUES (1,3);

