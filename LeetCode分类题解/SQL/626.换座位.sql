/* SQL Schema */
Create table If Not Exists seat(id int, student varchar(255));
insert into seat (id, student)
values ('1', 'Abbot'),
       ('2', 'Doris'),
       ('3', 'Emerson'),
       ('4', 'Green'),
       ('5', 'Jeames');


/* Solution */
# 处理偶数id，让id-1
# 例如2,4,6...变成1,3,5...
SELECT s1.id - 1 AS 'id', s1.student
FROM seat s1
WHERE s1.id MOD 2 = 0

UNION
# 处理奇数id，让id+1。如果最大的id为奇数，则不做处理
# 例如1,3,5...变成2,4,6...
SELECT s2.id + 1 AS 'id', s2.student
FROM seat s2
WHERE s2.id MOD 2 = 1
  AND s2.id != (SELECT max(s3.id) FROM seat s3)

UNION
# 如果最大的id为奇数，单独取出这个数
SELECT s4.id AS 'id',
       s4.student
FROM seat s4
WHERE s4.id MOD 2 = 1
  AND s4.id = (SELECT max(s5.id) FROM seat s5)

ORDER BY id;