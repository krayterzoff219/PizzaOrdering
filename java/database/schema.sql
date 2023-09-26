BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pizzas, user_data;


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

CREATE TABLE user_data (
    user_id integer NOT NULL UNIQUE,
    email varchar(200) DEFAULT '',
    address varchar(200) DEFAULT '',
    phone varchar(15) DEFAULT '',
    credit_card varchar(16) DEFAULT '',
    CONSTRAINT pk_user_data PRIMARY KEY (user_id),
    CONSTRAINT fk_user_data_user FOREIGN Key (user_id) REFERENCES users(user_id)
);

COMMIT TRANSACTION;
