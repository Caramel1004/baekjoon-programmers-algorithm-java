#1
# select
#     id,
#     email,
#     first_name,
#     last_name
# from
#     DEVELOPER_INFOS
# where
#     skill_1 = 'Python' or skill_2 = 'Python' or skill_3 = 'Python'
# order by
#     id ASC;

#2
select
    id,
    email,
    first_name,
    last_name
from
    DEVELOPER_INFOS
where
    'Python' IN (skill_1, skill_2, skill_3)
order by
    id ASC;