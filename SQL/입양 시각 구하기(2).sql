-- 코드를 입력하세요
with RECURSIVE HOURS as(
    select 0 as N
    union all
    select N + 1 as N
    from HOURS
    where 1 = 1 and N < 23
)

select h.N as HOUR, case when count(a.DATETIME) > 0 then count(a.DATETIME) else 0 end as COUNT
from HOURS h left outer join ANIMAL_OUTS a
on h.N = hour(a.DATETIME)
group by 1