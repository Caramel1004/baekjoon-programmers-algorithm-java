# 비트 연산 필요
# 0번째 비트가 1인지 0인지 판별하는 비트연산 필요
# 2번째 비트가 1인지 0인지 판별하는 비트연산 필요 
SELECT
    COUNT(*) AS count
FROM
    ECOLI_DATA
WHERE
    genotype & (1 << 1) = 0
    AND genotype & (1 << 2) | genotype & 1;