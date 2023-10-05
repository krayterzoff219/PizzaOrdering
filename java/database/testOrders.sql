BEGIN TRANSACTION;

INSERT INTO users (username, password_hash, role) VALUES ('Margaret','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_EMPLOYEE');
INSERT INTO users (username,password_hash,role) VALUES ('test','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO user_data (user_id) VALUES (3);
INSERT INTO user_data (user_id, name, email, address, phone, credit_card) VALUES (4, 'test', 'test@email', 'streetaddress|||city|||state|||12345', '1234567890', '123456789');


INSERT INTO user_data (name, email, address, phone, credit_card) VALUES ('Richard', 'richard@example.com', '1234 Somewhere Dr.|||Columbus|||Ohio|||12345', '1112223344', '123456789');
INSERT INTO orders (status, data_id, delivery, subtotal, tax) VALUES ('pending', 5, true, 56.50, 4.52);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (1, 1, 2);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (1, 2, 1);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (1, 3, 1);

INSERT INTO user_data (name, email, address, phone, credit_card) VALUES ('Margaret', 'margaret@example.com', '2345 Anywhere Rd.|||Columbus|||Ohio|||12345', '2223334455', '123456789');
INSERT INTO orders (status, data_id, delivery, subtotal, tax) VALUES ('pending', 6, false, 29.50, 2.36);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (2, 5, 2);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (2, 4, 1);

INSERT INTO user_data (name, email, address, phone, credit_card) VALUES ('Daniel', 'daniel@example.com', '3456 Nowhere Dr.|||Columbus|||Ohio|||12345', '3334445566', '123456789');
INSERT INTO orders (status, data_id, delivery, subtotal, tax) VALUES ('pending', 7, true, 48.75, 3.90);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (3, 5, 1);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (3, 4, 1);
INSERT INTO pizzas (size_id, crust_id, sauce_id) VALUES (2,4,2);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1009,1);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1009,23);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1009,24);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1009,8);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1009,11);
INSERT INTO orders_to_menu_items (order_id, item_id, quantity) VALUES (3, 1009, 1);
















COMMIT TRANSACTION;