use library;

create table book
(
    id   bigint auto_increment,
    name varchar(255) not null,
    primary key (id)
);

drop table book_loan_history;

delete
from book;

create table book_loan_history
(
    id        bigint auto_increment,
    user_id   bigint not null ,
    book_name varchar(255) not null ,
    is_return boolean DEFAULT true,
    primary key (id),
    unique key (user_id)
);

alter table book_loan_history
    add unique key (user_id);

insert into book_loan_history(user_id, book_name)
VALUES (2, '토비의스프링');

select *
from book_loan_history where is_return = false;

select *
from book_loan_history ;


select *
from book;

delete
from book_loan_history
where book_name = '토비의스프링';

insert into book(name)
values ('토비의스프링');
