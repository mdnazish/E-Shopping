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
