create database coder;
use coder;

create table clients (
id int primary key auto_increment,
name varchar(100) default null,
lastname varchar(45) default null,
dni varchar (11) not null unique,
birth_date date
);

create table sale (
id int primary key auto_increment,
high_date date,
total double,
client_id int ,
constraint fk_client_id foreign key (client_id) references clients(id)
);


create table products (
id int primary key auto_increment,
sku varchar(50) default null,
description varchar(150) default null,
purchase_price double,
sale_price double,
stock int,
high_date date
);

create table sale_detail(
id int primary key auto_increment,
sale_id int,
product_id int,
quantity int,
subtotal double,
constraint fk_sale_id foreign key (sale_id) references sale(id),
constraint fk_product_id foreign key (product_id) references products(id)
);


select * from clients;
select * from sale;
select * from products;
select * from sale_detail;

delete from clients where id=8;