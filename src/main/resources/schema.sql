CREATE TABLE devices (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         manufacturer VARCHAR(50),
                         model VARCHAR(100),
                         color_code VARCHAR(20),
                         storage_capacity INTEGER,
                         price DECIMAL(10,2),
                         status VARCHAR(20),
                         in_stock BOOLEAN
);