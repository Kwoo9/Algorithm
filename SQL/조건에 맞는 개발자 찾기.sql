with PC as(
    select sum(CODE) as CODE
    from SKILLCODES
    where NAME = "Python" or NAME = "C#"
)

select d.ID, d.EMAIL, d.FIRST_NAME, d.LAST_NAME
from DEVELOPERS d, PC p
where d.SKILL_CODE & p.CODE > 0
order by 1