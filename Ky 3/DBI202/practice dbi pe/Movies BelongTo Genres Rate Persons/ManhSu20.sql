--Q1
--create table Genres
--(
--	Genre varchar(50) primary key,
--	[Description] nvarchar(200)
--)

--create table Movies
--(
--	MovieNumber int identity(1,1) primary key,
--	Title nvarchar(200),
--	Year int,
--	Genre varchar(50)
--	foreign key (Genre) references Genres(Genre)
--)

--create table Persons 
--(
--	PersonID int identity(1,1) primary key,
--	FullName nvarchar(200),
--	Gender nvarchar(10)
--)

--create table Rate
--(
--	[Time] DateTime,
--	Comment text,
--	NumericRating float,
--	MovieNumber int,
--	PersonID int
--	primary key (MovieNumber,PersonID),
--	foreign key (MovieNumber) references Movies(MovieNumber),
--	foreign key (PersonID) references Persons(PersonID)
--)

----Q2
--select * from customers 
--where state = 'CA' and country = 'USA'

----Q3
--select orderNumber, productCode, quantityOrdered, priceEach from orderdetails
--where (productCode = 'S18_1749') and (quantityOrdered > 25)
--order by priceEach asc, quantityOrdered desc 

----Q4
--select o.orderNumber, o.orderDate, o.requiredDate, o.shippedDate, o.status, o.customerNumber, c.customerName, c.city, c.country from orders o 
--join customers c on c.customerNumber = o.customerNumber
--where (o.shippedDate) is null and c.country = 'USA'
--order by c.customerName asc

----Q5
--select c.customerNumber, c.customerName, c.city, c.country, 
--sum(p.amount) as totalAmountOfPayments from customers c
--left join payments p on p.customerNumber = c.customerNumber
--where c.country = 'Germany' 
--group by c.customerNumber, c.customerName, c.city, c.country
--order by totalAmountOfPayments asc

--Q6
--select * from employees
--where employeeNumber not in 
--(
--	select e.employeeNumber from employees e 
--	join customers c on c.salesRepEmployeeNumber = e.employeeNumber
--)



--Q8

--create proc proc_numberOfOrders
--@customerNumber int,
--@numberOfOrders int output
--as
--begin
--	set @numberOfOrders = (select count(orderNumber) from orders where customerNumber = @customerNumber)
--end


--Q9

create trigger tr_insertPayment 
on payments
for insert
as
begin
	select i.customerNumber, c.customerName, i.checkNumber,
	i.paymentDate, i.amount from inserted i
	join customers c on i.customerNumber = c.customerNumber
end

--Q10
--delete from products
--where productCode not in (select productCode from orderdetails)
