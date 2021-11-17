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


INSERT INTO tb_state (name) VALUES ('São Paulo');
INSERT INTO tb_city (name, id_state) VALUES ('Campinas', 1);

INSERT INTO tb_state (name) VALUES ('Pernambuco');
INSERT INTO tb_city (name, id_state) VALUES ('Tupanatinga', 2);

INSERT INTO tb_state (name) VALUES ('Minas Gerais');
INSERT INTO tb_city (name, id_state) VALUES ('Hamburgo', 3);

INSERT INTO tb_state (name) VALUES ('Para');
INSERT INTO tb_city (name, id_state) VALUES ('Cataraga', 4);

INSERT INTO tb_state (name) VALUES ('Santa Catarina');
INSERT INTO tb_city (name, id_state) VALUES ('Rio Belo', 5);


