/* SQL Schema */
CREATE TABLE IF NOT EXISTS Scores
(
    Id    INT,
    Score DECIMAL(3, 2)
);
INSERT INTO Scores (Id, Score)
VALUES (1, 3.50),
       (2, 3.65),
       (3, 4.00),
       (4, 3.85),
       (5, 4.00),
       (6, 3.65);


/* Solution */
SELECT
    S1.Score 'Score',
    COUNT(DISTINCT S2.Score) 'Rank'
FROM
    Scores S1
    INNER JOIN Scores S2
    ON S1.Score <= S2.Score
GROUP BY
    S1.Id, S1.Score
ORDER BY
    S1.Score DESC;