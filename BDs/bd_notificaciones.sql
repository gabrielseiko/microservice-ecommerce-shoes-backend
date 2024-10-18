--  Base de datos de Notificaciones a Emial
DROP DATABASE IF EXISTS db_store_notifications;
CREATE DATABASE db_store_notifications;
use db_store_notifications;

-- tabla: notificaciones 
create table tbl_notification (
    id_notification int primary key auto_increment,          -- ID único de la notificación
    email varchar(100) not null,                             -- Correo electrónico del destinatario
	email_subject varchar(100) not null,                           -- Asunto del correo
    message text not null,                                   -- Cuerpo del mensaje enviado
    notification_type varchar(20) not null,                  -- Tipo de notificación (registro, compra, etc.)
    state varchar(20) default 'sent',                       -- Estado de la notificación (sent, failed)
    date_sent timestamp default current_timestamp            -- Fecha de envío
);

-- add
insert into tbl_notification (email, email_subject, message, notification_type, state) values 
('seiko@gmail.com', 'Bienvenido a nuestra tienda', 'Hola Gabriel Silva,\n\nGracias por registrarte en nuestra tienda.', 'registro', 'sent');
