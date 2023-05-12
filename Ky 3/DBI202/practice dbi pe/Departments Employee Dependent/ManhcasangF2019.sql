--create table Departments
--(
--	DeptID varchar(20) primary key,
--	name nvarchar(200),
----	office nvarchar(100)
----)

----create table Employees 
----(
----	EmpCode varchar(20) primary key,
----	[Name] nvarchar(50),
----	BirthDate date,
----	DeptID varchar(20),
----	foreign key (DeptID) references Departments(DeptID)
----)

----create table Dependants
----(
----	Number int identity(1,1) primary key,
----	Name nvarchar(50),
----	BirthDate Date,
----	Rote nvarchar(30),
----	EmpCode varchar(20)
----	foreign key (EmpCode) references Employees(EmpCode)
----)



----Q2
--select * from ProductSubcategory
--where Category = 'Accessories'

----Q3

--select ProductID, LocationID, Quantity from ProductInventory
--where (LocationID = 7) and (Quantity  > 250)
--order by Quantity desc


----Q4

--select p.ProductID, p.Name as ProductName, p.Price, pm.Name as ModelName, 
--ps.Name SubCategoryName, ps.Category from Product p 
--full join ProductModel pm on (pm.ModelID = p.ModelID) or (p.ModelID = null)
--full join ProductSubcategory ps on ps.SubcategoryID = p.SubcategoryID
--where p.Price < 100 and p.Color = 'Black'

----Q5
--select ps.SubcategoryID, ps.name as SubCategoryName, ps.Category, count(p.ProductID) as NumberOfProducts from ProductSubcategory ps
--join Product p on p.SubcategoryID = ps.SubcategoryID
--group by ps.SubcategoryID, ps.name, ps.Category
--order by ps.Category asc, NumberOfProducts desc, SubCategoryName asc



--Q8
--create proc proc_product_model
--@modelID int,
--@numberOfProducts int output 
--as 
--begin
--	set @numberOfProducts = (select count(ProductID) from Product where ModelID = @modelID)
--end

--declare @x int 
--exec proc_product_model 9, @x output
--select @x as NumberOfProducts


--Q9
--drop trigger tr_insert_Product_Subcategory
--create trigger tr_insert_Product_Subcategory
--on Product
--after insert
--as
--begin
--	select * from inserted  
--	--select i.ProductID, i.Name as ProductName, i.SubcategoryID, ps.Name as SubcategoryName, ps.Category from inserted i
--	--join ProductSubcategory ps on i.SubcategoryID = ps.SubcategoryID
--end

--insert into Product(ProductID, Name, Cost, Price, SubcategoryID, SellStartDate)
--values(1005,'Product Test', 12,15,1,'2021-10-25')

--Q10
delete from ProductInventory
where ProductID in (
select pi.ProductID from ProductInventory pi
join Product p on p.ProductID = pi.ProductID 
where p.ModelID = 33)
