select ins.ANIMAL_ID, outs.NAME
from ANIMAL_INS ins inner join ANIMAL_OUTS outs
on ins.ANIMAL_ID = outs.ANIMAL_ID
where ins.DATETIME > outs.DATETIME
order by ins.DATETIME