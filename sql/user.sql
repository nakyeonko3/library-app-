use library;



create database library;
use library;
create table user(
    id bigint auto_increment,
    name varchar(25),
    age int,
    primary key (id)
);




# -------------------------------
select *
from user;


start transaction;
insert into user (name, age)
values ('A', 10);
commit;

select *
from user where name='김길현';

ALTER TABLE user
    drop name;

ALTER TABLE user
    add name varchar(255);

ALTER TABLE user
    ADD UNIQUE KEY (name);


start transaction;
insert into user (name, age)
values ('A', 11);
rollback;


delete
from user
where name = 'A';

delete
from user;

alter table user
    auto_increment = 1;