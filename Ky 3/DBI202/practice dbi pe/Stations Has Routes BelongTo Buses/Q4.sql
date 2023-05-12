select distinct c.customerNumber, c.customerName, c.city, c.[state], c.country from customers c
join orders o on c.customerNumber = o.customerNumber
join orderdetails od on od.orderNumber = o.orderNumber
join products p on p.productCode = od.productCode
where (p.productLine = 'Classic Cars') 
and (o.orderDate between '2004-04-01' and '2004-05-31')
order by c.country asc, c.customerName asc