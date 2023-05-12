create table Routes
(
	RouteNumber int primary key,
	StartTime Time,
	EndTime Time,
)

create table Buses
(
	BusNumber varchar(15) primary key,
	totalSeats int,
	Company nvarchar(100),
	RouteNumber int 
	foreign key (RouteNumber) references Routes(RouteNumber),
)

create table Stations
(
	StationName nvarchar(50) primary key,
	[Address] nvarchar(100)
)

create table Has
(
	StationNumber int,
	StationName nvarchar(50),
	RouteNumber int,
	primary key (StationNumber, StationName, RouteNumber),
	foreign key (StationName) references Stations(StationName),
	foreign key (RouteNumber) references Routes(RouteNumber)
)
