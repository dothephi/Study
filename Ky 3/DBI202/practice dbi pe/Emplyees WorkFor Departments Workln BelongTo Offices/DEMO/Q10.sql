DELETE FROM dbo.Locations
WHERE Locations.LocationID  NOT IN (
SELECT Departments.LocationID
FROM dbo.Departments
)

