SELECT 
	Locations.LocationID,
	Locations.StreetAddress,
	Locations.PostalCode,
	Locations.City,
	Locations.StateProvince,
	Locations.CountryID
FROM dbo.Locations
WHERE Locations.CountryID IN ('US', 'CA')