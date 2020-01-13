/* SQL Schema */
# float(2,1)代表整数部分和小数部分一共2位，小数部分1位
CREATE TABLE IF NOT EXISTS cinema (id INT, movie VARCHAR(100), description VARCHAR(100), rating FLOAT(2,1));
INSERT INTO cinema (id, movie, description, rating) VALUES ('1', 'War', 'great 3D', '8.9');
INSERT INTO cinema (id, movie, description, rating) VALUES ('2', 'Science', 'fiction', '8.5');
INSERT INTO cinema (id, movie, description, rating) VALUES ('3', 'Irish', 'boring', '6.2');
INSERT INTO cinema (id, movie, description, rating) VALUES ('4', 'Ice song', 'Fantacy', '8.6');
INSERT INTO cinema (id, movie, description, rating) VALUES ('5', 'House card', 'Interesting', '9.1');

/* Solution */
SELECT
    *
FROM
    cinema
WHERE
            id % 2 = 1
  AND description != 'boring'
ORDER BY
    rating DESC;