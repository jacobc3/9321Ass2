/*
 * INCLUDE:
 * movie
 * genre
 * movie_genre
 */
drop table movie;
create table movie (
	id INT NOT NULL auto_increment,
	title VARCHAR(40) NOT NULL,
	
	release_date DATE default NULL,
	actors VARCHAR(100) default NULL,
	synopsis VARCHAR(400) default NULL,
	posterURL VARCHAR(100) default NULL,
	PRIMARY KEY (id)	
);

INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("BIG BANG",random_datetime(), "Luis,Pitter", "images/4.jpg");
INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("BIG BANG2",random_datetime(), "Wow,Pitter", "images/5.jpg");
INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("THE RIGHT",random_datetime(), "Luis,Magic", "images/6.jpg");
INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("BIG BANG",random_datetime(), "Luis,Pitter", "images/7.jpg");
INSERT INTO movie (title,synopsis,actors) VALUES ("NEW MOVIE 2","FAS fqw asdfqwl qfqo", "Wow,Pitter");
INSERT INTO movie (title,posterURL,actors,release_date) VALUES ("THE RIGHTSSS","images/1.jpg", "Luis,Magic","2013-11-09");
INSERT INTO movie (title,release_date,posterURL) VALUES ("MOVE ADW",random_datetime(), "images/2.jpg");
INSERT INTO movie (title,release_date,posterURL) VALUES ("RIGN SGF3",random_datetime(), "images/3.jpg");
INSERT INTO movie (title,release_date,synopsis) VALUES ("RING AFQW AFDE",random_datetime(), "FQ AS Sdadfaw Fwewa asfas");
INSERT INTO movie (title,posterURL,actors,release_date) VALUES ("THE RIGHTSSS","images/1.jpg", "Luis,Magic","2014-11-01");

drop table genre;
create table genre (
	id INT NOT NULL auto_increment,
	name VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO genre (name) VALUES ("Action");
INSERT INTO genre (name) VALUES ("Adventure");
INSERT INTO genre (name) VALUES ("Animation");
INSERT INTO genre (name) VALUES ("Biography");
INSERT INTO genre (name) VALUES ("Comedy");
INSERT INTO genre (name) VALUES ("Crime");
INSERT INTO genre (name) VALUES ("Drama");
INSERT INTO genre (name) VALUES ("History");
INSERT INTO genre (name) VALUES ("Music");
INSERT INTO genre (name) VALUES ("Mystery");
INSERT INTO genre (name) VALUES ("Si-Fi");
INSERT INTO genre (name) VALUES ("Love");
INSERT INTO genre (name) VALUES ("War");
INSERT INTO genre (name) VALUES ("Thriller");
INSERT INTO genre (name) VALUES ("Horror");
INSERT INTO genre (name) VALUES ("Family");


drop table movie_genre;
create table movie_genre(
	movie_id INT NOT NULL,
	genre_id INT NOT NULL,
	PRIMARY KEY (movie_id,genre_id)
);


INSERT INTO movie_genre (movie_id,genre_id) VALUES (1,2);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (1,3);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (1,4);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (1,5);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (1,6);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (1,8);

INSERT INTO movie_genre (movie_id,genre_id) VALUES (2,1);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (2,4);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (2,5);

INSERT INTO movie_genre (movie_id,genre_id) VALUES (3,2);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (3,5);


INSERT INTO movie_genre (movie_id,genre_id) VALUES (4,4);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (4,5);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (4,6);

INSERT INTO movie_genre (movie_id,genre_id) VALUES (5,3);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (5,1);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (5,4);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (5,8);

INSERT INTO movie_genre (movie_id,genre_id) VALUES (6,1);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (6,2);

INSERT INTO movie_genre (movie_id,genre_id) VALUES (7,1);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (7,4);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (7,5);

INSERT INTO movie_genre (movie_id,genre_id) VALUES (8,2);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (8,4);
INSERT INTO movie_genre (movie_id,genre_id) VALUES (8,7);

INSERT INTO movie_genre (movie_id,genre_id) VALUES (9,2);








