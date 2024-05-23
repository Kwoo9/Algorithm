-- 코드를 입력하세요
with JOINED_COUNT as(
select distinct count(*) as COUNTS
from USER_INFO
where year(joined) = 2021
),

PURCHASE as (
    select year(SALES_DATE) as YEAR, month(SALES_DATE) as MONTH, count(distinct USER_ID) as COUNT_AT
    from ONLINE_SALE
    where USER_ID in (select user_id
    from USER_INFO
    where year(joined) = 2021)
    group by 1, 2
)

select p.YEAR, p.MONTH, p.COUNT_AT as PUCHASED_USERS, round(p.COUNT_AT / jc.COUNTS, 1) as PUCHASED_RATIO
from JOINED_COUNT jc, PURCHASE p
group by 1, 2
order by 1, 2
