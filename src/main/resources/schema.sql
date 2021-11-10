DROP TABLE IF EXISTS userdetails;
DROP TABLE IF EXISTS membershipdetails;
DROP TABLE IF EXISTS paymentdetails;

CREATE TABLE userdetails (UID INT AUTO_INCREMENT PRIMARY KEY,Uname VARCHAR(25) NOT NULL, Uemail VARCHAR(25) NOT NULL, Uphone INT (10) NOT NULL,membership_name  VARCHAR(25) NOT NULL);
CREATE TABLE membershipdetails(membership_Details_Id INT PRIMARY KEY,membership_id INT NOT NULL, UID INT, membership_Start_Date VARCHAR(10) NOT NULL, membership_End_Date VARCHAR(10) NOT NULL);
CREATE TABLE paymentdetails(payment_Id INT PRIMARY KEY, payment_user_id INT NOT NULL, payment_date VARCHAR(25) NULL, payment_price INT NOT NULL, payment_status INT NULL, payment_type VARCHAR(25) NOT NULL);