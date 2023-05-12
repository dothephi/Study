--Q3
SELECT ProductID, LocationID, Quantity
FROM ProductInventory
WHERE LocationID = 7 and Quantity > 250
ORDER BY Quantity desc;