CREATE DATABASE sgfpweb;
USE sgfpweb;

CREATE TABLE login (
	id INT AUTO_INCREMENT NOT NULL,
    tipo varchar(255),
    nome varchar(255),
    senha varchar(255),
    PRIMARY KEY (id),
    UNIQUE (nome)
);

CREATE TABLE despesas (
	id int AUTO_INCREMENT NOT NULL,
    valor double,
    nome varchar(255),
    tipo varchar(255),
    categoria varchar(255),
	`status` varchar(255),
    PRIMARY KEY (id)
);

INSERT INTO login VALUES (
	1,
    "admin",
    "admin",
    MD5("admin")
);

INSERT INTO login VALUES (
	2,
    "user",
    "user",
    MD5("user")
);