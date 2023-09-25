BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE pizzas (
    pizza_id SERIAL,
    size varchar(40) NOT NULL,
    crust varchar(40) NOT NULL,
    sauce varchar(40) NOT NULL,
    cheese boolean NOT NULL,
    pepperoni boolean NOT NULL,
    mushrooms boolean NOT NULL,

    CONSTRAINT PK_pizzas PRIMARY KEY (pizza_id)
);

COMMIT TRANSACTION;
