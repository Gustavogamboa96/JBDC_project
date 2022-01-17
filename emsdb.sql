Create database EMS;
use EMS;
create table employees(
employee_id INT NOT NULL auto_increment,
fname varchar(50) NOT NULL,
lname  varchar(50) NOT NULL,
email varchar(75) NOT NULL,
PRIMARY KEY (employee_id)
);

insert into employees (fname, lname, email)values("john", "smith", "john@aol.com");
insert into employees (fname, lname, email)values("mary", "walker", "mary@gmail.com");
insert into employees (fname, lname, email)values("kevin", "franklin", "kevthedev@yahoo.com");

select * from employees;