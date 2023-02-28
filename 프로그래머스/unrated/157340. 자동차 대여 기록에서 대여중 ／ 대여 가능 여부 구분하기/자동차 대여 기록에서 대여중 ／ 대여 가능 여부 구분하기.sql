-- 코드를 입력하세요
SELECT CAR_ID , MAX(case when '2022-10-16' BETWEEN DATE_FORMAT(START_DATE, '%Y-%m-%d') and DATE_FORMAT(END_DATE, '%Y-%m-%d') then '대여중' else '대여 가능' end )as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by CAR_ID
order by CAR_ID DESC
