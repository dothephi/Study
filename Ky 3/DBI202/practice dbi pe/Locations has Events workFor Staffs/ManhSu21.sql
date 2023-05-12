----Q1

create database Q111

create table Locations
(
	locationID varchar(20) primary key,
	Name nvarchar(100),
	Address nvarchar(255)
)

create table Events
(
	eventID int identity(1,1) primary key,
	name nvarchar(255),
	EndTime DateTime,
	StartTime DateTime,
	locationID varchar(20),
	foreign key (locationID) references Locations(locationID)
)

create table Staffs
(
	staffID int identity(1,1) primary key,
	name nvarchar(255),
	Phone varchar(15)
)

create table workFor
(
	role nvarchar(30) ,
	staffID int,
	eventID int,
	primary key (staffID, eventID, role),
	foreign key (staffID) references Staffs(staffID),
	foreign key (eventID) references Events(eventID)
)

----Q2
--select * from customers
--where city = 'Victoria'

----Q3
--select order_id, order_date, required_date, shipped_date, store_id from orders
--where year(order_date) = 2018 and month(order_date) = 3 and required_date < shipped_date
--order by store_id asc

----Q4
--select p.product_id, p.product_name, p.model_year, p.brand_name, se.store_name, sk.quantity from products p
--join stocks sk on sk.product_id = p.product_id
--join stores se on se.store_id = sk.store_id
--where se.store_name = 'Baldwin Bikes' and p.brand_name = 'Surly'

--select * from products
--select * from stocks

----Q5
select * from stores
--select s.store_id, s.store_name ,count(o.store_id) as NumberOfOrdersIn2018 from orders o
--join stores s on s.store_id = o.store_id
--where YEAR(order_date) = 2018
--group by s.store_id, s.store_name
--order by NumberOfOrdersIn2018 desc

----Q6
--select c.customer_id, c.first_name, c.last_name, count(o.order_id) as NumberOfOrders from customers c
--join orders o on c.customer_id = o.customer_id
--group by c.customer_id, c.first_name, c.last_name
--having count(o.order_id) = 
--(
--select max(NumberOfOrders) from 
--(select c.customer_id, c.first_name, c.last_name, count(o.order_id) as NumberOfOrders from customers c
--join orders o on c.customer_id = o.customer_id
--group by c.customer_id, c.first_name, c.last_name) as counts
--)






----Q7
--select count(o.store_id) from orders o
--group by o.store_id



----Q8
--drop proc pr1
--create proc pr1 
--@store_id int,
--@numberOfStaffs int output
--as 
--begin
--	set @numberOfStaffs = ( select count(sf.staff_id) from staffs sf, stores se  
--	where se.store_id = sf.store_id and se.store_id = @store_id)
--end
--declare @x int 
--exec pr1 3,@x output
--select @x as NumberOfStaffs



--Q9

create trigger Tr2
on stocks  
for delete
as
begin
	 
	select d.product_id, p.product_name, d.store_id, s.store_name, d.quantity 
	from deleted d, products p, stores s
	where p.product_id = d.product_id and s.store_id = d.store_id
end

select * from stocks
delete from stocks
where store_id = 1 and product_id  in (10,11,12)

--Q10
update stocks 
set quantity = 30
where store_id = 1 and product_id in (select p.product_id from products p
where p.category_name = 'Cruisers Bicycles')








