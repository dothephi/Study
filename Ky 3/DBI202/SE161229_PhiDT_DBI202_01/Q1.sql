--Q1
create table Customers
(
	CustID int primary key,
	City varchar(100),
	Cname varchar(100)
)

create table Orders
(
	OrderID int identity(1,1) primary key,
	Odate date,
	CustID int,
	foreign key (CustID) references Customers(CustID)
)

create table Items
(
	ItemID int identity(1,1) primary key,
	Unit_Price decimal(10),
)

create table Order_Item
(
	Qty int,
	ItemID int,
	Odate date,
	primary key (ItemID, OrderID),
	foreign key (Odate) references Oders(Odate),
	foreign key (Unit_Price) references Items(Unit_Price)
)