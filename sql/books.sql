use library;
create table books
(
    id    bigint auto_increment,
    name  varchar(25),
    price bigint,
    primary key (id)
);

INSERT INTO books(name, price)
values ('파이썬알고리즘인터뷰', 25000);

SELECT id, name, price FROM books;
delete from books;