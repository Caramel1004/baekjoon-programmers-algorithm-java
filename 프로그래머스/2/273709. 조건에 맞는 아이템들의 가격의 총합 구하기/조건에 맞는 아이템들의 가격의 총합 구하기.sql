# # 1. 조건 함수로 값 정해서 합산
SELECT
    SUM(IF(rarity = 'LEGEND', price, 0)) AS total_price
FROM
    ITEM_INFO;