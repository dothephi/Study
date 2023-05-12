
SELECT *
FROM dbo.Locations
WHERE CountryID LIKE 'US' OR CountryID LIKE 'CA'
--3
SELECT EmployeeID, FirstName,LastName,Salary,Commission_pct,HireDate
FROM dbo.Employees
WHERE Salary BETWEEN 4000 AND 10000 AND Commission_pct > 0 AND FirstName LIKE '%e%'
ORDER BY HireDate DESC
--4 
SELECT e.EmployeeID, e.FirstName,e.LastName,e.HireDate, e.JobID, j.JobTitle, e.DepartmentID, d.DepartmentName
FROM dbo.Employees AS e 
JOIN dbo.Jobs AS j ON j.JobID = e.JobID
JOIN dbo.Departments AS d ON d.DepartmentID = e.DepartmentID
WHERE YEAR(e.HireDate) = 2005 AND e.JobID LIKE 'ST_CLERK'
--5
SELECT j.JobID, j.JobTitle, COUNT(e.EmployeeID) AS NumberOfEmployees
FROM dbo.Jobs AS j JOIN dbo.Employees AS e
ON e.JobID = j.JobID
GROUP BY j.JobID, j.JobTitle
ORDER BY NumberOfEmployees DESC
--6

WITH r as(-- bang location co part
	SELECT l.CountryID,l.LocationID, d.DepartmentID--, COUNT(d.DepartmentID) AS Num
	FROM dbo.Departments AS d JOIN dbo.Locations AS l
	ON l.LocationID = d.LocationID 
	GROUP BY l.CountryID,l.LocationID, d.DepartmentID
)
SELECT *
FROM dbo.Countries AS c LEFT JOIN r
ON r.CountryID = c.CountryID
WHERE r.CountryID IS NULL
--c2
SELECT c.CountryID, c.CountryName
FROM dbo.Countries AS c 
LEFT JOIN dbo.Locations AS l ON l.CountryID = c.CountryID
LEFT JOIN dbo.Departments AS d ON d.LocationID = l.LocationID
GROUP BY c.CountryID, c.CountryName
HAVING COUNT(d.DepartmentID) = 0

--7 

WITH t AS (SELECT e2.EmployeeID, e2.FirstName, e2.LastName, e2.Salary, e2.DepartmentID, d.DepartmentName, 
COUNT(e1.EmployeeID) AS NumberOfSubordinates FROM dbo.Employees AS e1 
RIGHT JOIN dbo.Employees AS e2 ON e2.EmployeeID = e1.ManagerID
JOIN dbo.Departments AS d ON d.DepartmentID = e2.DepartmentID
GROUP BY   e2.EmployeeID, e2.FirstName, e2.LastName, e2.Salary, e2.DepartmentID, d.DepartmentName
)
SELECT * FROM t
WHERE t.DepartmentName LIKE  'IT' OR t.NumberOfSubordinates >= 1
ORDER BY t.NumberOfSubordinates DESC, t.LastName ASC

--8

--10
DELETE FROM dbo.Locations 
WHERE LocationID IN 
 (SELECT l.LocationID FROM dbo.Locations AS l
LEFT JOIN dbo.Departments AS d ON d.LocationID = l.LocationID
GROUP BY l.LocationID
HAVING COUNT(d.DepartmentID)= 0 )
SELECT * FROM dbo.Locations
