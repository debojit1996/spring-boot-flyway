-- liquibase formatted sql
-- changeSet Insert_employee:1 failOnError:true context:abroad
insert into employee (name, email) values('sam curran', 'sam@gmail.com');
insert into employee (name, email) values('mike hussey', 'mike@gmail.com');
