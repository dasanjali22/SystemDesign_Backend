DROP TABLE IF EXISTS userdetails;
DROP TABLE IF EXISTS membership;
DROP TABLE IF EXISTS membershipdetails;
DROP TABLE IF EXISTS Booking_table;
DROP TABLE IF EXISTS Doctor;
DROP TABLE IF EXISTS Dietician;
DROP TABLE IF EXISTS Gym;
DROP TABLE IF EXISTS Yoga;

create table membership (membership_id INT PRIMARY KEY, membership_name VARCHAR(25), membership_price INT);
CREATE TABLE userdetails (UID INT AUTO_INCREMENT PRIMARY KEY,Uname VARCHAR(25) NOT NULL, Uemail VARCHAR(25) NOT NULL, Uphone INT (10) NOT NULL,membership_id  INT NULL);
CREATE TABLE membershipdetails(membership_Details_Id INT PRIMARY KEY,membership_id INT NOT NULL, UID INT, membership_Start_Date VARCHAR(10) NOT NULL, membership_End_Date VARCHAR(10) NOT NULL);
create table Booking_table( "BID" varchar, "Btype" varchar, "UID" varchar, "Date" datetime ,"SID" varchar);
create table Doctor( "DID" varchar, "Dname" varchar, "Demail" varchar);
create table Dietician( "TID" varchar, "Tname" varchar, "Temail" varchar);
create table Gym( "GID" varchar, "Gname" varchar, "Gemail" varchar);
create table Yoga( "YID" varchar, "Yname" varchar, "Yemail" varchar);