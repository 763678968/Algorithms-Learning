/* SQL Schema */
DROP TABLE
    IF
        EXISTS Customers;
CREATE TABLE Customers
(
    Id   INT,
    NAME VARCHAR(255)
);

DROP TABLE
    IF
        EXISTS Orders;
CREATE TABLE Orders
(
    Id         INT,
    CustomerId INT
);

INSERT INTO Customers (Id, NAME)
VALUES (1, 'Joe'),
       (2, 'Henry'),
       (3, 'Sam'),
       (4, 'Max');

INSERT INTO Orders (Id, CustomerId)
VALUES (1, 3),
       (2, 1);


/* Solution */
# 方法一：左外连接
SELECT C.NAME AS Customers
FROM Customers C
         LEFT JOIN Orders O
                   ON
                       C.Id = O.CustomerId
WHERE O.CustomerId IS NULL;

# 方法二：子查询
SELECT
    NAME AS Customers
FROM
    Customers
WHERE
    Id NOT IN (
        SELECT CustomerId
        FROM Orders
    );