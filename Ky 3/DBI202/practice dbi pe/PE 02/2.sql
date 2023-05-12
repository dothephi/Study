select f.film_id, f.title, f.length, f.rating
from film f, film_category fc, category c
where f.film_id = fc.film_id and fc.category_id = c.category_id and c.name = 'Documentary' and f.length >=170
order by f.film_id asc
