select a.DEPT_ID, a.DEPT_NAME_EN, round(avg(b.SAL)) as AVG_SAL
from HR_DEPARTMENT a, HR_EMPLOYEES b
where a.DEPT_ID = b.DEPT_ID
group by 1
order by 3 desc