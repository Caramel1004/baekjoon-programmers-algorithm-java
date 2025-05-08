SELECT
    it.item_id,
    ii.item_name
FROM
    ITEM_TREE it
INNER JOIN
    ITEM_INFO ii
ON it.item_id = ii.item_id
WHERE
    it.parent_item_id IS NULL;