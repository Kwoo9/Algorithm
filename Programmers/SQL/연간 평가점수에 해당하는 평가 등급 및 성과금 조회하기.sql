select b.EMP_NO, b.EMP_NAME, 
case 
when avg(c.SCORE) >= 96 then 'S'
when avg(c.SCORE) >= 90 then 'A'
when avg(c.SCORE) >= 80 then "B"
else 'C' end as GRADE,
b.SAL * case
when avg(c.SCORE) >= 96 then 0.2
when avg(c.SCORE) >= 90 then 0.15
when avg(c.SCORE) >= 80 then 0.1
else 0 end as BONUS
from HR_DEPARTMENT a, HR_EMPLOYEES b, HR_GRADE c
where a.DEPT_ID = b.DEPT_ID and b.EMP_NO = c.EMP_NO
group by 1
order by 1