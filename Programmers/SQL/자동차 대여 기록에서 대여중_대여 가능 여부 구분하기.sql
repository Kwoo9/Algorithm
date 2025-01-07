SELECT h.CAR_ID, 
case 
    when
        sum(case
                when '2022-10-16' between h.START_DATE and h.END_DATE
                then 1 else 0 end
        ) > 0 then '대여중' else '대여 가능' end as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
group by 1
order by h.car_id desc