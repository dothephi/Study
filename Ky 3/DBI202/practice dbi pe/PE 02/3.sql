with t as(
select c.name, count(fc.category_id) as 'Number of films'
from film_category fc, category c
where fc.category_id = c.category_id
group by c.name)
select t.*
from t
order by t.[Number of films] asc