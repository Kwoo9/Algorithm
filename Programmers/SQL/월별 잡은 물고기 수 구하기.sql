select count(*) as FISH_COUNT, month(TIME) as MONTH
from FISH_INFO
group by 2
order by 2