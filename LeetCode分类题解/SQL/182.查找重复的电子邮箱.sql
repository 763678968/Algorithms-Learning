/* SQL Schema */
CREATE TABLE IF NOT EXISTS Person (Id INT, Email VARCHAR(100));
INSERT INTO
    Person (Id, Email)
VALUES
(1, 'a@b.com'),
(2, 'c@d.com'),
(3, 'a@b.com');


/* Solution */
# 对 Email 进行分组，如果并使用 COUNT 进行计数统计，结果大于等于 2 的表示 Email 重复。
SELECT
    Email
FROM
    Person
GROUP BY
    Email
HAVING
        COUNT(*) >= 2;