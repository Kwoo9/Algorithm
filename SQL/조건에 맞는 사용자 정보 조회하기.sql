SELECT b.USER_ID, b.NICKNAME, 
concat(b.CITY, ' ', b.STREET_ADDRESS1, ' ', b.STREET_ADDRESS2) as 전체주소, 
concat(substr(b.TLNO, 1, 3), '-', substr(b.TLNO, 4, 4), '-', substr(b.TLNO, 8, 4)) as 전화번호
from USED_GOODS_BOARD a, USED_GOODS_USER b
where a.WRITER_ID = b.USER_ID
group by 1
having count(a.WRITER_ID) >= 3
order by 1 desc