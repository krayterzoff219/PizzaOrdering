BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (user_id, username, password_hash, role) VALUES (-1,'Guest','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_GUEST');
INSERT INTO users (username, password_hash, role) VALUES ('Margaret','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_EMPLOYEE');
INSERT INTO users (username,password_hash,role) VALUES ('test','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO user_data (user_id, name, email, address, phone, credit_card) VALUES (4, 'test', 'test@email', 'streetaddress|||city|||state|||12345', '1234567890', '123456789');

INSERT INTO toppings (name, available, price) VALUES ('cheese', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('pepperoni', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('ham', true, 0.75);
INSERT INTO toppings (name, available, price) VALUES ('pineapple', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('bacon', true, 1.25);
INSERT INTO toppings (name, available, price) VALUES ('steak', true, 1.25);
INSERT INTO toppings (name, available, price) VALUES ('chicken', true, 1.25);
INSERT INTO toppings (name, available, price) VALUES ('onion', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('mushroom', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('olives', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('green peppers', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('spinach', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('feta cheese', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('parmesan', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('tomato', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('banana peppers', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('jalapeno peppers', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('artichokes', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('kale', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('red pepper', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('honey drizzle', true, 0.50);

INSERT INTO sauces (name, available, price) VALUES ('marinara', true, 0.50);
INSERT INTO sauces (name, available, price) VALUES ('alfredo', true, 1.00);
INSERT INTO sauces (name, available, price) VALUES ('bbq', true, 1.00);
INSERT INTO sauces (name, available, price) VALUES ('buffalo', true, 1.00);

INSERT INTO crusts (name, available, price) VALUES ('hand tossed', true, 0.50);
INSERT INTO crusts (name, available, price) VALUES ('cheesy', true, 1.50);
INSERT INTO crusts (name, available, price) VALUES ('cauliflower', true, 1.50);
INSERT INTO crusts (name, available, price) VALUES ('pan', true, 1.50);

INSERT INTO sizes (name, available, price) VALUES ('Ex Large', true, 20.00);
INSERT INTO sizes (name, available, price) VALUES ('Large', true, 14.00);
INSERT INTO sizes (name, available, price) VALUES ('Medium', true, 8.00);
INSERT INTO sizes (name, available, price) VALUES ('Small', true, 5.00);

INSERT INTO pizzas (size_id, crust_id, sauce_id) VALUES (2,1,1);
INSERT INTO pizzas (size_id, crust_id, sauce_id) VALUES (2,2,1);
INSERT INTO pizzas (size_id, crust_id, sauce_id) VALUES (2,1,1);
INSERT INTO pizzas (size_id, crust_id, sauce_id) VALUES (2,1,2);

INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1001,1);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1001,2);

INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1002,1);

INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1003,1);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1003,3);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1003,4);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1003,5);

INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1004,1);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1004,8);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1004,9);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1004,10);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1004,11);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1004,12);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1004,15);

INSERT INTO menu_items (name, available, price, pizza_id, image_url, description) VALUES ('Pepperoni Pizza', true, 14.50, 1001, 'https://img.freepik.com/free-photo/delicious-neapolitan-meat-pizza-pizzeria-delicious-food_78826-2833.jpg?size=626&ext=jpg&ga=GA1.1.481236351.1695826882&semt=ais', 'Classic Pepperoni');
INSERT INTO menu_items (name, available, price, pizza_id, image_url, description) VALUES ('Cheese Pizza', true, 12.50, 1002, 'https://img.freepik.com/free-photo/pizza-four-cheese-table_140725-5391.jpg', 'The Cheese');
INSERT INTO menu_items (name, available, price, pizza_id, image_url, description) VALUES ('Hawaiian Pizza', true, 16.50, 1003, 'https://img.freepik.com/free-photo/pizza-wooden-background_1232-2681.jpg?w=1380&t=st=1696452828~exp=1696453428~hmac=5c2e6b4702030a705a3248d9354480c179320cdc341d89afc4b6d2eec3de52dd', 'Hawaiian with bacon, ham, and pineapple please');
INSERT INTO menu_items (name, available, price, pizza_id, image_url, description) VALUES ('vegetable Pizza', true, 15.50, 1004, 'https://img.freepik.com/free-photo/meat-pizza-bell-pepper-basil-arugula-tomato-cheese-onion-top-view_141793-2772.jpg?w=996&t=st=1696453323~exp=1696453923~hmac=a83774b9c9482a4bac915a2f8046b0453b987bc9eee3508f608bbe0112b22a77', 'For the vegetable lover!');
INSERT INTO menu_items (name, available, price) VALUES ('Breadsticks', true, 5.00);

COMMIT TRANSACTION;
