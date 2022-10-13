create database proyectoRigobello;
use proyectoRigobello;

create table clientes (
id int primary key auto_increment,
dni varchar (11) not null unique,
nombre varchar(100),
apellido varchar(45),
fecha_nacimiento date
);

create table venta (
id int primary key auto_increment,
fecha_alta date,
total double,
cliente_id int,
constraint fk_cliente_id foreign key (cliente_id) references clientes(id)
);

create table productos (
id int primary key auto_increment,
sku varchar(50),
descripcion varchar(150),
precioCompra double,
precioVenta double,
stock int,
fecha_alta date
);

create table detalle_venta(
id int primary key auto_increment,
venta_id int,
detalle_id int,
producto_id int,
cantidad int,
subtotal double,
constraint fk_venta_id foreign key (venta_id) references venta(id),
constraint fk_producto_id foreign key (producto_id) references productos(id)
);


