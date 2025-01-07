select count(a.FISH_TYPE) as FISH_COUNT, b.FISH_NAME as FISH_NAME
from FISH_INFO a, FISH_NAME_INFO b
where a.FISH_TYPE = b.FISH_TYPE
group by 2
order by 1 desc