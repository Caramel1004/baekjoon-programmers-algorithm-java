SELECT
    COUNT(*) AS fish_count
FROM
    FISH_INFO fi
LEFT JOIN
    FISH_NAME_INFO fni
ON 
    fi.fish_type = fni.fish_type
WHERE
    fni.fish_name IN('BASS', 'SNAPPER');
