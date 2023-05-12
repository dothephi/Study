
CREATE TRIGGER Age_validation
ON  student
AFTER INSERT
AS 
BEGIN
	SET NOCOUNT ON;
	Delete from student where studentID in (select StudentID from inserted where year(GETDATE()) - year(studentDOB)<15);
END
GO
