/* SQL Schema */
Create table If Not Exists Logs
(
    Id  int,
    Num int
);
insert into Logs (Id, Num)
values ('1', '1'),
       ('2', '1'),
       ('3', '1'),
       ('4', '2'),
       ('5', '1'),
       ('6', '2'),
       ('7', '2');


/* Solution */
SELECT
    DISTINCT L1.Num 'ConsecutiveNums'
FROM
    Logs L1,
    Logs L2,
    Logs L3
WHERE L1.Id = L2.Id - 1
    AND L2.Id = L3.Id - 1
    AND L1.Num = L2.Num
    AND L2.Num = L3.Num;