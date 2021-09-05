-- liquibase formatted sql
-- changeSet Insert_employee_again:1 failOnError:true context:india
insert into employee (name, email) values('rohit sharma', 'rohit@gmail.com');
