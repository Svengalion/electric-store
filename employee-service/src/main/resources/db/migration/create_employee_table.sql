CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    last_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100),
    birth_date DATE,
    position_id BIGINT,
    shop_id BIGINT,
    gender BOOLEAN
);
