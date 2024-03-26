-- 코드를 작성해주세요
select count(*) as FISH_COUNT, max(fi.LENGTH) as MAX_LENGTH, fi.FISH_TYPE
from FISH_INFO fi
group by fi.FISH_TYPE
having avg(case when fi.LENGTH is null then 10 else fi.LENGTH end) >= 33
order by 3