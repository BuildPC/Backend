/* Customer */
CREATE TABLE Customer (
username VARCHAR(255) NOT NULL,
first_name VARCHAR(15) NOT NULL,
last_name VARCHAR(15) NOT NULL,
phone VARCHAR(12) NOT NULL,
caddress VARCHAR(100) NOT NULL,
PRIMARY KEY (username),
FOREIGN KEY (username) REFERENCES users(email)
);

/* Item */
CREATE TABLE Item (
item_id NOT NULL AUTO_INCREMENT,
item_name TEXT NOT NULL,
category INT NOT NULL,
item_desc TEXT NOT NULL,
stock INT NOT NULL,
price FLOAT NOT NULL,
photo TEXT,
PRIMARY KEY (item_id)
);

/* Basket */
CREATE TABLE Basket (
basket_id INT NOT NULL,
username VARCHAR(15) NOT NULL,
PRIMARY KEY (basket_id),
FOREIGN KEY (username) REFERENCES Customer(username)
);

/* Basket Contains */
CREATE TABLE BContains (
basket_id INT NOT NULL,
item_id INT NOT NULL,
amount INT NOT NULL,
PRIMARY KEY (basket_id, item_id),
FOREIGN KEY (basket_id) REFERENCES Basket(basket_id),
FOREIGN KEY (item_id) REFERENCES Item(item_id)
);

/* History(Sold Baskets) */
CREATE TABLE History (
basket_id INT NOT NULL,
PRIMARY KEY (basket_id),
FOREIGN KEY (basket_id) REFERENCES Basket(basket_id)
);

