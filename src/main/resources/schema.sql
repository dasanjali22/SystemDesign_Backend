
DROP TABLE IF EXISTS employeedetails;
DROP TABLE IF EXISTS pricelist;


CREATE TABLE employeedetails(employee_id INT PRIMARY KEY, employee_name VARCHAR(25) NOT NULL, employee_type VARCHAR(25) NOT NULL, employee_email VARCHAR(25) NOT NULL);

CREATE TABLE servicelist(service_Id INT PRIMARY KEY, service_Name VARCHAR(25) NOT NULL, service_Price INT NOT NULL);