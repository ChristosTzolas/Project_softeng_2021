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
-- mexti edo kala

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