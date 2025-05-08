SELECT
    ri.rest_id AS rest_id,
    ri.rest_name AS rest_name,
    ri.food_type AS food_type,
    ri.favorites AS favorites,
    ri.address AS address,
    COALESCE(ROUND(AVG(rr.review_score), 2)) AS score
FROM
    REST_INFO ri
INNER JOIN
    REST_REVIEW rr
ON ri.rest_id = rr.rest_id
WHERE
    ri.address LIKE '서울%'
GROUP BY
    ri.rest_id
ORDER BY
    score DESC,
    favorites DESC;