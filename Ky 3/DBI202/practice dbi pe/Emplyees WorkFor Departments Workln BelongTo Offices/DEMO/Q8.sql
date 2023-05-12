CREATE PROCEDURE proc2
(
	@fromDate DATE,
	@toDate DATE,
	@numberOfEmployees INT  OUTPUT
)
AS 
BEGIN
	SELECT @numberOfEmployees = COUNT(Employees.EmployeeID)
	FROM dbo.Employees
	WHERE Employees.HireDate BETWEEN @fromDate AND @toDate
END 
