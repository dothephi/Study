SELECT 
	Employees.EmployeeID,
	Employees.FirstName,
	Employees.LastName,
	Employees.HireDate,
	Employees.JobID,
	Jobs.JobTitle,
	Employees.DepartmentID,
	Departments.DepartmentName
FROM dbo.Employees
INNER JOIN dbo.Jobs ON Jobs.JobID = Employees.JobID
INNER JOIN dbo.Departments ON Departments.DepartmentID = Employees.DepartmentID
WHERE YEAR(Employees.HireDate) = 2005
AND Jobs.JobTitle = 'Stock Clerk'