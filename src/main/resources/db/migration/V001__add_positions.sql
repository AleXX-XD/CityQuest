CREATE TABLE IF NOT EXISTS positions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(100),
    longitude DOUBLE,
    latitude DOUBLE,
    radius DOUBLE
);