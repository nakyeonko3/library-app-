use library;

select *
from person;
select *
from address;


# // person 테이블
create table person
(
    id         bigint auto_increment,
    name       varchar(255),
    address_id bigint,
    primary key (id)
);


# // address 테이블
create table address
(
    id     bigint auto_increment,
    city   varchar(255),
    street varchar(255),
    primary key (id)
);

drop table address;
drop table person;
