/* SQL Schema */
CREATE TABLE
    IF
    NOT EXISTS Employee
(
    Id        INT,
    Name      VARCHAR(10),
    Salary    INT,
    ManagerId INT
);
INSERT INTO Employee (Id, Name, Salary, ManagerId)
VALUES (1, 'Joe', 70000, 3),
       (2, 'Henry', 80000, 4),
       (3, 'Sam', 60000, NULL),
       (4, 'Max', 90000, NULL);


/* Solution */
SELECT
    # 将结果的字段名设置为Employee
    E1.Name AS Employee
FROM
    # E1与E2内连接，E1为员工，E2为经理
    Employee E1 INNER JOIN Employee E2
ON
    # 员工的经理id等于经理自己的id
    E1.ManagerId = E2.Id
    # 员工的工资大于经理的工资
    AND E1.Salary > E2.Salary;