-- mysql> source goods-mysql.sql
-- mysql> create user if not exists 'springuser'@'%' identified by '12345678';
-- mysql> grant all on goods.* to 'springuser'@'%';
-- mysql> exit

drop database if exists goods;
create database goods;
use goods;

create table goods (
    id int PRIMARY KEY auto_increment,
    count varchar(30) not null,
    goodsName varchar(30) not null,
    goodsPic varchar(100)
);

# insert into goods (id, count, goodsName, goodsPic) values
#     (1, "5.4万", "富士拍立得相机", "/img/polaroid.png");
