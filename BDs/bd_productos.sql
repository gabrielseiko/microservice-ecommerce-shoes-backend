-- Base de datos de Productos
DROP DATABASE IF EXISTS bd_store_products;
CREATE DATABASE bd_store_products;
use bd_store_products;

-- Tablas

-- tabla: marcas
CREATE TABLE tbl_brand (
    id_brand INT PRIMARY KEY AUTO_INCREMENT,           -- Id de la marca
    brand_name VARCHAR(100) NOT NULL,                  -- Nombre de la marca
    brand_description TEXT NOT NULL                     -- Descripción de la marca
);

-- add marcas
INSERT INTO tbl_brand (brand_name, brand_description) VALUES
('Nike', 'Referente en el mercado de zapatillas, conocida por su calidad.'),
('Adidas', 'Destacada por su tecnología avanzada en cada modelo.'),
('Puma', 'Marca icónica en el sector de zapatillas.'),
('Reebok', 'Símbolo de la moda urbana, conocida por su innovación.'),
('Converse', 'Zapatillas unisex que se adaptan a cualquier estilo.'),
('Fila', 'Diseños originales con estilo vintage de los años 90.');


-- tabla: categoria
CREATE TABLE tbl_category (
    id_category INT PRIMARY KEY AUTO_INCREMENT,         -- Id de la categoría
    category_name VARCHAR(100) NOT NULL,                -- Nombre de la categoría
    category_description TEXT NOT NULL                   -- Descripción de la categoría
);

-- add categoria
INSERT INTO tbl_category (category_name, category_description) VALUES
('Urbana', 'Zapatillas versátiles y de moda para el día a día.'),
('Deportivas', 'Zapatillas diseñadas para deportes y actividades físicas.'),
('Casual', 'Zapatillas cómodas para uso cotidiano e informal.'),
('Botines', 'Calzado resistente, perfecto para climas fríos o terrenos difíciles.'),
('Formal', 'Zapatillas elegantes y discretas para ocasiones formales.'),
('Mocasines', 'Calzado sin cordones, cómodo y elegante.');

-- tabla: genero
CREATE TABLE tbl_gender (
    id_gender INT PRIMARY KEY AUTO_INCREMENT,           -- Id del género
    gender_name VARCHAR(50) NOT NULL                    -- Nombre del género
);

-- add gemero
INSERT INTO tbl_gender (gender_name) VALUES
('Hombre'),
('Mujer'),
('Unisex');

-- tabla: producto (zapatillas)
CREATE TABLE tbl_product (
    id_product INT PRIMARY KEY AUTO_INCREMENT,           -- Id del producto
    product_name VARCHAR(200) NOT NULL,                  -- Nombre del producto
    product_description TEXT NOT NULL,                    -- Descripción del producto
    price DECIMAL(10,2) NOT NULL,                        -- Precio del producto
    product_image VARCHAR(250) NOT NULL,                 -- URL de la imagen del producto
    id_brand INT NOT NULL,                               -- Id de la marca
    id_category INT NOT NULL,                             -- Id de la categoría
    id_gender INT NOT NULL,                               -- Id del género
    CONSTRAINT fk_brand FOREIGN KEY (id_brand) REFERENCES tbl_brand(id_brand),
    CONSTRAINT fk_category FOREIGN KEY (id_category) REFERENCES tbl_category(id_category),
    CONSTRAINT fk_gender FOREIGN KEY (id_gender) REFERENCES tbl_gender(id_gender)
);

-- add zapatillas
INSERT INTO tbl_product (product_name, product_description, price, product_image, id_brand, id_category, id_gender) VALUES
('Nike Air Max 270', 'Las Nike Air Max 270 ofrecen una combinación perfecta de estilo y comodidad con una gran unidad de aire.', 129.99, 'https://example.com/nike_air_max_270.jpg', 1, 2, 1), 
('Adidas Ultraboost 21', 'Las Ultraboost 21 son ideales para correr y el uso diario, con una tecnología que ofrece una gran amortiguación.', 159.99, 'https://example.com/adidas_ultraboost_21.jpg', 2, 2, 1),  
('Puma RS-X Reinvent', 'Inspiradas en los modelos de los años 80, las Puma RS-X Reinvent aportan un look retro y moderno.', 109.99, 'https://example.com/puma_rs-x_reinvent.jpg', 3, 1, 2),
('Reebok Classic Leather', 'Un diseño clásico que nunca pasa de moda, ideal para un look casual y cómodo.', 89.99, 'https://example.com/reebok_classic_leather.jpg', 4, 3, 3),
('Converse Chuck Taylor All Star', 'Un clásico atemporal, las Converse Chuck Taylor son perfectas para cualquier ocasión.', 59.99, 'https://example.com/converse_chuck_taylor.jpg', 5, 3, 3),  -- Unisex
('Fila Disruptor II', 'Con su diseño robusto y llamativo, las Fila Disruptor II son perfectas para destacar en cualquier lugar.', 79.99, 'https://example.com/fila_disruptor_ii.jpg', 6, 1, 1);

-- tabla: tallas (sizes)
CREATE TABLE tbl_size (
    id_size INT PRIMARY KEY AUTO_INCREMENT,            -- Id de la talla
    id_product INT NOT NULL,                           -- Id del producto
    size_number INT NOT NULL,                          -- Número de talla
    CONSTRAINT fk_product FOREIGN KEY (id_product) REFERENCES tbl_product(id_product)
);

-- add talla
INSERT INTO tbl_size (id_product, size_number) VALUES
 -- Nike Air Max 270
(1, 38), 
(1, 39),
(1, 40),
(1, 41),
(1, 42),
(1, 43),
(1, 44),
(1, 45),
-- Adidas Ultraboost 21
(2, 38),  
(2, 39),
(2, 40),
(2, 41),
(2, 42),
(2, 43),
(2, 44),
(2, 45),
 -- Puma RS-X Reinvent
(3, 38), 
(3, 39),
(3, 40),
(3, 41),
(3, 42),
(3, 43),
(3, 44),
(3, 45),
 -- Reebok Classic Leather
(4, 38), 
(4, 39),
(4, 40),
(4, 41),
(4, 42),
(4, 43),
(4, 44),
(4, 45),
 -- Converse Chuck Taylor All Star
(5, 38), 
(5, 39),
(5, 40),
(5, 41),
(5, 42),
(5, 43),
(5, 44),
(5, 45),
 -- Fila Disruptor II
(6, 38), 
(6, 39),
(6, 40),
(6, 41),
(6, 42),
(6, 43),
(6, 44),
(6, 45);

-- tabla: stock
CREATE TABLE tbl_stock (
    id_stock INT PRIMARY KEY AUTO_INCREMENT,           -- Id del stock
    size_id INT NOT NULL,                              -- Id de la talla
    quantity INT NOT NULL,                             -- Cantidad de stock
    CONSTRAINT fk_size FOREIGN KEY (size_id) REFERENCES tbl_size(id_size)
);

-- add stock
INSERT INTO tbl_stock (size_id, quantity) VALUES
(1, 10),  -- Stock para Nike Air Max 270, talla 38
(2, 15),  -- Stock para Nike Air Max 270, talla 39
(3, 20),  -- Stock para Nike Air Max 270, talla 40
(4, 12),  -- Stock para Nike Air Max 270, talla 41
(5, 8),   -- Stock para Nike Air Max 270, talla 42
(6, 5),   -- Stock para Nike Air Max 270, talla 43
(7, 3),   -- Stock para Nike Air Max 270, talla 44
(8, 2),   -- Stock para Nike Air Max 270, talla 45
(9, 5),   -- Stock para Adidas Ultraboost 21, talla 38
(10, 7),  -- Stock para Adidas Ultraboost 21, talla 39
(11, 10), -- Stock para Adidas Ultraboost 21, talla 40
(12, 6),  -- Stock para Adidas Ultraboost 21, talla 41
(13, 4),  -- Stock para Adidas Ultraboost 21, talla 42
(14, 3),  -- Stock para Adidas Ultraboost 21, talla 43
(15, 2),  -- Stock para Adidas Ultraboost 21, talla 44
(16, 1),  -- Stock para Adidas Ultraboost 21, talla 45
(17, 10), -- Stock para Puma RS-X Reinvent, talla 38
(18, 15), -- Stock para Puma RS-X Reinvent, talla 39
(19, 20), -- Stock para Puma RS-X Reinvent, talla 40
(20, 12), -- Stock para Puma RS-X Reinvent, talla 41
(21, 8),  -- Stock para Puma RS-X Reinvent, talla 42
(22, 5),  -- Stock para Puma RS-X Reinvent, talla 43
(23, 3),  -- Stock para Puma RS-X Reinvent, talla 44
(24, 2),  -- Stock para Puma RS-X Reinvent, talla 45
(25, 6),  -- Stock para Reebok Classic Leather, talla 38
(26, 8),  -- Stock para Reebok Classic Leather, talla 39
(27, 12), -- Stock para Reebok Classic Leather, talla 40
(28, 5),  -- Stock para Reebok Classic Leather, talla 41
(29, 4),  -- Stock para Reebok Classic Leather, talla 42
(30, 3),  -- Stock para Reebok Classic Leather, talla 43
(31, 2),  -- Stock para Reebok Classic Leather, talla 44
(32, 1),  -- Stock para Reebok Classic Leather, talla 45
(33, 10), -- Stock para Converse Chuck Taylor, talla 38
(34, 15), -- Stock para Converse Chuck Taylor, talla 39
(35, 20), -- Stock para Converse Chuck Taylor, talla 40
(36, 12), -- Stock para Converse Chuck Taylor, talla 41
(37, 8),  -- Stock para Converse Chuck Taylor, talla 42
(38, 5),  -- Stock para Converse Chuck Taylor, talla 43
(39, 3),  -- Stock para Converse Chuck Taylor, talla 44
(40, 2),  -- Stock para Converse Chuck Taylor, talla 45
(41, 10), -- Stock para Fila Disruptor II, talla 38
(42, 15), -- Stock para Fila Disruptor II, talla 39
(43, 20), -- Stock para Fila Disruptor II, talla 40
(44, 12), -- Stock para Fila Disruptor II, talla 41
(45, 8),  -- Stock para Fila Disruptor II, talla 42
(46, 5),  -- Stock para Fila Disruptor II, talla 43
(47, 3),  -- Stock para Fila Disruptor II, talla 44
(48, 2);  -- Stock para Fila Disruptor II, talla 45


