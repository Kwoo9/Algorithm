-- 코드를 입력하세요
SELECT ai.NAME, ai.DATETIME
from ANIMAL_INS ai
where ai.ANIMAL_ID not in (select ANIMAL_ID from ANIMAL_OUTS)
order by 2 limit 3