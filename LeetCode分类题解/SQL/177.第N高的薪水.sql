/* SQL Schema */
CREATE TABLE IF NOT EXISTS Employee
(
    Id     INT,
    Salary INT
);
INSERT INTO Employee (Id, Salary)
VALUES (1, 100),
       (2, 200),
       (3, 300);


/* Solution */
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    SET N = N - 1;
    RETURN (
        SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT N,1
    );
END