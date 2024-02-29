use library;

create table book(
    id bigint auto_increment,
    name varchar(255),
    primary key (id)
);

insert into book(name)
values ('토비의스프링');

select * from book;

delete
from book
where name = '토비의스프링';
