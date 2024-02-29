use library;

start transaction;
insert into user (name, age)
values ('A', 10);
commit;

select *
from user;


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