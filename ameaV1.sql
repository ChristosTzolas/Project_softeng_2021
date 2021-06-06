DROP DATABASE AmeaAssistant;
CREATE DATABASE AmeaAssistant ;
USE AmeaAssistant;

CREATE TABLE Admin(
adm_id INT(9) AUTO_INCREMENT,
username VARCHAR(25),
password VARCHAR(25),
email VARCHAR(25),
PRIMARY KEY(adm_id)
);


CREATE TABLE User(
user_id INT(9) NOT NULL AUTO_INCREMENT ,
disability ENUM('BLD','DF','WLK','NO'),  -- BLD is for blind, DF is for deaf, WLK is for walking, No is for Volunteer
username VARCHAR(25),
password VARCHAR(25),
surname VARCHAR(25),
name CHAR(25),
phone BIGINT(16),
email VARCHAR(25),
birth_date DATE,
PRIMARY KEY(user_id)
);


CREATE TABLE Amea(
amea_id INT(9),
message TEXT,
PRIMARY KEY(amea_id),
CONSTRAINT AMEA
FOREIGN KEY(amea_id) REFERENCES User(user_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Volunteer(
vol_id INT(9),
active ENUM('Y','N'),
PRIMARY KEY(vol_id),
CONSTRAINT VOL
FOREIGN KEY (vol_id) REFERENCES User(user_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Location(
loc_id INT(9) AUTO_INCREMENT,
name VARCHAR(25),
address VARCHAR(25),
access ENUM('Y','N'),
PRIMARY KEY(loc_id)
);

CREATE TABLE Event(
event_id INT(9) AUTO_INCREMENT,
e_user_id INT(9),
date_and_time DATETIME,
description TEXT,
title VARCHAR(25),
PRIMARY KEY(event_id),
CONSTRAINT EVNT
FOREIGN KEY (e_user_id) REFERENCES User(user_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Drug_Event(
drg_ev_id INT(9),	
drug_name VARCHAR(25),
pack_tablets INT(9),
dosage FLOAT(9),
PRIMARY KEY(drg_ev_id),
CONSTRAINT DRGS
FOREIGN KEY (drg_ev_id) REFERENCES Event(event_id)
ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE Doctor_Event(
dr_ev_id INT(9),
doctor_location VARCHAR(25),
PRIMARY KEY(dr_ev_id),
CONSTRAINT DRS
FOREIGN KEY(dr_ev_id) REFERENCES Event(event_id)
ON DELETE CASCADE ON UPDATE CASCADE	
);

CREATE TABLE Contact(
cont_id INT(9) AUTO_INCREMENT,
surname VARCHAR (25),
name VARCHAR(25),
phone BIGINT(16),
email VARCHAR(25),
PRIMARY KEY (cont_id)
);

CREATE TABLE Pharmacy(
ph_id INT(9) AUTO_INCREMENT,
name VARCHAR(25),
location VARCHAR(25),
schedule VARCHAR(25),
PRIMARY KEY(ph_id)
);

CREATE TABLE Itinerary(
it_id INT(9) AUTO_INCREMENT,
it_vol_id INT(9),
date_and_time DATETIME,
location VARCHAR(25),
to_or_from ENUM('UNI','CENTER'), 
num_seats INT(9),
PRIMARY KEY(it_id,it_vol_id),
CONSTRAINT ITRN
FOREIGN KEY (it_vol_id) REFERENCES Volunteer(vol_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Request(
req_id INT(9) AUTO_INCREMENT ,
from_id INT(9),
status ENUM('A','D'),
PRIMARY KEY(req_id,from_id),
CONSTRAINT RQST
FOREIGN KEY (from_id) REFERENCES User(user_id)
ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE Request_Itinerary(
req_it_id INT(9),
pick_up_location VARCHAR(25),
PRIMARY KEY(req_it_id),
CONSTRAINT REQIT
FOREIGN KEY(req_it_id) REFERENCES Itinerary(it_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Request_help(
req_vol_id INT(9),
PRIMARY KEY(req_vol_id),
CONSTRAINT RQSTHLP
FOREIGN KEY (req_vol_id) REFERENCES User(user_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Passenger_list(
it_id_list INT(9),
it_amea_id INT(9),
PRIMARY KEY(it_id_list,it_amea_id),
CONSTRAINT PSGRL
FOREIGN KEY(it_id_list) REFERENCES Itinerary(it_id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT PSGRA
FOREIGN KEY(it_amea_id) REFERENCES Amea(amea_id)
ON DELETE CASCADE ON UPDATE CASCADE
); 

CREATE TABLE Doctor_list(
d_amea_id INT(9) AUTO_INCREMENT,
d_cont_id INT(9),
PRIMARY KEY(d_cont_id,d_amea_id),
CONSTRAINT DAMID
FOREIGN KEY(d_amea_id) REFERENCES Amea(amea_id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT DCNTID
FOREIGN KEY(d_cont_id) REFERENCES Contact(cont_id)
ON DELETE CASCADE ON UPDATE CASCADE	
);

CREATE TABLE Emergency_contact_list(
e_amea_id INT(9),
e_cont_id INT(9),
PRIMARY KEY(e_cont_id,e_amea_id),
CONSTRAINT EAMID
FOREIGN KEY(e_amea_id) REFERENCES Amea(amea_id)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT ECNTID
FOREIGN KEY(e_cont_id) REFERENCES Contact(cont_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO Admin VALUES
('123456789', 'mixalis_the_admin', 'ilovemymama', 'mixalis@hotmail.com'),
('123456780', 'souleimanis_the_admin', 'ilovemykarkaletsi', 'souleimanis@hotmail.com');

INSERT INTO User VALUES
('0001', 'WLK', 'Kaiba', 'ilovemypapa', 'oikonomou', 'kostas', '6900000000', 'kostas@gmail.com', '1990-3-22'),
('0002', 'BLD', 'Yugi', 'ilovemygiagia', 'ypodromou', 'adreas', '6900000001', 'anddreas@yahoo.com', '1995-5-2'),
('0003', 'DF', 'James', 'ilovemytheios', 'zaxareos', 'marios', '6900000002', 'marios@gmail.com', '1996-3-16'),
('0004', 'NO', 'Jaisy', 'ilovemyulnce', 'kosiopoulou', 'roula', '6900000003', 'roula@gmail.com', '1988-5-12'),
('0005', 'NO', 'Kim', 'ilovemyprogiagia', 'gkoumou', 'tasia', '6900000004', 'tasia@yahoo.com', '2000-1-1'),
('0006', 'NO', 'Ron', 'ilovemypetheros', 'jeros', 'stellaras', '6900000005', 'stellaras@gmail.com', '1970-6-16');

INSERT INTO Amea VALUES
('0001', 'Thelo voitheia'),
('0002', 'Psaxno oxima'),
('0003', 'Zitaw diathesimo ethelonti');

INSERT INTO Volunteer VALUES
('0004', 'Y'),
('0005', 'Y'),
('0006', 'N');

INSERT INTO Event VALUES
('000001', '0001', '2008-11-11 13:23:44', 'Rantevou kai kafes me ton Kosta', 'Rantevou me ton Kosta'),
('000002', '0002', '2010-12-13 13:23:44', 'Rantevou me ton pathologo', 'Pathologos'),
('000003', '0003', '2012-01-01 13:23:44', 'To amoxyl ana 8 wres', 'Amoxyl'),
('000004', '0004', '2010-02-02 13:23:44', 'Kafes kai rantevou me tin papalavrena', 'Rantevou sta tyfla'),
('000005', '0005', '2010-03-03 13:23:44', 'Rantevou me ton ofthalmiatro', 'Ofthalmiatros'),
('000006', '0006', '2010-04-04 13:23:44', 'To xapi gia tin piesi meta apo to fagito', 'xapi piesis');

INSERT INTO Drug_Event VALUES
('000003', 'Amoxyl', '18', '1'),
('000006', 'lobivon', '20', '1');

INSERT INTO Doctor_Event VALUES
('000002', 'Korinthou 12'),
('000005', 'Zaimi 5');

INSERT INTO Location VALUES
('0001','Biblioteca','Ermou 6','Y'),
('0002','Pritania','Ermou 1','Y'),
('0003','CEID','Ermou 2','N');

INSERT INTO Contact VALUES
('0001','Vlaxos','Manolis','2100102030','vmanolis@gmail.com'),
('0002','Manolidou','Maria','2101010103','mMaria@gmail.com'),
('0003','Mixalis','Mixail','2101234567','MixalisMix@gmail.com'),
('0004','Aggelos','Aggelou','2107894561','AggelosAGG@gmail.com'),
('0005','Basilis','Basiliou','2109874562','BasislisB@hmail.com'),
('0006','Xristos','Tzolas','2108521597','XristosTZ@gmail.com')
('0007','Bob','Bob','2107534896','BobBob@gmail.com'),
('0008','Robert','Robert','2107891235','RobertRobert@gmail.com'),
('0009','Frank','Frank','2103698521',"FrankFrank@gmail.com");

INSERT INTO Itinerary VALUES
('000001','0004','2021-5-7 13:45:00','Agia Sofia','UNI','2'),
('000002','0005','2021-5-12 18:20:00','Plateia Georgiou','CENTER','3');

INSERT INTO Request VALUES
('00001','0001','A'),
('00002','0002','D');

INSERT INTO Request_Itinerary VALUES
('00001','Thessalonikis 56'),
('00002','Korinthou 279');

INSERT INTO Request_help VALUES
('0004'),
('0005');

INSERT INTO Passenger_list VALUES
('000001','0001'),
('000001','0003'),
('000002','0002');

INSERT INTO Emergency_contact_list VALUES
('0001','0001'),
('0001','0004'),
('0001','0005'),
('0002','0002'),
('0002','0006'),
('0003','0003');

INSERT INTO Doctor_list VALUES
('0001','0001'),
('0002','0004'),
('0003','0005');
