DROP DATABASE IF EXISTS Baza1;
CREATE DATABASE  Baza1 character set utf8;
USE Baza1;

CREATE TABLE Teret(
  Id int not null  auto_increment,
  Naziv int not null,
  Težina decimal(18,2) not null
);


CREATE TABLE Odredište(
  Id int primary key not null auto_increment,
  Naziv varchar(50) not null,
  Adresa varchar(20)
);



CREATE TABLE Vozac(
  Id int primary key not null auto_increment,
  Ime varchar(25) not null,
  Prezime varchar(20) not null,
  SifraVozaca char(8) not null,
  IdVozilo int not null
);

CREATE TABLE Vozilo(
  Id int primary key not null auto_increment,
  Naziv varchar(50) not null,
  Vrstu varchar(20)
);




ALTER TABLE Vozac ADD FOREIGN KEY (IdVozilo) references Vozilo(Id);

