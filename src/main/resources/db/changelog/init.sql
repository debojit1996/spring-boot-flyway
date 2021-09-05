-- liquibase formatted sql
-- changeSet my-init_db:1 failOnError:true

drop table if exists Employee;

create table employee (
        id bigint auto_increment,
        name varchar(100),
        email varchar(100),
        primary key (id)
);
