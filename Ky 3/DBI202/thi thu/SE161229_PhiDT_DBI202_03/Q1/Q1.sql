CREATE TABLE [ProductModel](
	[ModelID] [int] NOT NULL primary key,
	[Name] nvarchar(100) NOT NULL
)
CREATE TABLE [ProductSubcategory](
	[SubcategoryID] [int] NOT NULL primary key,
	[Category] nvarchar(100),
	[Name] nvarchar(100) NOT NULL
	)
CREATE TABLE [Product](
	[ProductID] [int] NOT NULL primary key,
	[Name] nvarchar(200) NOT NULL,
	[Color] nvarchar(15) NULL,
	[Cost] [money] NOT NULL,
	[Price] [money] NOT NULL,
	[SubcategoryID] [int] NULL references ProductSubcategory(SubcategoryID),
	[ModelID] [int] NULL references ProductModel(ModelID),
	[SellStartDate] [datetime] NOT NULL,
	[SellEndDate] [datetime] NULL
)
CREATE TABLE [Location](
	[LocationID] [smallint] NOT NULL primary key,
	[Name] nvarchar(200) NOT NULL,
	[CostRate] [smallmoney] NOT NULL,
	[Availability] [decimal](8, 2) NOT NULL
)
CREATE TABLE [ProductInventory](
	[ProductID] [int] references Product(ProductID),
	[LocationID] [smallint] references Location(LocationID),
	[Shelf] [nvarchar](10) NOT NULL,
	[Bin] [tinyint] NOT NULL,
	[Quantity] [smallint] NOT NULL,
	primary key (ProductID, LocationID)
)
CREATE TABLE [ProductCostHistory](
	[ProductID] [int] NOT NULL references Product(ProductID),
	[StartDate] [datetime] NOT NULL,
	[EndDate] [datetime] NULL,
	[Cost] [money] NOT NULL,
	primary key (ProductID, StartDate)
)
CREATE TABLE [ProductPriceHistory](
	[ProductID] [int] NOT NULL references Product(ProductID),
	[StartDate] [datetime] NOT NULL,
	[EndDate] [datetime] NULL,
	[Price] [money] NOT NULL,
	primary key ([ProductID], StartDate)
)
