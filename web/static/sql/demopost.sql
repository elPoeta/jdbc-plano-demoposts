DROP DATABASE IF EXISTS `db_demopost`;
CREATE DATABASE `db_demopost`;
USE `db_demopost`;


DROP TABLE IF EXISTS `categoria`;
DROP TABLE IF EXISTS `autor`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `tags`;

CREATE TABLE  `categoria`(
    `id` integer AUTO_INCREMENT NOT NULL,
    `nombre` VARCHAR(60) NOT NULL,
    `is_activa` boolean default false,
    PRIMARY KEY (`id`)
);

insert into `categoria` (`nombre`, `is_activa`) values ("Literatura", true),("Música",true),("Cine",true),("Deportes",true),  ("Tecnología",true),("Developers",true),("Noticias",true),("Tutoriales",true); 



CREATE TABLE  `autor`(
    `id` integer AUTO_INCREMENT NOT NULL,
    `nombre` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`id`)
);													 

insert into `autor` (`nombre`) values ("elPoeta");

CREATE TABLE `post` (
	`id` integer AUTO_INCREMENT NOT NULL,
	`titulo` VARCHAR(100) NOT NULL,
    `sub_titulo` VARCHAR(100) NOT NULL,
	`cuerpo` LONGTEXT NOT NULL,
	`fecha_creacion` TIMESTAMP NOT NULL,
    `categoria_id` integer NOT NULL,
    `autor_id` integer not null,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`categoria_id`) REFERENCES `categoria`(`id`),
    FOREIGN KEY (`autor_id`) REFERENCES `autor`(`id`)
);

CREATE TABLE `tags`(
	`post_id` integer, 
    `tag` VARCHAR(255),
     KEY `fk_postID` (`post_id`),
     CONSTRAINT `fk_postID` FOREIGN KEY (`post_id`) REFERENCES `post`(`id`)
);
