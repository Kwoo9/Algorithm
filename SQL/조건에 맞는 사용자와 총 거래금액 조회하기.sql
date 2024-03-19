select b.USER_ID, b.NICKNAME, sum(a.PRICE) as TOTAL_SALES
from USED_GOODS_BOARD a, USED_GOODS_USER b
where a.WRITER_ID = b.USER_ID and a.STATUS = 'DONE'
group by 1
having TOTAL_SALES >= 700000
order by 3