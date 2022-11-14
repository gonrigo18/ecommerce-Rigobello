create database coder;
use coder;

create table clients (
`id_client` bigint NOT NULL PRIMARY KEY auto_increment unique,
`dni` bigint NOT NULL,
`name` varchar(255) DEFAULT NULL,
`lastname` varchar(255) DEFAULT NULL,
`high_date` datetime(6) DEFAULT NULL
);

create table sale (
`id_sale` bigint NOT NULL AUTO_INCREMENT primary key unique,
`issue_date` datetime(6) NOT NULL,
`id_client` bigint NOT NULL,
`total` decimal(19,2) NOT NULL,
CONSTRAINT `id_client` FOREIGN KEY (`id_client`) REFERENCES `clients` (`id_client`)
);


create table products (
`sku` bigint NOT NULL PRIMARY KEY unique,
`description` varchar(255) NOT NULL,
`purchase_price` decimal(19,2) NOT NULL,
`sale_price` decimal(19,2) NOT NULL,
`stock` int NOT NULL
);

create table sale_detail(
`id_detail` bigint NOT NULL AUTO_INCREMENT primary key unique,
`price` decimal(19,2) NOT NULL,
`quantity` int NOT NULL,
`total` decimal(19,2) NOT NULL,
`sku` bigint NOT NULL,
`sale_model_id_sale` bigint NOT NULL,
`detail_id_detail` bigint NOT NULL,
CONSTRAINT `detail_id_detail` FOREIGN KEY (`detail_id_detail`) REFERENCES `sale_detail` (`id_detail`),
CONSTRAINT `sku` FOREIGN KEY (`sku`) REFERENCES `products` (`sku`),
CONSTRAINT `sale_model_id_sale` FOREIGN KEY (`sale_model_id_sale`) REFERENCES `sale` (`id_sale`)
);


select * from clients;
select * from sale;
select * from products;
select * from sale_detail;