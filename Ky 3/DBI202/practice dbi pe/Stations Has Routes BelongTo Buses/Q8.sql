--Q8
create proc Proc1
@customerNumber int,
@numberOfOrders int output
as
begin
	set @numberOfOrders = 
	(
		select count(orderNumber) from orders where customerNumber=@customerNumber
	)
end


