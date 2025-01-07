select fi.id as ID, fni.FISH_NAME as FISH_NAME, fi.LENGTH as LENGTH
from FISH_INFO fi, FISH_NAME_INFO fni
where fi.FISH_TYPE = fni.FISH_TYPE
and fi.FISH_TYPE in 
(
    select FISH_TYPE
    from FISH_INFO
    group by fish_type
    having length = max(length)
)