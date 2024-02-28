CREATE TABLE Students (
    student_id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    date_created TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    group_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (group_id) REFERENCES University_groups(group_id)
);
