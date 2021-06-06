CREATE DATABASE AmeaAssistant ;



CREATE TABLE Admin(
adm_id INT(9),
username VARCHAR(25),
password VARCHAR(25),
email VARCHAR(25),
PRIMARY KEY(adm_id)
);



CREATE TABLE User(
user_id INT(9) NOT NULL,
username VARCHAR(25),
password VARCHAR(25),
name CHAR(25),
phone BIGINT(16),
email VARCHAR(25),
birth_date DATE,
PRIMARY KEY(user_id)
);


CREATE TABLE Amea(
amea_id INT(9)
disability ENUM()
message TEXT,
emergency_contacts
doctors
PRIMARY KEY(amea_id),
CONSTRAINT AMEA
FOREIGN KEY(amea_id) REFERENCES User(user_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Volunteer(
vol_id INT(9)
active ENUM('Y','N'),
itineraries
PRIMARY KEY vol_id),
CONSTRAINT VOL
FOREIGN KEY (vol_id) REFERENCES User(user_id)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE Location(
loc_id INT(9),
NAME VARCHAR(25),
address VARCHAR(25),
access ENUM('Y','N'),
PRIMARY KEY(loc_id)
);

CREATE TABLE Event(
event_id INT(9),
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
PRIMARY KEY(d_id)
CONSTRAINT DRGS
FOREIGN KEY (drg_ev_id) REFERENCES Event(event_id)
ON DELETE CASCADE ON UPDATE CASCADE 
);

CREATE TABLE Doctor_Event(
dr_ev_id INT(9),
doctor
doctor_location VARCHAR(25),
PRIMARY KEY(dr_ev_id),
CONSTRAINT DRS
FOREIGN KEY(dr_ev_id) REFERENCES Event(event_id)
ON DELETE CASCADE ON UPDATE CASCADE	
);

CREATE TABLE Contact(
cont_id INT(9),
surname VARCHAR (25),
name VARCHAR(25),
phone BIGINT(16),
email VARCHAR(25),
PRIMARY KEY (cont_id)
);

CREATE TABLE Pharmacy(
ph_id INT(9)
name VARCHAR(25),
location VARCHAR(25),
schedule VARCHAR(25),
PRIMARY KEY(ph_id)
);

CREATE TABLE Itinerary(
it_id INT(9),
date_and_time DATETIME,
location VARCHAR(25),
to_or_from ENUM('')
num_seats INT(9),
PRIMARY KEY(it_id)
);


CREATE TABLE Request(
req_id INT(9),
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

CREATE TABLE Request_help
req_vol_id INT(9),
PRIMARY KEY(req_vol_id),
CONSTRAINT RQSTHLP
FOREIGN KEY (req_vol_id) REFERENCES Volunteer(vol_id)
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