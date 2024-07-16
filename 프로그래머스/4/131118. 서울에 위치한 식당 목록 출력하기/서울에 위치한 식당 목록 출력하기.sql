select i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS
, ROUND(AVG(r.REVIEW_SCORE), 2) as score 
from rest_info i join rest_review r 
on i.rest_id = r.rest_id 
where i.address like'서울%'
group by i.REST_ID, i.REST_NAME, i.FOOD_TYPE, i.FAVORITES, i.ADDRESS
order by score desc, i.favorites desc