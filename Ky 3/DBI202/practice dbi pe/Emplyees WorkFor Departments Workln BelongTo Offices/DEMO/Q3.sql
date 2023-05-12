SELECT 
	Employees.EmployeeID,
	Employees.FirstName,
	Employees.LastName,
	Employees.Salary,
	Employees.Commission_pct,
	Employees.HireDate
FROM dbo.Employees
WHERE (Employees.Salary BETWEEN 4000 AND 10000)
AND Employees.Commission_pct > 0
AND (Employees.FirstName LIKE '%E%'
OR Employees.FirstName LIKE '%e%')
ORDER BY Employees.HireDate DESC
