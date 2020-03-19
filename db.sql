.open contacts.db

CREATE TABLE Contact (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	name VARCHAR(50),
	family VARCHAR(50),
	phoneNumber VARCHAR(50));

INSERT INTO Contact (name, family, phoneNumber)
VALUES ('Denis', 'Sidorov', '+78468526565');

INSERT INTO Contact (name, family, phoneNumber)
VALUES ('Ivan', 'Ivanov', '+78468645264');