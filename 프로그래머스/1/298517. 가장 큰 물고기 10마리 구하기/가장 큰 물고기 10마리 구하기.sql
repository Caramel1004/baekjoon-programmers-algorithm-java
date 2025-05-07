SELECT
    ID,
    LENGTH
FROM
    FISH_INFO
WHERE
    length > 10
    AND length IS NOT NULL
ORDER BY
    length DESC,
    id ASC
LIMIT
    10;
