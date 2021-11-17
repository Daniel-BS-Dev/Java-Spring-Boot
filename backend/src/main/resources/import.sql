INSERT INTO tb_category (name) VALUES ('Livros');
INSERT INTO tb_category (name) VALUES ('Carros');
INSERT INTO tb_category (name) VALUES ('Roupas');
INSERT INTO tb_category (name) VALUES ('Acesorios');
INSERT INTO tb_category (name) VALUES ('Calças');


INSERT INTO tb_product (name, price) VALUES ('Civic', 90.000);
INSERT INTO tb_product_category (product_id, category_id) VALUES (1,2);

INSERT INTO tb_product (name, price) VALUES ('Fiat', 59.000);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2,2);

INSERT INTO tb_product (name, price) VALUES ('Toro', 89.000);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3,2);

INSERT INTO tb_product (name, price) VALUES ('Corola', 109.000);
INSERT INTO tb_product_category (product_id, category_id) VALUES (4,2);