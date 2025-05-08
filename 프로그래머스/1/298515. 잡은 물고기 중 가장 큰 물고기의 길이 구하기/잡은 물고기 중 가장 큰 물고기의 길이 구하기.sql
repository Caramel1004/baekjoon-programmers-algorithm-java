SELECT
    concat(length, 'cm') AS max_length
FROM
    FISH_INFO
WHERE
    length IS NOT NULL
ORDER BY
    length DESC
LIMIT 1;