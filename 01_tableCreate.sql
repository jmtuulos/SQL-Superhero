CREATE TABLE IF NOT EXISTS superhero(
	id serial PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	alias VARCHAR(50) NOT NULL,
	origin VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS assistant(
	id serial PRIMARY KEY,
	name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS power(
	id serial PRIMARY KEY,
  	name VARCHAR(255),
  	description VARCHAR(255)
);
