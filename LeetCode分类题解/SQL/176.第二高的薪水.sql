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
# 为了在没有查找到数据时返回null，需要在查询结果外面再套一层SELECT
SELECT (
    SELECT DISTINCT
        Salary
    FROM
        Employee
    ORDER BY Salary DESC
    LIMIT 1,1) AS SeondHighestSalary;
