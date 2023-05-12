SELECT *
FROM dbo.Student s
WHERE s.studentGender = 1 AND YEAR(GETDATE())-YEAR(s.studentDOB) >20