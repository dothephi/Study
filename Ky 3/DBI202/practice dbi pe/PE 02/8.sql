CREATE TRIGGER check_duplicated
ON dbo.film
AFTER INSERT 
AS
BEGIN
    DECLARE @namefilm VARCHAR(255)
	SELECT @namefilm = (SELECT Inserted.title FROM Inserted)
	IF (SELECT COUNT(f.title) FROM dbo.film f WHERE f.title = @namefilm) > 1
	BEGIN
		PRINT 'delete'
	    DELETE FROM dbo.film WHERE film_id = (SELECT Inserted.film_id FROM Inserted)
	END
END
