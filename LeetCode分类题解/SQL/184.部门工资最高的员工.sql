/* SQL Schema */
DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee
(
    Id           INT,
    NAME         VARCHAR(255),
    Salary       INT,
    DepartmentId INT
);
DROP TABLE IF EXISTS Department;
CREATE TABLE Department
(
    Id   INT,
    NAME VARCHAR(255)
);
INSERT INTO Employee (Id, NAME, Salary, DepartmentId)
VALUES (1, 'Joe', 70000, 1),
       (2, 'Henry', 80000, 2),
       (3, 'Sam', 60000, 2),
       (4, 'Max', 90000, 1);
INSERT INTO Department (Id, NAME)
VALUES (1, 'IT'),
       (2, 'Sales');


/* Solution */
# 创建一个临时表，包含了部门员工的最大薪资。
# 可以对部门进行分组，然后使用MAX()汇总函数取得最大薪资
# 之后使用连接找到一个部门中薪资等于临时表中最大薪资的员工
SELECT
    D.NAME Department,
    E.NAME Employee,
    E.Salary
FROM
    Employee E,
    Department D,
    # 按照部门编号分组，选出工资最高的员工，组成一个临时表
    (SELECT DepartmentId, MAX(Salary) Salary
    FROM Employee
    GROUP BY DepartmentId) M
WHERE
    E.DepartmentId = M.DepartmentId
    AND E.Salary = M.Salary
    AND E.DepartmentId = D.Id;