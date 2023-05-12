--Q1
create database Q1_F2019
create table  Students
(
	StudentID int identity(1,1) primary key,
	Name nvarchar(50),
	Address nvarchar(200),
	Gender char(1)
)

create table Teachers
(
	TeacherID int identity(1,1) primary key,
	Name nvarchar(50),
	Address nvarchar(200),
	Gender char(1)
)

create table Classes
(
	ClassID int identity(1,1) primary key,
	GroupID char(6),
	courseID char(6),
	NoCredits int,
	Semester char(10),
	year int,
	TeacherID int
	foreign key (TeacherID) references Teachers(TeacherID)
)

create table Attend
(
	Date date,
	Slot int,
	Attend bit,
	StudentID int,
	ClassID int,
	primary key (Date,Slot,StudentID, ClassID),
	foreign key (StudentID) references Students(StudentID),
	foreign key (ClassID) references Classes(ClassID)

)


----Q2
--select * from Customer 
--where Segment = 'Consumer' and City = 'Arlington'

----Q3
--select c.ID, c.CustomerName, c.City, c.State from Customer c
--join Orders o on o.CustomerID = c.ID
--where o.OrderDate between '2017/12/05' and '2017/12/10' and o.ShipDate - o.OrderDate < 3
--order by State, city desc

----Q4
--select od.OrderID, o.OrderDate, sum(od.Quantity*od.SalePrice*(1-od.Discount)) as TotalAmount from OrderDetails od 
--join Orders o on od.OrderID = o.ID
--group by od.OrderID, o.OrderDate
--having sum(od.Quantity*od.SalePrice*(1-od.Discount)) > 8000
--order by TotalAmount desc

----Q5
--select o.id, max(o.OrderDate), o.ShipDate, o.ShipMode, o.CustomerID from Orders o
--where o.OrderDate < o.ShipDate and o.OrderDate >= (select max(o1.OrderDate) from Orders o1)
--group by o.id, o.OrderDate, o.ShipDate, o.ShipMode, o.CustomerID

----Q6
--select o.CustomerID, c.CustomerName, count(o.ID) as NumberOfOrders from Orders o
--join Customer c on c.ID = o.CustomerID 
--group by o.CustomerID, c.CustomerName
--having count(o.ID) = (
--select max(counts.NumberOfOrders) from
--(
--select o.CustomerID, c.CustomerName, count(o.ID) as NumberOfOrders from Orders o
--join Customer c on c.ID = o.CustomerID 
--group by o.CustomerID, c.CustomerName) as counts)

--Q7
select p.id, p.ProductName, p.UnitPrice , p.SubCategoryID  from Product p
where p.UnitPrice >=(select min(MAX.UnitPrice) from (select top 5  p.UnitPrice from Product p order by p.UnitPrice desc) as max)
union all
select p.id, p.ProductName, p.UnitPrice , p.SubCategoryID  from Product p
where p.UnitPrice <=(select max(min.UnitPrice) from (select top 5  p.UnitPrice from Product p order by p.UnitPrice asc) as min)
order by UnitPrice desc

---- Q8
--create proc TotalAmount 
--@OrderID nvarchar(255),
--@TotalAmount float output
--as
--begin
--	set @TotalAmount =( select sum(od.Quantity*od.SalePrice*(1-od.Discount))  from Orders o
--	join OrderDetails od on od.OrderID = o.ID 
--	where o.ID = @OrderID
--	group by od.OrderID)
--end

--declare @t float 
--exec TotalAmount'CA-2014-100006', @t output
--print @t


--Q9
--create trigger InsertSubCategory
--on SubCategory
--after insert
--as
--begin
--	select SubCategoryName, c.CategoryName from inserted i, Category c
--	where i.CategoryID = c.ID
--end

--Q10
insert into Category(CategoryName)
values('Sport')
insert into SubCategory(CategoryID,SubCategoryName)
values((select c.ID from Category c where c.CategoryName = 'Sport'),'Tennis')
,((select c.ID from Category c where c.CategoryName = 'Sport'),'Football')
select * from Category
select * from SubCategory