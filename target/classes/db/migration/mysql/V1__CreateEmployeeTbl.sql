
CREATE TABLE IF NOT EXISTS Employee
(
    id INT AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(25) NOT NULL,
    date_of_birth DATE NOT NULL,
    hired_date DATE NOT NULL,
    termination_date DATE,
    PRIMARY KEY(id)
)