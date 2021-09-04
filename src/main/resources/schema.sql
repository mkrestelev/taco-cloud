CREATE TABLE IF NOT EXISTS ingredient (
    id VARCHAR(4) NOT NULL,
    name VARCHAR(25) NOT NULL,
    type VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS taco (
    id identity,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS taco_ingredients (
    taco_id BIGINT NOT NULL,
    ingredients_id VARCHAR(4) NOT NULL
);

ALTER TABLE taco_ingredients
    ADD FOREIGN KEY (taco_id) REFERENCES taco(id);

ALTER TABLE taco_ingredients
    ADD FOREIGN KEY (ingredients_id) REFERENCES ingredient(id);

CREATE TABLE IF NOT EXISTS taco_order (
    id identity,
    name VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(2) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    cc_number VARCHAR(16) NOT NULL,
    cc_expiration VARCHAR(5) NOT NULL,
    cc_cvv VARCHAR(3) NOT NULL,
    placed_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS taco_order_tacos (
    taco_order BIGINT NOT NULL,
    taco BIGINT NOT NULL
);

ALTER TABLE taco_order_tacos
    ADD FOREIGN KEY (taco_order) REFERENCES taco_order(id);

ALTER TABLE taco_order_tacos
    ADD FOREIGN KEY (taco) REFERENCES taco(id);