
CREATE TABLE Departments
(
	DeptID VARCHAR(15) PRIMARY KEY,
	Name NVARCHAR(60)
)
GO 

CREATE TABLE Offices
(
	OfficeNumber INT PRIMARY KEY,
	Address NVARCHAR(30),
	Phone VARCHAR(15),
	DeptID VARCHAR(15) FOREIGN KEY REFERENCES dbo.Departments(DeptID)
)
GO 


CREATE TABLE Employees
(
	EmployeeID INT PRIMARY KEY,
	FullName NVARCHAR(50),
	OfficeNumber INT FOREIGN KEY REFERENCES dbo.Offices(OfficeNumber)
)
GO 

CREATE TABLE WorkFor
(
	"From" DATE,
	EmployeeID INT FOREIGN KEY REFERENCES dbo.Employees(EmployeeID),
	DeptID VARCHAR(15) FOREIGN KEY REFERENCES dbo.Departments(DeptID),
	Salary FLOAT,
	"To" DATE,
	PRIMARY KEY("From", EmployeeID,DeptID)
)
GO 
