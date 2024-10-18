-- Base de datos Usuarios con autorizacion
DROP DATABASE IF EXISTS db_store_user;
CREATE DATABASE db_store_user;
use db_store_user;

-- tabla: rol
create table tbl_role(
id_role int primary key auto_increment ,  -- id
role_name varchar(50) not null, 		  -- nombre del rol
role_description text null 				  -- descripcion del rol
);

-- tabla: usuarios
create table tbl_user(
id_user int primary key auto_increment,   -- id
email varchar(100) not null unique, 	  -- correo unico (usuario para el logueo)
user_password varchar(300) not null,	  -- contrasenia
user_name varchar(50) not null, 		  -- nombre
last_name varchar(50) not null,			  -- apellidos
dni char(8) not null,					  -- dni
phone char(9) not null,					  -- telefono
state boolean default true,   			  -- estado para eliminarlo logicamente
date_register timestamp default current_timestamp -- fecha de registro del usuario
);

-- tabla: relacion usuaros y sus roles
create table tbl_user_has_role(
id_user int not null,
id_role int not null,
constraint foreign key (id_user) references tbl_user(id_user),
constraint foreign key (id_role) references tbl_role(id_role)
);

-- add role
insert into tbl_role(role_name, role_description) values
('admin', 'Administrador del sistema.'),
('worker', 'Trabajador del sistema.'),
('customer', 'Cliente del sistema.');

-- add user
INSERT INTO tbl_user(email, user_password, user_name, last_name, dni, phone) VALUES
('seiko@gmail.com', '$2a$10$nQmltI9mxAtleeWOkpNmZ.Mv9E8PAUJNPkM3MFk/N18SmHJNgR3Ae', 'Gabriel', 'Silva', '11001100','999000111'),
('kim@gmail.com', '$2a$10$nQmltI9mxAtleeWOkpNmZ.Mv9E8PAUJNPkM3MFk/N18SmHJNgR3Ae', 'Kimberly', 'Esquivel', '22001100', '999000222'),
('daniela@gmail.com', '$2a$10$nQmltI9mxAtleeWOkpNmZ.Mv9E8PAUJNPkM3MFk/N18SmHJNgR3Ae', 'Daniela', 'Guajardo', '33001100', '999000333');

-- add user has role
INSERT INTO tbl_user_has_role(id_user, id_role) VALUES
(1, 1),  -- Gabriel como admin
(2, 2),  -- Kimberly como worker
(3, 3);  -- Daniela como customer