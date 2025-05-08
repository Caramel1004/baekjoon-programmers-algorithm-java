# # 1. 조건 함수로 값 정해서 합산
SELECT
    SUM(IF(rarity = 'LEGEND', price, 0)) AS total_price
FROM
    ITEM_INFO;

# 2. 조건에 걸린 레코드의 가격만 합산
SELECT
    SUM(price) AS total_price
FROM
    ITEM_INFO
WHERE
    rarity = 'LEGEND';
