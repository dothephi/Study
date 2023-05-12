----Q1
create table Customers
(
	SSN varchar(20) primary key,
	[Name] nvarchar(50),
	[Address] nvarchar(255)
)

create table Loans
(
	LoanNumber varchar(20) primary key,
	Amount float, 
	[Date] Date,
	Branch nvarchar(100),
	SSN varchar(20),
	foreign key (SSN) references Customers(SSN)
)

create table Payments
(
	PaymentNo varchar(30) primary key,
	Amount float,
	[Date] Date,
	LoanNumber varchar(20),
	foreign key (LoanNumber) references Loans(LoanNumber)
)


----Q2
--select * from stores

----Q3 cos le database bi thua
--select customer_id, first_name, last_name, city, state from customers
--where (city = 'Bellmore' or city = 'New York') and state = 'NY'
--order by city 

----Q4
--select p.product_id, p.product_name, p.list_price, p.brand_name, p.category_name, s.store_id, s.quantity from products p
--join stocks s on s.product_id = p.product_id
--where s.store_id = 1 and s.quantity > 25
--order by p.category_name, p.list_price desc

----Q5
select distinct s.staff_id, s.first_name, s.last_name, count(o.order_id) as NumberOfOrders from staffs s 
join orders o on o.store_id = s.store_id
where year(o.order_date) = 2016
group by s.staff_id, s.first_name, s.last_name
order by NumberOfOrders

select * from staffs
select * from orders
----Q6
select p.product_id, p.product_name, p.model_year, s.store_id, s.quantity from stocks s 
join products p on s.product_id = p.product_id
group by p.product_id, p.product_name, p.model_year, s.store_id, s.quantity
having s.quantity = 
(
select min(quan1.quantity) from
(select p.product_id, p.product_name, p.model_year, s.store_id, s.quantity from stocks s 
join products p on s.product_id = p.product_id) as quan1
)
----Q8
create proc proc2
@store_name varchar(255),
@numberOfOrders int output
as
begin
	set @numberOfOrders = (select o.store_id ,count(o.order_id) from orders o
	join stores s on s.store_id = o.store_id where s.store_name = 'Baldwin Bikes'
	group by o.store_id)
end


----Q9
create trigger trigger_update_orderItems
on order_items
for update
as
begin
	select d.order_id, d.item_id, d.product_id, d.list_price*d.quantity*(1-d.discount) as OldAmount, 
	i.list_price*i.quantity*(1- i.discount) as NewAmount from inserted i, deleted d
	where i.order_id = d.order_id
end


----Q10
insert into staffs(staff_id, first_name, last_name, email, active, store_id, manager_id)
values(19,'White', 'Mary', 'qweqwe', 1, 3, 7)
select * from staffs