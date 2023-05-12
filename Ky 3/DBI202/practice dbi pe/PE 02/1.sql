select s.staff_id, s.first_name, s.last_name
from staff s
where s.active = 1
order by s.staff_id asc