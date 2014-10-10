/*
 * INCLUDE:
 * users
 * review
 * 
 */

drop table user;
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
/*
 * FROM_UNIXTIME(
        UNIX_TIMESTAMP('2010-04-30 14:53:27') + FLOOR(0 + (RAND() * 63072000))
    )
    works as random date generator
 */

DROP FUNCTION random_datetime;
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



drop table review;
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
