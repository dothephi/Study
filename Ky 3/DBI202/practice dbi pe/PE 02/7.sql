create proc NumberOfFilm 
@catName varchar(25), @count int output
as
begin
	select @count = COUNT(fc.category_id)
	from category c, film_category fc
	where c.category_id = fc.category_id and @catName = c.name
end
