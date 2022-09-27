CREATE TABLE IF NOT EXISTS stages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    message MEDIUMTEXT,
    answer TEXT,
    help MEDIUMTEXT,
    position_id INT
);