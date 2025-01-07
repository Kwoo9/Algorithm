-- 코드를 작성해주세요

with RECURSIVE GENERATION as(
    select ID, PARENT_ID, 1 as GEN
    from ECOLI_DATA
    where PARENT_ID is null
    
    UNION ALL(
        select e.ID, e.PARENT_ID, g.GEN + 1 as GEN
        from ECOLI_DATA e, GENERATION g
        where e.PARENT_ID = g.ID
    )
)

select ID
from GENERATION
where GEN = 3