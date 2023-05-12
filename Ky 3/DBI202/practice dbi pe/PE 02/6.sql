select f.film_id, f.title, f.rating, f.length
from film f
where f.length >= (select f1.length from film f1 where f1.title = 'THEORY MERMAID') 
and f.rating = (select f2.rating from film f2 where f2.title= 'THEORY MERMAID')