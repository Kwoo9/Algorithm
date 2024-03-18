with SCORES as(
    select EMP_NO, sum(SCORE) as SCORE
    from HR_GRADE
    GROUP BY EMP_NO
)

select b.SCORE as SCORE, a.EMP_NO, a.EMP_NAME, a.POSITION, a.EMAIL
from HR_EMPLOYEES a, SCORES b
where b.EMP_NO = a.EMP_NO and SCORE = (select max(SCORE) from SCORES)
order by 1 desc