/* SQL Schema */
DROP TABLE
IF
    EXISTS World;
CREATE TABLE World ( NAME VARCHAR ( 255 ), continent VARCHAR ( 255 ), area INT, population INT, gdp INT );
INSERT INTO World ( NAME, continent, area, population, gdp )
VALUES
    ( 'Afghanistan', 'Asia', '652230', '25500100', '203430000' ),
    ( 'Albania', 'Europe', '28748', '2831741', '129600000' ),
    ( 'Algeria', 'Africa', '2381741', '37100000', '1886810000' ),
    ( 'Andorra', 'Europe', '468', '78115', '37120000' ),
    ( 'Angola', 'Africa', '1246700', '20609294', '1009900000' );

/* Solution */
# 方法一：直接查询
SELECT
    name,
    population,
    area
FROM
    World
WHERE
    population > 25000000
    OR area > 3000000;

# 方法二：组合查询，更快
SELECT
    name,
    population,
    area
FROM
    World
WHERE
    population > 25000000

UNION

SELECT
    name,
    population,
    area
FROM
    World
WHERE
    area > 3000000;