create database coder;
use coder;

create table clients (
`id` bigint primary key auto_increment,
`dni` varchar (10) unique not null,
`name` varchar(50)  not null,
`lastname` varchar(50) not null,
`birth_date` date
);

create table products (
`id` bigint primary key auto_increment,
`sku` varchar(100),
`description` varchar(200),
`buy_price` double,
`sale_price` double,
`stock` int,
`high_date` date
);

create table sale (
`id` bigint primary key auto_increment,
`high_date` date not null,
`total` double,
`id_client` bigint not null,
constraint `fk_id_client` foreign key (`id_client`) references `clients` (`id`)
);

create table sale_detail(
`id` bigint primary key auto_increment,
`id_sale` bigint not null,
`id_product` bigint not null,
`quantity` int not null,
`subtotal` double not null,
constraint `fk_id_sale` foreign key (`id_sale`) references `sale` (`id`),
constraint `fk_id_product` foreign key (`id_product`) references `products` (`id`)
);

select * from clients;
select * from sale;
select * from products;
select * from sale_detail;