
CREATE TABLE Employee(
employee_id serial PRIMARY KEY,
employee_FirstName varchar,
employee_LastName varchar,
employee_Username varchar,
employee_Password varchar,
manager_id serial 
);


CREATE TABLE Employee_Request(
employee_Request_id serial PRIMARY KEY,
description varchar,
approved boolean,
denied boolean,
file bytea,
employee_id serial
);


CREATE TABLE Manager(
manager_id serial PRIMARY KEY,
manager_firstName varchar,
manager_lastName varchar,
manager_Username varchar,
manager_Password varchar,
employee_id serial
);


CREATE TABLE Manager_Request(
manager_Request_id serial PRIMARY KEY,
description varchar,
approved boolean,
denied boolean,
file bytea,
manager_id serial
);


CREATE TABLE Manager_Supervisor(
manager_supervisor_id serial PRIMARY KEY,
manager_supervisor_firstName varchar,
manager_supervisor_lastName varchar,
manager_supervisor_Username varchar,
manager_supervisor_Password varchar,
manager_id serial
);

/*Example Table for Testing*/
CREATE TABLE users (
id int PRIMARY KEY,
first_name varchar,
last_name varchar,
username varchar,
password varchar
);


ALTER TABLE employee ADD FOREIGN KEY (manager_id) REFERENCES manager (manager_id);
ALTER TABLE employee_request ADD FOREIGN KEY (employee_id) REFERENCES employee (employee_id);
ALTER TABLE manager_request ADD FOREIGN KEY (manager_id) REFERENCES manager (manager_id);
ALTER TABLE manager_supervisor ADD FOREIGN KEY (manager_id) REFERENCES manager (manager_id);
