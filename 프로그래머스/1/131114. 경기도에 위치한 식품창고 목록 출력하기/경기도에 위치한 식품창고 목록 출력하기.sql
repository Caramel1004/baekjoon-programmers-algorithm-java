SELECT
    warehouse_id,
    warehouse_name,
    address,
    IF(freezer_yn IS NULL, 'N', freezer_yn) AS freezer_yn
FROM
    FOOD_WAREHOUSE
WHERE
    address LIKE '경기%'
ORDER BY
    warehouse_id ASC;