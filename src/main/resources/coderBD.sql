use coderHouse;
CREATE TABLE Alumnos (nombre VARCHAR(150) NOT NULL, apellido VARCHAR (150) NOT NULL, dni INT NOT NULL, legajo INT NOT NULL);
SHOW TABLES;
DESCRIBE alumnos;
INSERT INTO alumnos values ( 'Gonzalo', 'Rigobello', '36614532', '74794');
INSERT INTO alumnos values ( 'Matias', 'Lopez', '1234567', '63773');
INSERT INTO alumnos values ( 'NN', 'NN', '1', '1');
SELECT * FROM alumnos;
SELECT * FROM productos;
SELECT * FROM rubros;
SELECT * FROM alumnos WHERE dni>15000000;
SELECT nombre FROM alumnos WHERE nombre='Gonzalo';
SELECT * FROM alumnos WHERE nombre='Gonzalo';
ALTER TABLE alumnos ADD column fecha_nacimiento date;
ALTER TABLE alumnos DROP column fecha_nacimiento;
CREATE TABLE productos (id INT , descripcion VARCHAR(45) NOT NULL);
ALTER TABLE productos ADD column id_rubro INT;

create table rubros (id int primary key auto_increment not null, descripcion varchar(20));

create table productos (id int primary key auto_increment not null, codigo int, descripcion varchar(20), precioCompra decimal, precioVenta decimal, stock int, rubro_id int, constraint fk_id_rubro foreign key (rubro_id) references rubros (id));

create database coder;
use coder;

create table clients (
id int primary key auto_increment,
dni varchar (11) not null unique,
name varchar(100) default null,
lastname varchar(45) default null,
birth_date date
);

create table sale (
id int primary key auto_increment,
high_date date,
total double,
client_id int,
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
detail_id int,
product_id int,
quantity int,
subtotal double,
constraint fk_sale_id foreign key (sale_id) references sale(id),
constraint fk_product_id foreign key (product_id) references products(id)
);

create table client (
id int primary key auto_increment,
name varchar(100) default null,
lastname varchar(45) default null,
birth_date date
);

select * from clients;
select * from client;
select * from sale;
select * from products;
select * from sale_detail;

DELETE FROM client WHERE id=9;
