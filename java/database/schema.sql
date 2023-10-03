BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pizzas, user_data, toppings, orders, menu_items, orders_to_menu_items CASCADE;
DROP SEQUENCE IF EXISTS seq_pizza_id;


CREATE SEQUENCE seq_pizza_id
INCREMENT BY 1
START WITH 1001
NO MAXVALUE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE sizes (
    size_id SERIAL,
    name varchar(40) NOT NULL UNIQUE,
    available boolean NOT NULL,
    price numeric(10,2) NOT NULL,

    CONSTRAINT PK_pizza_size PRIMARY KEY (size_id)
);

CREATE TABLE crusts (
    crust_id SERIAL,
    name varchar(40) NOT NULL UNIQUE,
    available boolean NOT NULL,
    price numeric(10,2) NOT NULL,

    CONSTRAINT PK_pizza_crust PRIMARY KEY (crust_id)
);

CREATE TABLE sauces (
    sauce_id SERIAL,
    name varchar(40) NOT NULL UNIQUE,
    available boolean NOT NULL,
    price numeric(10,2) NOT NULL,

    CONSTRAINT PK_pizza_sauce PRIMARY KEY (sauce_id)
);

CREATE TABLE toppings (
    topping_id SERIAL,
    name varchar(40) NOT NULL UNIQUE,
    available boolean NOT NULL,
    price numeric(10,2) NOT NULL,

    CONSTRAINT PK_topping_id PRIMARY KEY (topping_id)
);

CREATE TABLE pizzas (
    pizza_id int NOT NULL DEFAULT nextval('seq_pizza_id'),
    size_id int NOT NULL,
    crust_id int NOT NULL,
    sauce_id int NOT NULL,

    CONSTRAINT PK_pizzas PRIMARY KEY (pizza_id),
    CONSTRAINT fk_size FOREIGN Key (size_id) REFERENCES sizes(size_id),
    CONSTRAINT fk_crust FOREIGN Key (crust_id) REFERENCES crusts(crust_id),
    CONSTRAINT fk_sauce FOREIGN Key (sauce_id) REFERENCES sauces(sauce_id)
);

CREATE TABLE pizzas_toppings (
    pizza_id int NOT NULL,
    topping_id int NOT NULL,

    CONSTRAINT ck_pizza_topping_id PRIMARY KEY (pizza_id, topping_id),
    CONSTRAINT fk_pizza_id FOREIGN KEY (pizza_id) REFERENCES pizzas(pizza_id),
    CONSTRAINT fk_topping_id FOREIGN KEY (topping_id) REFERENCES toppings(topping_id)
);

CREATE TABLE user_data (
    data_id SERIAL,
    user_id integer DEFAULT -1,
    email varchar(200) DEFAULT '',
    address varchar(200) DEFAULT '',
    phone varchar(15) DEFAULT '',
    credit_card varchar(16) DEFAULT '',
    CONSTRAINT pk_data_id PRIMARY KEY (data_id),
    CONSTRAINT fk_user_data_user FOREIGN Key (user_id) REFERENCES users(user_id)
);

CREATE TABLE orders (
    order_id SERIAL,
    status varchar(40) NOT NULL,
    data_id int NOT NULL,
    delivery boolean NOT NULL,
    subtotal numeric(10,2) NOT NULL,
    tax numeric(10,2) NOT NULL,

    CONSTRAINT PK_order_id PRIMARY KEY (order_id),
    CONSTRAINT fk_user_data_orders FOREIGN Key (data_id) REFERENCES user_data(data_id)
);

CREATE TABLE menu_items (
    item_id SERIAL,
    name varchar(40) NOT NULL UNIQUE,
    available boolean NOT NULL,
    price numeric(10,2) NOT NULL,
    description text DEFAULT '',
    image_url varchar(200) DEFAULT '',
    pizza_id int DEFAULT -1,

    CONSTRAINT PK_item_id PRIMARY KEY (item_id)
);

CREATE TABLE orders_to_menu_items (
    order_id int NOT NULL,
    item_id int NOT NULL,
    quantity int NOT NULL,

    CONSTRAINT ck_order_item_id PRIMARY KEY (order_id, item_id),
    CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders(order_id)
);


INSERT INTO users (user_id, username, password_hash, role) VALUES (-1,'Guest','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_GUEST');

INSERT INTO toppings (name, available, price) VALUES ('cheese', true, 0.50);
INSERT INTO toppings (name, available, price) VALUES ('pepperoni', true, 0.75);

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
