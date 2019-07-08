DROP TABLE IF EXISTS product;
 
CREATE TABLE product (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price INT NOT NULL,
  description VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO product (name, price, description) VALUES
  ('iPhone 6', 499, 'iPhone 6 by Apple'),
  ('Note 8', 399, 'Samsung Note 8 mobile phone');