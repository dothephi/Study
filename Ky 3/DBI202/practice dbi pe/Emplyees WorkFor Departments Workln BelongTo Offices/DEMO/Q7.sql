SELECT  b.EmployeeID ,
        b.FirstName ,
        b.LastName ,
        b.DepartmentID ,
        c.DepartmentName ,
        COUNT(a.EmployeeID) AS NumberOfSubordinates
FROM    dbo.Employees AS a
        RIGHT JOIN dbo.Employees AS b ON b.EmployeeID = a.ManagerID
        INNER JOIN dbo.Departments AS c ON c.DepartmentID = b.DepartmentID
WHERE   b.EmployeeID IN (
        SELECT  b.EmployeeID
        FROM    dbo.Employees AS a
                RIGHT JOIN dbo.Employees AS b ON b.EmployeeID = a.ManagerID
                INNER JOIN dbo.Departments AS c ON c.DepartmentID = b.DepartmentID
        GROUP BY b.EmployeeID
        HAVING  COUNT(a.EmployeeID) > 0 )
        OR c.DepartmentName = 'IT'
GROUP BY b.EmployeeID ,
        b.FirstName ,
        b.LastName ,
        b.DepartmentID ,
        c.DepartmentName
ORDER BY NumberOfSubordinates DESC

