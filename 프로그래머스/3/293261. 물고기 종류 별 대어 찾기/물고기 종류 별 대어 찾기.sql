SELECT
    fi.id AS id,
    sub.fish_name AS fish_name,
    sub.max_length AS length
FROM
    FISH_INFO fi
INNER JOIN (
    SELECT
        fni.fish_type AS fish_type,
        fni.fish_name AS fish_name,
        MAX(fi.length) AS max_length
    FROM
        FISH_INFO fi
    LEFT JOIN
        FISH_NAME_INFO fni
        ON fi.fish_type = fni.fish_type
    GROUP BY
        fni.fish_type,
        fni.fish_name
) AS sub
ON fi.fish_type = sub.fish_type AND fi.length = sub.max_length
ORDER BY
    fi.id ASC;
    