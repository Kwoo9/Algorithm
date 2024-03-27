-- 코드를 입력하세요

with AVAILABLE as(
    select h.CAR_ID,
    case when sum(
        case when (h.start_date between '2022-11-01' and '2022-11-30')
        or (h.END_DATE between '2022-11-01' and '2022-11-30')
        or (h.start_date < '2022-11-01' and h.END_DATE > '2022-11-30')
        then 1 else 0 end
    ) > 0 then '대여중' else '대여가능' end as avail
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY h
    group by 1
),

DISCOUNT as(
    select max(p.DISCOUNT_RATE) as discount, p.CAR_TYPE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN p
    where (p.CAR_TYPE = 'SUV' or p.CAR_TYPE = '세단') and (p.DURATION_TYPE = '7일 이상' or p.DURATION_TYPE = '30일 이상')
    group by 2
)

# select *
# from DISCOUNT

# select *
# from car_rental_company_discount_plan
# where car_type = "세단" or car_type = "SUV"

# select *
# from available a, car_rental_company_rental_history c, car_rental_company_car cc
# where a.CAR_ID = c.CAR_ID and c.CAR_ID = cc.CAR_ID and (cc.CAR_TYPE = "세단" or cc.CAR_TYPE = "SUV")
# order by a.CAR_ID, c.start_date

select c.CAR_ID, c.CAR_TYPE
, round(c.DAILY_FEE * 30 * 
(1 - (select discount from DISCOUNT d where d.CAR_TYPE = c.CAR_TYPE)/100)) as FEE
from AVAILABLE a, CAR_RENTAL_COMPANY_CAR c, DISCOUNT d
where a.avail = '대여가능' 
and c.CAR_ID = a.CAR_ID 
and (c.CAR_TYPE = '세단' or c.CAR_TYPE = 'SUV')
group by 1
having FEE between 500000 and 2000000
order by 3 desc, 2, 1 desc