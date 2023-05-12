
-- 2
SELECT *
FROM dbo.customers
WHERE city LIKE 'Victoria'
--3
SELECT *
FROM dbo.orders
WHERE YEAR(order_date) = 2018 AND MONTH(order_date) = 3 AND shipped_date > required_date
ORDER BY store_id 
--4
SELECT * FROM dbo.products

