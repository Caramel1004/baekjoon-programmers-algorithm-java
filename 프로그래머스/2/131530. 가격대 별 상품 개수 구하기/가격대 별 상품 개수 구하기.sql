# 1. WITH
WITH product_cte AS (
    SELECT
        (price DIV 10000) * 10000 AS price_range
    FROM
        PRODUCT
)
SELECT
    price_range AS price_group,
    COUNT(price_range) AS products
FROM
    product_cte
GROUP BY
    price_range
ORDER BY
    price_range ASC;

# 2. sub
SELECT
    sub.price_range AS price_group,
    COUNT(sub.price_range) AS products
FROM
    (
        SELECT
            (price DIV 10000) * 10000 AS price_range
        FROM
            PRODUCT
    ) AS sub
GROUP BY
    price_range
ORDER BY
    price_range ASC;