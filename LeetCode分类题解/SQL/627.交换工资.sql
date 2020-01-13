/* SQL Schema */
CREATE TABLE IF NOT EXISTS salary(id INT, name VARCHAR(100), sex CHAR, salary INT);
TRUNCATE TABLE salary;
INSERT INTO salary (id, name, sex, salary) VALUES ('1', 'A', 'm', '2500');
INSERT INTO salary (id, name, sex, salary) VALUES ('2', 'B', 'f', '1500');
INSERT INTO salary (id, name, sex, salary) VALUES ('3', 'C', 'm', '5500');
INSERT INTO salary (id, name, sex, salary) VALUES ('4', 'D', 'f', '500');

/* Solution */
UPDATE salary
SET sex = CHAR(ASCII(sex) ^ ASCII('m') ^ ASCII('f'));
SELECT * FROM salary;