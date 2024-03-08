use library;

select * from book;

create table book
(
    id   bigint auto_increment,
    name varchar(255) not null,
    primary key (id),
    unique key (name)
);

drop table book;
drop table user_loan_history;

delete
from book;

show tables;

create table user_loan_history
(
    id        bigint auto_increment,
    user_id   bigint,
    book_name varchar(255),
    is_return tinyint(1),
    primary key (id)
);


alter table user_loan_history
    add unique key (user_id);

drop table user_loan_history;



# ALTER TABLE user_loan_history DROP INDEX user_id;

insert into user_loan_history(user_id, book_name)
VALUES (2, '토비의스프링');

select *
from user_loan_history where is_return = false;

select *
from user_loan_history ;

select * from user;

select *
from book;

select *
from user_loan_history;


delete
from user_loan_history
where book_name = '토비의스프링';

insert into book(name)
values ('토비의스프링');
