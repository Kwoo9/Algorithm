with SALES_COUNT as (
select BOOK_ID, sum(sales) CNT
from BOOK_SALES bs
where year(bs.sales_date) = 2022 and month(bs.sales_date) = 1
group by 1)

select category as CATEGORY, sum(CNT) as TOTAL_SALES
from BOOK b inner join SALES_COUNT sc
on b.BOOK_ID = sc.BOOK_ID
group by 1
order by 1