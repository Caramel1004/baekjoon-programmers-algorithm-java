SELECT
    member_id,
    member_name,
    gender,
    DATE_FORMAT(date_of_birth, '%Y-%m-%d') AS data_of_birth
FROM
    MEMBER_PROFILE
WHERE
    MONTH(date_of_birth) = 3
    AND gender = 'W'
    AND tlno IS NOT NULL
ORDER BY
    member_id ASC;
