CREATE DATABASE personal_finance;

CREATE TABLE Transactions(
	transaction_id PRIMARY KEY INTEGER,
	category_id INTEGER NOT NULL,
	type VARCHAR,
	amount NUMERIC NOT NULL,
	transaction_date DATE,
	description VARCHAR
	created_at TIMESTAMP,
	FOREIGN KEY category_id REFERENCES Categories (category_id)
);

CREATE TABLE Categories(
	category_id PRIMARY KEY INTEGER,
	name VARCHAR
);