----Q1
create database Q1___F2019
create table Departments
(
	DeptID varchar(15) primary key,
	Name nvarchar(60),	
)

create table Offices
(
	OfficeNumber int identity(1,1) primary key,
	Address nvarchar(30),
	Phone varchar(15),
	DeptID varchar(15),
	foreign key (DeptID) references Departments(DeptID)
)

create table Employees
(
	EmployeeID int identity(1,1) primary key,
	FullName nvarchar(50),
	OfficeNumber int
	foreign key (OfficeNumber) references Offices(OfficeNumber)
)


create table WorkFor
(
	[From] Date ,
	Salary float,
	[To] Date,
	EmployeeID int,
	DeptID varchar(15),
	primary key([From],EmployeeID, DeptID)
	foreign key (EmployeeID) references Employees(EmployeeID),
	foreign key (DeptID) references Departments(DeptID)
)

----Q2
--select * from Locations
--where CountryID = 'US' or CountryID = 'CA'

----Q3
--select e.EmployeeID, e.FirstName, e.LastName, e.Salary, e.Commission_pct, e.HireDate from Employees e
--where (e.Salary between 4000 and 10000) and e.Commission_pct > 0 
--and (e.FirstName like '%E%' or e.FirstName like '%e%' )
--order by e.HireDate desc

----Q4
--select e.EmployeeID, e.FirstName, e.LastName, e.HireDate, e.JobID, j.JobTitle, e.DepartmentID, d.DepartmentName from Employees e
--join Jobs j on j.JobID = e.JobID
--join Departments d on d.DepartmentID = e.DepartmentID
--where year(e.HireDate) = 2005 and j.JobTitle = 'Stock Clerk'


----Q5
--select e.JobID, j.JobTitle, count(e.EmployeeID) as NumberOfEmployees from Employees e
--join Jobs j on j.JobID = e.JobID
--group by e.JobID, j.JobTitle
--order by NumberOfEmployees desc


--Q6
Select * from Countries
where CountryID not in 
(Select distinct l.CountryID from Locations l, Departments d 
where l.LocationID = d.LocationID)
--Q7
select * from Employees
select * from Departments


select count(EmployeeID) from Employees
group by ManagerID
union
select count(e.EmployeeID) from Departments d
join Employees e on e.DepartmentID = d.DepartmentID
where d.DepartmentName = 'IT'
group by e.ManagerID
having count(e.EmployeeID) = 0 
--Q8
create proc proc2
@fromDate Date,
@toDate Date,
@numberOfEmployees int output
as
begin
	set @numberOfEmployees = (select count(e.EmployeeID) from Employees e
	where e.HireDate between @fromDate and @toDate)
end

--declare @x int
--execute proc2 '2002-01-01' , '2002-12-31', @x output
--select @x as NumberOfEmployees


--Q9
--create trigger Tr2
--on Departments
--for Update
--as
--begin
--	select d.DepartmentID, d.DepartmentName, d.ManagerID as OldManagerID,
--	i.ManagerID as NewManagerID from inserted i, deleted d
--	group by d.DepartmentID, d.DepartmentName, d.ManagerID, i.ManagerID
--	order by d.DepartmentID desc
--end

--update Departments
--set ManagerID = 100
--where DepartmentID in (110,80)


--Q10
delete from Locations
where LocationID in (select l.LocationID from Locations l 
where l.LocationID not in (select d.LocationID from Departments d))
select * from Locations








