--Q5
select c.customerNumber, c.customerName, c.city, c.[state], c.country, count(distinct o.orderNumber) as NumberOfOrders, sum(p.amount) as TotalPaymentAmount from customers c 
join orders o on o.customerNumber = c.customerNumber
join payments p on p.customerNumber = c.customerNumber
where (c.state = 'CA' or c.state = 'NY') and (c.country = 'USA')
group by c.customerNumber, c.customerName, c.city, c.[state], c.country
order by c.state asc, c.customerName asc


