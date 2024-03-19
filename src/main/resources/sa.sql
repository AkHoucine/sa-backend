drop database SA;

create database SA;

create table CLIENT (
    ID integer primary key not null AUTO_INCREMENT,
    EMAIL varchar(50) unique
);

create table SENTIMENT (
    ID integer primary key not null AUTO_INCREMENT,
    TEXT varchar(50),
    TYPE varchar(10),
    CLIENT_ID integer,
    CONSTRAINT client_fk foreign key (CLIENT_ID) references CLIENT(ID)
);