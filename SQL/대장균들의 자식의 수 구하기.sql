-- 코드를 작성해주세요

with parents as(
    select ed.PARENT_ID, count(ed.PARENT_ID) as CHILD_COUNT
    from ECOLI_DATA ed
    group by 1
)

# select *
# from parents

select ed.ID, coalesce(p.CHILD_COUNT, 0) as CHILD_COUNT
from ECOLI_DATA ed left join parents p on ed.ID = p.PARENT_ID
