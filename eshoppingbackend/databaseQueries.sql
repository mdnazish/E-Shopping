-- To Drop all the tables, views, sequence & etc..
	DROP ALL OBJECTS;


CREATE TABLE category(

	id IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	
	CONSTRAINT pk_category_id PRIMARY KEY (id)
);

-- adding five categories
INSERT INTO category(name, description, image_url, is_active) VALUES('Television','This is description for Television.!','CAT_1.png',true);
INSERT INTO category(name, description, image_url, is_active) VALUES('Laptop','This is description for Laptop.!','CAT_2.png',true);
INSERT INTO category(name, description, image_url, is_active) VALUES('Mobile','This is description for Mobile.!','CAT_3.png',true);
INSERT INTO category(name, description, image_url, is_active) VALUES('Ipad','This is description for Ipad.!','CAT_4.png',true);
INSERT INTO category(name, description, image_url, is_active) VALUES('Printer','This is description for Printer.!','CAT_5.png',true);

CREATE TABLE user_detail(

	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(20),
	enabled BOOLEAN,
	password VARCHAR(50),
	email VARCHAR(20),
	contact_number VARCHAR(13),
	
	CONSTRAINT pk_USER_id PRIMARY KEY (id)
);

  -- adding 1 admin and 2 supplier as user
INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('Md', 'Nazish', 'ADMIN', true, 'admin', 'mdnazish@gmail.com', '7777777777');

INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('Habib', 'Alam', 'SUPPLIER', true, 'habib', 'habib@gmail.com', '8888888888');

INSERT INTO user_detail(first_name, last_name, role, enabled, password, email, contact_number)
VALUES('Rashid', 'Alam', 'SUPPLIER', true, 'rashid', 'rashid@gmail.com', '9999999999');

CREATE TABLE product (

	id IDENTITY,
	code VARCHAR(20),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	
	CONSTRAINT pk_product_id PRIMARY KEY(id),
	CONSTRAINT pk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT pk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail (id),
	
	);
	
	-- adding five products
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABC123DEFX', 'iPhone 5s', 'apple', 'This is one of the best phone available in the market right now!', 18000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDDEF123DEFX', 'Samsung s7', 'samsung', 'A smart phone by samsung!', 32000, 2, true, 3, 3, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDPQR123WGTX', 'Google Pixel', 'google', 'This is one of the best android smart phone available in the market right now!', 57000, 5, true, 3, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDMNO123PQRX', ' Macbook Pro', 'apple', 'This is one of the best laptops available in the market right now!', 54000, 3, true, 1, 2, 0, 0 );
INSERT INTO product (code, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES ('PRDABCXYZDEFX', 'Dell Latitude E6510', 'dell', 'This is one of the best laptop series from dell that can be used!', 48000, 5, true, 1, 3, 0, 0 );
	
-- the address table to store the user billing and shipping address
CREATE TABLE address(
	id IDENTITY,
	user_id INT,
	address_line1 VARCHAR(100),
	address_line2 VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(10),
	postal_code INT,
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id) REFERENCES user_detail(id),
	CONSTRAINT fk_address_id PRIMARY KEY(id)
);

-- adding a supplier correspondece address
INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, is_billing, is_shipping) 
VALUES (1, '1-1-76/7 Quasab Tola, Bari Road', 'Near Ghani Market, Chatta Masjid', 'Gaya', 'Bihar', 'India', '823001', true, false );

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id IDENTITY,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

-- adding a cart for testing 
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (4, 0, 0);


-- the cart line table to store the cart details
CREATE TABLE cart_line (
	id IDENTITY,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id ) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);

-- the order detail table to store the order
CREATE TABLE order_detail (
	id IDENTITY,
	user_id int,
	order_total DECIMAL(10,2),
	order_count int,
	shipping_id int,
	billing_id int,
	order_date date,
	CONSTRAINT fk_order_detail_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT fk_order_detail_shipping_id FOREIGN KEY (shipping_id) REFERENCES address (id),
	CONSTRAINT fk_order_detail_billing_id FOREIGN KEY (billing_id) REFERENCES address (id),
	CONSTRAINT pk_order_detail_id PRIMARY KEY (id)
);

-- the order item table to store order items
CREATE TABLE order_item (
	id IDENTITY,
	order_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order_detail (id),
	CONSTRAINT pk_order_item_id PRIMARY KEY (id)
);

