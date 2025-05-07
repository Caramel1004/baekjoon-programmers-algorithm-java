# USER_ID, PRODUCT_ID 그룹화된 그룹 안에 레코드 갯수가 2 이상인 것은 재구매가 일어난 것이므로
# having 절에 그룹 안에 레코드 갯수가 2이상인 조건을 추가
SELECT
    USER_ID,
    PRODUCT_ID
FROM
    ONLINE_SALE
GROUP BY
    USER_ID,
    PRODUCT_ID
HAVING
    COUNT(*) >= 2
ORDER BY
    USER_ID ASC,
    PRODUCT_ID DESC