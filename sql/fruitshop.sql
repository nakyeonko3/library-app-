create database fruitShop;
use fruitShop;

#전체 확인
select * from fruit;

drop table fruit;
#전체 삭제
DELETE
FROM fruit;

# id auto_increment reset초기화
ALTER TABLE fruit
    AUTO_INCREMENT = 1;


create table fruit
(
    id              bigint auto_increment,
    name            varchar(25),
    warehousing_date date,
    price           bigint,
    is_sold          boolean DEFAULT false,
    primary key (id)
);

# String sql = "INSERT INTO user(age, name) VALUES(?,?)";

# start transaction;

insert INTO fruit(name, warehousing_date, price, is_sold)
VALUES ('사과',
        STR_TO_DATE('2024-02-01', '%Y-%m-%d'),
        3000,
        TRUE );

insert INTO fruit(name, warehousing_date, price, is_sold)
VALUES ('사과',
        STR_TO_DATE('2024-01-02', '%Y-%m-%d'),
        4000,
        FALSE);

insert INTO fruit(name, warehousing_date, price, is_sold)
VALUES ('사과',
        '2024-01-01',
        3000,
        TRUE);



insert INTO fruit(name, warehousing_date, price, is_sold)
VALUES ('배',
        STR_TO_DATE('2024-02-01', '%Y-%m-%d'),
        2000,
        TRUE);

insert INTO fruit(name, warehousing_date, price, is_sold)
VALUES ('배',
        STR_TO_DATE('2024-01-02', '%Y-%m-%d'),
        4000,
        FALSE);

insert INTO fruit(name, warehousing_date, price, is_sold)
VALUES ('배',
        '2024-01-01',
        1000,
        TRUE);


select *
from fruit where id = 3;

SELECT is_sold, SUM(price) as SUM from fruit WHERE name = '배' GROUP BY is_sold;



select *
from fruit
WHERE id = 3;

UPDATE fruit
SET is_sold = FALSE
WHERE id = 2;

# select str_to_date('2024-02-01', '%Y-%m-%d');

# "DELETE FROM user WHERE name =?";





DROP TABLE fruit;
rollback;
# "UPDATE user SET name = ? WHERE id =?";
commit;