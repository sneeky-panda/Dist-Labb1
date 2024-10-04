CREATE TABLE users (
                       user_ID INT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(100) NOT NULL UNIQUE,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(250) NOT NULL,  -- Ökad längd för hashade lösenord
                       role VARCHAR(50) NOT NULL
);

CREATE TABLE products (
                          product_ID INT AUTO_INCREMENT PRIMARY KEY,
                          product_name VARCHAR(250) NOT NULL UNIQUE,
                          product_description VARCHAR(250),
                          price INT NOT NULL,
                          stock INT NOT NULL CHECK (stock >= 0)  -- Lager kan inte vara negativt
);

CREATE TABLE orders (
                        order_ID INT AUTO_INCREMENT PRIMARY KEY,
                        user_ID INT NOT NULL,
                        order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                        total_price INT,
                        status ENUM('Pending', 'Completed', 'Cancelled') DEFAULT 'Pending',
                        FOREIGN KEY (user_ID) REFERENCES users(user_ID)
);

CREATE TABLE orderItems (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            order_ID INT,
                            product_ID INT,
                            quantity INT NOT NULL CHECK (quantity > 0),  -- Kvantitet måste vara större än 0
                            price INT NOT NULL,
                            FOREIGN KEY(order_ID) REFERENCES orders(order_ID) ON DELETE CASCADE,
                            FOREIGN KEY(product_ID) REFERENCES products(product_ID) ON DELETE RESTRICT
);

CREATE TABLE cart (
                      user_ID INT,
                      cart_ID INT AUTO_INCREMENT PRIMARY KEY,
                      FOREIGN KEY (user_ID) REFERENCES users(user_ID) ON DELETE CASCADE
);

CREATE TABLE cartItems (
                           cart_item_ID INT AUTO_INCREMENT PRIMARY KEY,
                           cart_ID INT,
                           product_ID INT,
                           quantity INT NOT NULL CHECK (quantity > 0),  -- Kvantitet måste vara större än 0
                           FOREIGN KEY(cart_ID) REFERENCES cart(cart_ID) ON DELETE CASCADE,
                           FOREIGN KEY(product_ID) REFERENCES products(product_ID) ON DELETE RESTRICT
);