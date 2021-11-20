INSERT INTO tb_category (name) VALUES ('Livros');
INSERT INTO tb_category (name) VALUES ('Carros');
INSERT INTO tb_category (name) VALUES ('Roupas');
INSERT INTO tb_category (name) VALUES ('Acesorios');
INSERT INTO tb_category (name) VALUES ('Calças');


INSERT INTO tb_product (name, price) VALUES ('Cinco tons de cinza', 90.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);

INSERT INTO tb_product (name, price) VALUES ('HTML5', 70.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 1);

INSERT INTO tb_product (name, price) VALUES ('MySql', 80.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 4);

INSERT INTO tb_product (name, price) VALUES ('Java', 90.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (1, 1);

INSERT INTO tb_product (name, price) VALUES ('Corta os habitos', 40.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 5);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (5, 4);

INSERT INTO tb_product (name, price) VALUES ('Javascript', 120.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (6, 1);

INSERT INTO tb_product (name, price) VALUES ('Minha volta', 30.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 1);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 2);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 3);
INSERT INTO tb_product_category (product_id, category_id) VALUES (7, 4);

INSERT INTO tb_product (name, price) VALUES ('Casa de papel', 20.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (8, 1);

INSERT INTO tb_product (name, price) VALUES ('Fiat', 59.000);
INSERT INTO tb_product_category (product_id, category_id) VALUES (2, 2);

INSERT INTO tb_product (name, price) VALUES ('Casaco', 89.00);
INSERT INTO tb_product_category (product_id, category_id) VALUES (3, 3);


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

INSERT INTO tb_client (cpf_or_cnpj, email, name, type) VALUES ('120030114576', 'daniel@mail.com', 'daniel', 1);
INSERT INTO tb_phone (client_id, phones) VALUES (1, '19981020135');
INSERT INTO tb_address (cep, complement, district, logarant, number, city_id, client_id) VALUES ('12353-123', 'casa', 'Jardim São João', 634, '12343', 1, 1);


INSERT INTO tb_order (date, client_id, Address_id) VALUES (TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1, 1);
INSERT INTO tb_payment (order_id, state) VALUES (1, 2);
INSERT INTO tb_payment_with_bank_slip (due_date, pay_date, order_id) VALUES (TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1);

INSERT INTO tb_order (date, client_id, Address_id) VALUES (TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1, 1);
INSERT INTO tb_payment (order_id, state) VALUES (2, 1);
INSERT INTO tb_payment_with_card (number_of_installments, order_id) VALUES (2, 1);

INSERT INTO tb_order (date, client_id, Address_id) VALUES (TIMESTAMP WITH TIME ZONE '2020-07-13T20:50:07.12345Z', 1, 1);
INSERT INTO tb_payment (order_id, state) VALUES (3, 1);
INSERT INTO tb_payment_with_card (number_of_installments, order_id) VALUES (2, 3);


INSERT INTO tb_item_order (order_id, product_id, discount, quantity, price) VALUES (1, 1, 0.0 , 2, 49.90);
















