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
),
CHILD as(select ID, case when ID not in (
    select case when PARENT_ID is null then 0 else PARENT_ID end
    from ECOLI_DATA
) then 1 else 0 end as child
from ECOLI_DATA)

select count(*) as COUNT, g.GEN as GENERATION
from GENERATION g inner join CHILD c
on g.ID = c.ID
where c.child = 1
group by 2
order by 2
