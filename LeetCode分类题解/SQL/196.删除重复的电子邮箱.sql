/* SQL Schema */
CREATE TABLE IF NOT EXISTS Person (Id INT, Email VARCHAR(100));
INSERT INTO
    Person (Id, Email)
VALUES
(1, 'john@example.com'),
(2, 'bob@example.com'),
(3, 'john@example.com');


/* Solution */
# 方法一：连接查询
DELETE
    p1
FROM
    Person p1, Person p2
WHERE
    p1.Email = p2.Email
  AND
    p1.Id > p2.Id;


# 方法二：子查询
DELETE
FROM
    Person
WHERE
    id NOT IN (
        SELECT id
        FROM (
            SELECT MIN(Id) AS Id
            FROM Person
            GROUP BY Email
        ) AS m
    );