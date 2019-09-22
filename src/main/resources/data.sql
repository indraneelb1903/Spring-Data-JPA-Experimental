DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS employees;
 
CREATE TABLE customers (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  dob DATE NOT NULL
);

CREATE TABLE departments (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  dept_name VARCHAR(250) NOT NULL,
  dept_description VARCHAR(250) NOT NULL,
);


CREATE TABLE employees (
 id BIGINT AUTO_INCREMENT  PRIMARY KEY,
 first_name VARCHAR(250) NOT NULL,
 last_name VARCHAR(250) NOT NULL,
 dob DATE NOT NULL,
 dept_id BIGINT,
 foreign key (dept_id) references departments(id)
);


