with FE as(
    select sum(CODE) as CODE
    from SKILLCODES
    where CATEGORY = 'Front End'
)

select d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from DEVELOPERS d, FE f
where d.SKILL_CODE & f.CODE > 0
order by 1