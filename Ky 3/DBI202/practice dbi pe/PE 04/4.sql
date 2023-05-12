CREATE PROC get_student
@scholarGranted FLOAT
AS
BEGIN
	SELECT s.* FROM dbo.Student s, dbo.Student_Scholarship ss, dbo.Scholarship sc
	WHERE s.studentID = ss.StudentID AND ss.schoName = sc.schoName AND sc.schoGranted >@scholarGranted
END

