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