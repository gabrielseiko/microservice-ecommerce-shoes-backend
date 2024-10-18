-- Base de datos carrito de compras
DROP DATABASE IF EXISTS bd_store_shopping_cart;
CREATE DATABASE bd_store_shopping_cart;
use bd_store_shopping_cart;

-- tablas

-- tabla: carrito de compras
create table tbl_shopping_cart(
id_cart int primary key auto_increment,     		-- id
id_user int not null,								-- id del usuario
total_price decimal(10,2) not null, 				-- Precio total del carrito
date_create timestamp default current_timestamp, 	-- Fecha de creacion del carrito
state varchar(20) default 'active'                  -- Estado del carrito (activo, finalizado, cancelado)
); 

-- Tabla: detalle del carrito
create table tbl_cart_item (
  id_cart_item int primary key auto_increment,        -- ID único del ítem del carrito
  id_cart int not null,                               -- ID del carrito (FK hacia la tabla carritos)
  id_product int not null,                   		  -- ID del producto 
  quantity int not null,                              -- Cantidad de productos
  unit_price decimal(10, 2) not null,                 -- Precio unitario del producto
  subtotal_price decimal(10, 2) not null,             -- Precio total por ítem
  constraint fk_cart_item foreign key (id_cart) references tbl_shopping_cart(id_cart) -- Relación con la tabla de carritos
);

-- add carritos
insert into tbl_shopping_cart(id_user, total_price, state) values
(1, 100.00, 'active'),
(2, 250.00, 'active');

-- add items en el carrito
insert into tbl_cart_item(id_cart, id_product, quantity, unit_price, subtotal_price) values
(1, 1, 2, 50.00, 100.00),
(2, 2, 5, 50.00, 250.00);