create table orderItems(
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_ID INT,
    product_ID INT,
    quantity INT NOT NULL,
    price INT,
    FOREIGN KEY(order_ID) REFERENCES orders(order_ID),
    FOREIGN KEY(product_ID) REFERENCES products(product_ID)
);