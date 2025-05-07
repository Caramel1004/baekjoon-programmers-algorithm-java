SELECT
    COUNT(*) AS fish_count
FROM
    FISH_INFO
WHERE
    length <= 10 OR length IS NULL