/* SQL Schema */
CREATE TABLE IF NOT EXISTS Weather
(
    Id          INT,
    RecordDate  DATE,
    Temperature INT
);
INSERT INTO Weather (Id, RecordDate, Temperature)
VALUES ('1', '2015-01-01', '10'),
       ('2', '2015-01-02', '25'),
       ('3', '2015-01-03', '20'),
       ('4', '2015-01-04', '30');


/* Solution */
SELECT
    W2.Id
FROM
    Weather W1, Weather W2
WHERE TO_DAYS(W2.RecordDate) - TO_DAYS(W1.RecordDate) = 1
    AND W1.Temperature < W2.Temperature;