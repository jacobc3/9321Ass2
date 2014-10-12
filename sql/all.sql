
create table user (
	id INT NOT NULL auto_increment,
	username VARCHAR(40) NOT NULL UNIQUE,
	email VARCHAR(50) NOT NULL,
	
	email_ok CHAR(1) default 'N',	
	password VARCHAR(40) default NULL,
	firstname VARCHAR(40) default NULL,
	lastname VARCHAR(40) default NULL,
	registry_date DATETIME default NULL,
	nickname VARCHAR(40) default NULL,
	PRIMARY KEY (id)
);
CREATE FUNCTION random_datetime() returns DATETIME
RETURN FROM_UNIXTIME(
        UNIX_TIMESTAMP('2010-04-30 14:53:27') + FLOOR(0 + (RAND() * 183072000))
    );

INSERT INTO user (username,email,nickname,firstname,lastname,password,registry_date) 
VALUES ("EdwardWBurdick","EdwardWBurdick@armyspy.com","Edward W. Burdick","Edward","W. Burdick",MD5('123'),random_datetime());
INSERT INTO user (username,email,firstname,lastname,registry_date) VALUES ("ChristiALee","ChristiALee@teleworm.us","Christi","A. Lee",random_datetime());
INSERT INTO user (username,email,password,registry_date) VALUES ("WalterJHughes","uWalterJHughes@dayrep.com",MD5('123') ,random_datetime());
INSERT INTO user (username,email,firstname,lastname,registry_date) VALUES ("GiseleMPlatt","GiseleMPlatt@jourrapide.com", "Gisele","W. M. Platt",random_datetime());
INSERT INTO user (username,email,registry_date) VALUES ("LindaWBruton","LindaWBruton@teleworm.us", "2013-03-05 13:17:22");
INSERT INTO user (username,email,firstname,password,nickname,registry_date) VALUES ("Reate1987","EvelynFSmith@teleworm.us", "Evelyn",MD5('uruHohhi9e'),"Ward",random_datetime());
INSERT INTO user (username,email,password,nickname,registry_date) VALUES ("Thereen","AnthonySHoward@jourrapide.com", MD5('Aht5gee5sa1'),"Watson",random_datetime());
INSERT INTO user (username,email,email_ok,nickname,registry_date) VALUES ("Tharste","AbbieJHernandez@dayrep.com", "Y","Talbot",random_datetime());
INSERT INTO user (username,email,email_ok,nickname,registry_date) VALUES ("Asome1994","LorraineJNixon@armyspy.com", "Y","Herrera",random_datetime());
INSERT INTO user (username,email,email_ok,password,registry_date) VALUES ("Inity1991","TimothyBHamilton@armyspy.com", "Y",MD5('ayi8ihooGhi'),random_datetime());
INSERT INTO user (username,password,email,nickname,registry_date) VALUES ("Wanding",MD5('wieSeep1ie'),"JeromeLMontelongo@jourrapide.com","Riveria",random_datetime());
INSERT INTO user (username,password,email,firstname,lastname,registry_date) VALUES ("Dearty",MD5('Gigh0mariud'),"JosePReed@armyspy.com","Jose","P. Reed",random_datetime());
INSERT INTO user (username,password,email,firstname,lastname,registry_date) VALUES ("root",MD5('root'),"jacobc3@gmail.com","rootFirst","RootLast",now());



create table review (
	id INT NOT NULL auto_increment,
	title VARCHAR(40) NOT NULL,
	
	rating INT default 0,
	user_id int default NULL,
	movie_id int  default NULL,	
	post_date DATETIME default NULL,
	content TEXT default NULL,
	PRIMARY KEY (id)
);

INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (1,2,5,random_datetime(),"Quisque ornare ","Quisque ornare maximus orci ut viverra. Nam feugiat varius lacus sit amet mattis. Pellentesque eros nunc, pulvinar et urna quis, aliquam cursus nunc. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nulla facilisi. Curabitur aliquet, lectus eget sollicitudin aliquet, ante magna posuere justo, vitae tristique urna nisl eget felis. Nunc ut luctus lacus, tincidunt viverra neque. Vestibulum rhoncus arcu augue, accumsan finibus dolor tempus ac. In vitae fermentum quam, cursus viverra metus. Duis scelerisque ex nec egestas efficitur. Interdum et malesuada fames ac ante ipsum primis in faucibus.");
INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (1,4,3,random_datetime(),"Praesent aliquam orci","Praesent aliquam orci at nulla tincidunt pellentesque. Quisque hendrerit sit amet ante sed facilisis. Vestibulum ut nunc aliquet dui cursus commodo vitae ut mauris. Integer elementum sollicitudin metus, et finibus sapien euismod dictum. Donec condimentum quam non nisl lacinia, consectetur faucibus est maximus. Aliquam enim dui, porta at bibendum vitae, suscipit ac nisl. Phasellus ut orci ultricies elit ornare tincidunt. Integer mollis arcu eu tincidunt facilisis. Nullam non odio eu neque ultrices rutrum. Integer gravida est est, sit amet rhoncus lorem convallis sit amet. Suspendisse rhoncus sem velit, in facilisis libero malesuada nec. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Suspendisse dictum dolor lectus, ut consectetur ex placerat eget. Curabitur rutrum eu sapien ut consequat. Cras accumsan turpis ac lectus tincidunt, a elementum nulla scelerisque.

Nullam ultrices ante vitae orci suscipit, luctus hendrerit nunc iaculis. Vivamus in enim lobortis, lobortis mi in, lacinia elit. Pellentesque hendrerit sagittis augue et molestie. Phasellus eu ultricies leo. Nunc a enim sed magna dictum scelerisque sed vitae nunc. Maecenas vel finibus lorem, sit amet porta ante. Sed molestie, ante sit amet egestas viverra, lectus massa blandit erat, et iaculis nunc dui vel nisi. Quisque ut massa eleifend, eleifend sapien ut, mattis sapien. Praesent at massa vulputate, viverra tortor vitae, gravida enim. Fusce eros nisl, porttitor non ligula nec, luctus mattis tortor. Cras efficitur condimentum nisl in consectetur. Etiam maximus velit sed fermentum pharetra. Duis nec tellus ullamcorper, convallis nunc sit amet, lobortis libero.");

INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (1,5,5,random_datetime(),"Aenean egestas metus ipsum","Aenean egestas metus ipsum, nec volutpat ligula lacinia vitae. Morbi commodo lacus a nulla hendrerit tincidunt");
INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (2,1,3,random_datetime(),"Cras pulvinar mollis libero","Cras pulvinar mollis libero, eu maximus tortor dictum at. Vestibulum ante ipsum primis");


INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (2,2,3,random_datetime(),"Vestibulum rhoncus arcu augue","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc convallis commodo dignissim. Vivamus quis pellentesque dolor. Mauris a risus et erat egestas facilisis in nec nisi. Vestibulum non sapien orci. Quisque sed odio id diam gravida mollis consectetur vitae tellus. Mauris efficitur urna et gravida vestibulum. Pellentesque at nunc sollicitudin, suscipit enim sit amet, iaculis odio. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec sed ex molestie tellus interdum egestas id id magna. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris tellus orci, tristique ut bibendum vel, vulputate sed tellus.");
INSERT INTO review (user_id,movie_id,post_date,title,content) VALUES (2,3,random_datetime(),"Nam feugiat varius lacus","Phasellus commodo aliquet eros, vitae lobortis risus convallis et. Aenean ornare vel velit ornare rutrum. Nullam tortor odio, convallis eu viverra ut, condimentum ac purus. Integer elit enim, maximus eget ante non, cursus ornare turpis. Nulla posuere, velit sit amet aliquam pretium, erat sapien rutrum ex, vel venenatis nisi nisl et magna. Aliquam interdum orci mi, a malesuada orci laoreet vitae. Donec sodales mattis urna eu pellentesque. Donec feugiat eu nisl eget fermentum. Sed efficitur sem non pulvinar interdum. Sed quis dui vestibulum tortor varius pretium. Curabitur at ipsum sem. Praesent congue, lacus eu vulputate dignissim, est nibh scelerisque est, nec faucibus sem dolor in velit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam id arcu eget sapien luctus maximus. Fusce molestie ante nibh, viverra tristique lectus pellentesque ac. Praesent non nisi nisi.");
INSERT INTO review (user_id,movie_id,post_date,title,content) VALUES (2,2,random_datetime(),"orci ut viverra","Fusce volutpat erat in arcu suscipit, sed fringilla velit mattis. Praesent nulla velit, bibendum ac sapien vitae, iaculis lobortis enim. Pellentesque id ligula maximus, sagittis orci vel, ullamcorper ante. Sed efficitur nibh vitae consequat consectetur. Sed mollis magna nibh, sed rhoncus eros vestibulum vitae. Cras aliquam erat velit, eu dictum nisi blandit sit amet. Suspendisse euismod dolor nec nulla ultrices, vitae aliquam nulla accumsan. Nulla risus libero, ornare nec accumsan a, blandit sit amet mauris. Vestibulum consectetur lacus a accumsan ultrices. Phasellus tellus mauris, efficitur blandit risus at, aliquet tincidunt dolor. Ut laoreet cursus dolor vel lacinia. Sed quis scelerisque tortor, non gravida elit. Mauris ut bibendum urna, vitae convallis ligula. Ut eget porta purus, ut dapibus sapien.");
INSERT INTO review (user_id,movie_id,post_date,title,content) VALUES (3,5,random_datetime(),"Quisque ornare maximus","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam turpis est, luctus nec pellentesque sit amet, accumsan non est. Integer cursus ultricies dictum. Aliquam viverra, diam nec ultrices volutpat, augue metus fringilla velit, eu porttitor sem purus nec neque. Nulla sodales tincidunt semper. Donec fermentum maximus porta. Proin auctor interdum arcu, nec dictum tortor pellentesque id. Donec mollis erat non libero ornare feugiat. Aliquam pulvinar justo non libero vestibulum suscipit.");

INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (1,3,1,random_datetime(),"Duis lacinia velit suscipit","Duis lacinia velit suscipit, lacinia dui eu, sollicitudin velit. Etiam feugiat ornare nisl, non tincidunt urna malesuada ac. Maecenas fringilla arcu condimentum fermentum fermentum. Donec consectetur venenatis magna eget placerat. Quisque sit amet rhoncus eros. Nunc et justo luctus, ornare augue vitae, scelerisque mi. Maecenas eget turpis nec felis tempor feugiat. Aenean bibendum libero ultrices elit porta tincidunt. Nunc ultrices malesuada sapien quis finibus. Praesent egestas ex nec nisi eleifend imperdiet vel non nisl.");
INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (1,4,5,random_datetime(),"Maecenas ac cursus turpis","Maecenas ac cursus turpis, et lobortis nunc. Praesent eu lorem faucibus, aliquet ante quis, mattis massa. Vivamus quis elit pellentesque, iaculis dolor ut, condimentum nunc. Praesent vel ipsum vehicula, lobortis lectus sit amet, faucibus magna. Donec quis metus leo. Duis cursus elementum turpis. Curabitur ligula diam, pulvinar sed metus a, volutpat facilisis nunc. Praesent consectetur ullamcorper elit vitae iaculis. Ut in lacus tincidunt, varius lorem vitae, laoreet orci. Aenean accumsan non lectus eu blandit. Nulla id nisi sed orci fringilla gravida vitae at mi. Mauris tincidunt velit lacus, id congue dolor sodales porttitor. Vivamus et justo eu leo scelerisque cursus suscipit non nibh. Aenean ac dolor eu lectus pretium cursus eu ut ex. Pellentesque arcu lacus, tincidunt at ante at, congue molestie urna. Phasellus eget odio enim.");
INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (2,3,4,random_datetime(),"Sed molestie purus non sapien","Sed molestie purus non sapien ullamcorper commodo. Vestibulum venenatis, odio ac posuere dignissim, lectus nisi cursus nisl, at condimentum nisl ante non est. Pellentesque vel porttitor dui, at dapibus quam. Ut urna massa, tempus eget volutpat quis, vestibulum eget nisl. Morbi dictum nisi at elit congue tristique. Maecenas bibendum consectetur ex nec sodales. Nulla vel nisi feugiat, pellentesque erat quis, commodo lorem. Donec vel vulputate odio, sit amet pulvinar ante. Maecenas semper est in sem aliquam tempus. Vestibulum pretium mattis nisl, a vestibulum massa pellentesque sit amet. Maecenas consectetur posuere massa, sed ullamcorper ante feugiat eget. Curabitur sed augue id neque blandit varius id et mauris. Proin venenatis bibendum enim sed malesuada. Curabitur iaculis porta pharetra. Sed dolor arcu, imperdiet et sapien pretium, fermentum bibendum ex. Suspendisse potenti.");
INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (2,4,3,random_datetime(),"Pellentesque id feugiat felis.","Pellentesque id feugiat felis. Integer nec est varius, molestie lacus sed, tristique orci. Mauris tempus malesuada nulla, euismod posuere justo porta ut. Phasellus libero purus, vehicula vel lobortis consectetur, gravida eget leo. Cras venenatis lacus cursus metus sodales, eu dictum felis congue. Nulla facilisi. Aenean viverra maximus felis, id auctor enim iaculis a. Pellentesque justo lacus, sodales non nisl a, mattis luctus enim. Sed at gravida lorem, eu ultricies nibh. Donec a cursus massa.");
INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (3,3,2,random_datetime(),"Cras rhoncus dui dolor","Cras rhoncus dui dolor, quis pulvinar est scelerisque a. Quisque consectetur dolor leo, eu ultricies turpis efficitur et. Interdum et malesuada fames ac ante ipsum primis in faucibus. Phasellus condimentum, ante ac dapibus venenatis, odio tellus fermentum dolor, a rhoncus est ipsum finibus augue. Duis eget semper mi. Vivamus tempor rhoncus commodo. Suspendisse ultricies a nisl vel sollicitudin. Phasellus placerat quam blandit fermentum congue.");
INSERT INTO review (user_id,movie_id,rating,post_date,title,content) VALUES (4,3,1,random_datetime(),"Nullam nec ullamcorper nisi.","Nullam nec ullamcorper nisi. Ut condimentum sodales felis volutpat scelerisque. Quisque id vestibulum leo, a elementum tellus. Pellentesque quis sem et lacus tincidunt mattis ut sed ligula. In hac habitasse platea dictumst. Morbi mattis tellus orci, consequat scelerisque massa cursus quis. Nulla nec dolor vel lacus ornare pharetra. Fusce vehicula hendrerit nunc sit amet sagittis.");






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






create table movie (
	id INT NOT NULL auto_increment,
	title VARCHAR(40) NOT NULL,
	
	release_date DATE default NULL,
	actors VARCHAR(100) default NULL,
	synopsis VARCHAR(400) default NULL,
	posterURL VARCHAR(100) default NULL,
	PRIMARY KEY (id)	
);

INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("BIG BANG",random_datetime(), "Roxie Lamoreaux,
Colene Grounds,
Kiana Hilario,
Sherley Mansour,
Alonso Riess", "images/4.jpg");
INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("BIG BANG2",random_datetime(), "Debi Diebold,
Hermine Waldrip,
Armida Gunnell,
Derrick Mcmillin,
Cheyenne Macy", "images/5.jpg");
INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("THE RIGHT",random_datetime(), "Angelika Cummins,
Shara Bromley,
Dustin Leppert,
Darwin Felmlee,
Lura Abarca", "images/6.jpg");
INSERT INTO movie (title,release_date,actors,posterURL) VALUES ("BIG BANG",random_datetime(), "Mira Palmeri,
Lenora Labarge,
Kathe Okada,
Jammie Mazon,
Providencia Thibodeau", "images/7.jpg");
INSERT INTO movie (title,synopsis,actors) VALUES ("NEW MOVIE 2","Mauris pellentesque est et dolor pellentesque sagittis.
Suspendisse egestas odio at elit gravida imperdiet.
Aenean sagittis ex et tincidunt tincidunt.
Duis quis magna in nunc varius vulputate sodales ac ipsum.", "Wow,Pitter");
INSERT INTO movie (title,posterURL,actors,release_date) VALUES ("In non interdum velit","images/1.jpg", "Kary Lecroy,
Gay Yant,
Zenia Musser,
Lavenia Hauptman,
Loretta Capella","2013-11-09");
INSERT INTO movie (title,release_date,posterURL) VALUES ("sit amet nulla quis",random_datetime(), "images/2.jpg");
INSERT INTO movie (title,release_date,posterURL) VALUES ("fringilla porttitor",random_datetime(), "images/3.jpg");
INSERT INTO movie (title,release_date,synopsis) VALUES ("eget blandit magna",random_datetime(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit.
Maecenas vel arcu in purus viverra placerat.
Quisque in arcu id tortor dignissim bibendum.
Donec pretium odio nec dui euismod commodo ut fringilla nulla.
Fusce sodales magna vel sem tristique, id dignissim eros bibendum.");
INSERT INTO movie (title,posterURL,actors,release_date) VALUES ("a tincidunt tristique","images/1.jpg", "Aimee Duane
Andrew Graffam
Vickey Laduke
Lanette Juliano
Elna Highsmith","2014-11-01");
INSERT INTO movie (title,posterURL,actors,release_date,synopsis) VALUES ("Suspendisse sit","images/1.jpg", "Santa Salyards
Crista Olney
Marlene Baylor
Leola Tennison
Beula Breckenridge",random_datetime(),"Suspendisse sit amet posuere erat. 
Curabitur sed dictum felis. Proin efficitur, nisl convallis semper sollicitudin.");




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






create table owner (
	id INT NOT NULL auto_increment,
	username VARCHAR(40) NOT NULL unique,
	password VARCHAR(40) default NULL,
	PRIMARY KEY (id)
);
INSERT INTO owner (username,password) VALUES ("admin","password");


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


create table booking (
	id integer auto_increment NOT NULL,
	
	session_id int default NULL,
	user_id int default NULL,
	
	card_number varchar(16) default NULL,
	order_time DATETIME default NULL,
	count int default 1,
	status ENUM('Processing','Approved','Declined') default 'Processing',
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
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (7,1,random_datetime(),"Declined");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (2,1,random_datetime(),"Approved");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (2,1,random_datetime(),"Approved");
INSERT INTO booking (session_id,user_id,order_time,status) VALUES (3,1,random_datetime(),"Approved");
INSERT INTO booking (session_id,user_id,order_time,count,card_number,status) VALUES (10,6,random_datetime(),10,"349937228716794","Approved");
INSERT INTO booking (session_id,user_id,order_time,count,card_number,status) VALUES (10,6,random_datetime(),11,"349937228716794","Approved");
-- session 10 only have 1 seats left
INSERT INTO booking (session_id,user_id,order_time,count,card_number,status) VALUES (19,6,random_datetime(),30,"349937228716794","Approved");
INSERT INTO booking (session_id,user_id,order_time,count,card_number,status) VALUES (19,6,random_datetime(),20,"349937228716794","Processing");














