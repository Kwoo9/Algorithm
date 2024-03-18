with PYTHON as(
    select CODE
    from SKILLCODES
    where NAME = 'Python'
),

CS as(
    select CODE
    from SKILLCODES
    where NAME = 'C#'
),
FE as(
    select sum(CODE) as CODE
    from SKILLCODES
    where CATEGORY = 'Front End'
)

select 
case
when d.SKILL_CODE & p.CODE > 0 and  d.SKILL_CODE & f.CODE then 'A'
when d.SKILL_CODE & c.CODE > 0 then 'B'
when d.SKILL_CODE & f.CODE > 0 then 'C'
end as GRADE, d.ID, d.EMAIL
from DEVELOPERS d, PYTHON p, CS c, FE f
having GRADE is not null
order by 1, 2