-- 코드를 입력하세요
SELECT ROUND(sum(DAILY_FEE)/count(*),0) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where CAR_TYPE = 'SUV'