/* SQL Schema */
DROP TABLE
    IF
        EXISTS Person;
CREATE TABLE Person
(
    PersonId  INT,
    FirstName VARCHAR(255),
    LastName  VARCHAR(255)
);
DROP TABLE
    IF
        EXISTS Address;
CREATE TABLE Address
(
    AddressId INT,
    PersonId  INT,
    City      VARCHAR(255),
    State     VARCHAR(255)
);
INSERT INTO Person (PersonId, LastName, FirstName)
VALUES (1, 'Wang', 'Allen');
INSERT INTO Address (AddressId, PersonId, City, State)
VALUES (1, 2, 'New York City', 'New York');


/* Solution */
# 涉及到 Person 和 Address 两个表，在对这两个表
# 执行连接操作时，因为要保留 Person 表中的信息，
# 即使在 Address 表中没有关联的信息也要保留。此
# 时可以用左外连接，将 Person 表放在 LEFT JOIN 的左边。
SELECT FirstName, LastName, City, State
FROM
    Person P
    LEFT JOIN Address A
    ON P.PersonId = A.PersonId;