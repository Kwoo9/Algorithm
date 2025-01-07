SELECT distinct c.CAR_ID
from CAR_RENTAL_COMPANY_CAR c, CAR_RENTAL_COMPANY_RENTAL_HISTORY h
where c.CAR_ID = h.CAR_ID and c.CAR_TYPE = '세단' and month(h.start_date) = 10
order by 1 desc