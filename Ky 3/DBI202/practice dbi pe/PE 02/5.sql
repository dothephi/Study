with t as(
select a.first_name, count(fc.film_id) as 'Number of films'
from actor a
left outer join film_actor fc
on a.actor_id = fc.actor_id
group by a.first_name
having count(fc.film_id) >=90)
select t.*
from t
order by t.[Number of films] asc