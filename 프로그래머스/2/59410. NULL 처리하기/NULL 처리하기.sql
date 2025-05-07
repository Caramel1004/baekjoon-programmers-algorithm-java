SELECT
    animal_type,
    IF(name IS NOT NULL, name, 'No name') AS name,
    sex_upon_intake
FROM
    ANIMAL_INS
ORDER BY
    animal_id ASC;