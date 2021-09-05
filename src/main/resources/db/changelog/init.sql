-- liquibase formatted sql
-- changeSet my-init_db:1 failOnError:true

drop table if exists Employee;

create table employee (
        id bigint auto_increment,
        firstname varchar(100) NOT NULL,
        lastname varchar(100),
        email varchar(100) UNIQUE,
        primary key (id)
);
