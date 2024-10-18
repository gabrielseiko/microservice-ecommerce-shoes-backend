-- Base de datos pagos
create database db_store_payment;
use db_store_payment;

-- Tabla: pagos
create table tbl_payment (
  id_payment int primary key auto_increment,          -- ID único del pago
  id_boleta int not null,                              -- ID del pedido (FK hacia la tabla pedidos)
  payment_method varchar(50) not null,                -- Método de pago (tarjeta, PayPal, etc.)
  payment_status varchar(20) default 'pending',       -- Estado del pago (pendiente, completado, fallido)
  payment_date timestamp default current_timestamp,   -- Fecha del pago
  amount decimal(10, 2) not null                     -- Monto pagado
);

-- Insertar pagos
insert into tbl_payment(id_boleta, payment_method, payment_status, amount) values
(1, 'credit_card', 'completed', 200.00),
(2, 'paypal', 'pending', 500.00);
