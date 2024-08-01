SELECT RH.HISTORY_ID, 
ROUND(
    (DATEDIFF(RH.END_DATE, RH.START_DATE) + 1) * CC.DAILY_FEE *
      (1 - CASE
           WHEN DATEDIFF(RH.END_DATE, RH.START_DATE) + 1 >= 90 THEN 0.15
           WHEN DATEDIFF(RH.END_DATE, RH.START_DATE) + 1 >= 30 THEN 0.08
           WHEN DATEDIFF(RH.END_DATE, RH.START_DATE) + 1 >= 7 THEN 0.05
           ELSE 0 END)
      , 0) AS FEE
FROM CAR_RENTAL_COMPANY_CAR CC JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY RH
ON CC.CAR_ID = RH.CAR_ID
WHERE CC.CAR_TYPE = "트럭"
ORDER BY 2 DESC, 1 DESC