CREATE TABLE vendors(
    id    SERIAL PRIMARY KEY,
    username VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE customers(
    id    SERIAL PRIMARY KEY,
    customer_name VARCHAR(40) NOT NULL UNIQUE,
    vendor_id integer REFERENCES vendors(id)
);

CREATE TABLE ORDERS(
    id SERIAL PRIMARY KEY,
    order_description VARCHAR(100) NOT NULL UNIQUE,
    order_date timestamp(0) without time zone,
    customer_id integer REFERENCES customers(id),
    vendor_id integer REFERENCES vendors(id)
);


