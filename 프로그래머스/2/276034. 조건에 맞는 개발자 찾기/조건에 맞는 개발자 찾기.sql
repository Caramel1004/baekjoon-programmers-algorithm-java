# SKILLCODES에서 OR 연산 → 상수 값으로 추려냄 (예: 2 | 4 = 6)
# WHERE skill_code & 6 > 0 → 단일 테이블에서 필터링만 수행
# JOIN 없음, DISTINCT 없음, 조건 단순
# 대부분의 RDBMS에서 훨씬 더 효율적인 실행 계획 생성
SELECT
    id,
    email,
    first_name,
    last_name
FROM
    DEVELOPERS dev
WHERE
    dev.skill_code & 
        (
            SELECT BIT_OR(code)
            FROM SKILLCODES
            WHERE name IN ('Python', 'C#')
        ) > 0
ORDER BY
    id ASC;
