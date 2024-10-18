-- Base de datos de Boleta
create database db_store_boleta;
use db_store_boleta;

-- Tabla: boleta
create table tbl_boleta (
  id_boleta int primary key auto_increment,            -- ID único del pedido
  id_user int not null,                                -- ID del usuario (FK hacia la tabla usuarios)
  total_amount decimal(10, 2) not null,                -- Monto total del pedido
  boleta_status varchar(20) default 'pending',         -- Estado del pedido (pendiente, pagado, cancelado)
  date_created timestamp default current_timestamp     -- Fecha de creación del pedido
);

-- Tabla: detalle de boleta
create table tbl_boleta_item (
  id_boleta_item int primary key auto_increment,       -- ID único del ítem de la boleta
  id_boleta int not null,                              -- ID del pedido (FK hacia la tabla de boleta)
  id_product int not null,                   		   -- ID del producto
  quantity int not null,                               -- Cantidad de productos
  unit_price decimal(10, 2) not null,                  -- Precio unitario del producto
  subtotal_price decimal(10, 2) not null,              -- Precio total por ítem
  constraint fk_boleta_item foreign key (id_boleta) references tbl_boleta(id_boleta) -- Relación con la tabla de boleta
);

-- Insertar boleta
insert into tbl_boleta(id_user, total_amount, boleta_status) values
(1, 200.00, 'pending'),
(2, 500.00, 'pending');

-- Insertar items en la boleta
insert into tbl_boleta_item(id_boleta, id_product, quantity, unit_price, subtotal_price) values
(1, '1', 2, 100.00, 200.00),
(2, '2', 5, 100.00, 500.00);
