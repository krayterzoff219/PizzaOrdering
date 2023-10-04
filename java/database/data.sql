BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (user_id, username, password_hash, role) VALUES (-1,'Guest','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_GUEST');
INSERT INTO users (username, password_hash, role) VALUES ('Margaret','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_EMPLOYEE');

INSERT INTO toppings (name, available, price) VALUES ('cheese', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('pepperoni', true, 0.75);
INSERT INTO toppings (name, available, price) VALUES ('ham', true, 0.75);
INSERT INTO toppings (name, available, price) VALUES ('pineapple', true, 0.75);
INSERT INTO toppings (name, available, price) VALUES ('bacon', true, 0.75);

INSERT INTO sauces (name, available, price) VALUES ('marinara', true, 0.50);
INSERT INTO sauces (name, available, price) VALUES ('alfredo', true, 1.00);

INSERT INTO crusts (name, available, price) VALUES ('regular', true, 0.50);
INSERT INTO crusts (name, available, price) VALUES ('cheesy', true, 1.50);

INSERT INTO sizes (name, available, price) VALUES ('Large', true, 14.00);
INSERT INTO sizes (name, available, price) VALUES ('Regular', true, 8.00);

INSERT INTO pizzas (size_id, crust_id, sauce_id) VALUES (1,1,1);

INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1001,1);
INSERT INTO pizzas_toppings (pizza_id, topping_id) VALUES (1001,2);

INSERT INTO menu_items (name, available, price, pizza_id) VALUES ('Pepperoni Pizza', true, 14.50, 1001);
INSERT INTO menu_items (name, available, price) VALUES ('Breadsticks', true, 5.00);

COMMIT TRANSACTION;
