-- 코드를 입력하세요
SELECT
    COUNT(*)
FROM
    USER_INFO
WHERE
    age >= 20
    AND age <= 29
    AND joined >= '2021-01-01'
    AND joined < '2022-01-01';