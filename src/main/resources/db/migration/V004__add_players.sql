CREATE TABLE IF NOT EXISTS stages (
    id INT PRIMARY KEY AUTO_INCREMENT,
    chatId VARCHAR(100),
    stage_id INT,
    position_id INT
);