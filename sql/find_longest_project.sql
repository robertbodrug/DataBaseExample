
SELECT
ID,
DATEDIFF(MONTH,START_DATE,FINISH_DATE) AS MONTHS
FROM PROJECT
ORDER BY MONTHS DESC
LIMIT 1

