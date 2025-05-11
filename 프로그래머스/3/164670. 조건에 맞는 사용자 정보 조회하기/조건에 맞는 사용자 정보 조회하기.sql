# SUBSTRING(str, pos [, len])
# 인수	설명
# str	자르고 싶은 문자열
# pos	시작 위치 (1부터 시작)
# len (선택)	자를 길이 (생략하면 끝까지 자름)
SELECT
    user_id,
    nickname,
    CONCAT(ugu.city, ' ',ugu.street_address1, ' ', ugu.street_address2) AS '전체주소',
    CONCAT(
        SUBSTRING(ugu.tlno, 1, 3), '-',
        SUBSTRING(ugu.tlno, 4, 4), '-',
        SUBSTRING(ugu.tlno, 8)
    ) AS '전화번호'
FROM
    USED_GOODS_USER ugu
INNER JOIN
    USED_GOODS_BOARD ugb
ON
    ugu.user_id = ugb.writer_id
GROUP BY
    ugu.user_id,
    ugb.writer_id
HAVING
    COUNT(*) >= 3
ORDER BY
    user_id DESC;