create trigger Tr1
on orderdetails
for delete
as
begin
	select p.productCode, p.productName, d.orderNumber, o.orderDate, d.quantityOrdered, d.priceEach from deleted d 
	join orders o on o.orderNumber = d.orderNumber
	join products p on p.productCode = d.productCode
end

