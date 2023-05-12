SELECT 
	Jobs.JobID,
	Jobs.JobTitle,
	COUNT(Employees.EmployeeID) AS NumberOfEmployees
FROM dbo.Jobs
INNER JOIN dbo.Employees ON Employees.JobID = Jobs.JobID
GROUP BY Jobs.JobID,
	Jobs.JobTitle
ORDER BY NumberOfEmployees DESC