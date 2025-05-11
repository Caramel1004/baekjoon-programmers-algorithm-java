SELECT
    ao.animal_id,
    ao.name
FROM
    ANIMAL_INS ai
INNER JOIN
    ANIMAL_OUTS ao
ON
    ai.animal_id = ao.animal_id
ORDER BY
    TIMESTAMPDIFF(SECOND, ai.datetime, ao.datetime) DESC
LIMIT 2;