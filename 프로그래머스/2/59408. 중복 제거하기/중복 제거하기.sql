# 1. 그룹화로 중복제거
SELECT COUNT(*)
FROM (
    SELECT name
    FROM ANIMAL_INS
    WHERE name IS NOT NULL
    GROUP BY name
) AS sub;