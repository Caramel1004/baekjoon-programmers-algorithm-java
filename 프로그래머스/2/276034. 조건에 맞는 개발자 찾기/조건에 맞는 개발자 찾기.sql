# SKILLCODES: 프로그래밍 언어에 대한 정보를 담은 테이블
# DEVELOPERS: 프로그래밍 스킬 정보를 담은 테이블

SELECT
    id,
    email,
    first_name,
    last_name
FROM
    DEVELOPERS
WHERE
    SKILL_CODE & (1 << 8) | SKILL_CODE & (1 << 10)
ORDER BY
    id ASC;