SELECT   
Countries.CountryID ,
        Countries.CountryName ,
        Countries.RegionID
FROM    dbo.Countries
        FULL OUTER   JOIN dbo.Locations ON Locations.CountryID = Countries.CountryID
WHERE   Locations.LocationID NOT IN ( SELECT    Departments.LocationID
                                      FROM      dbo.Departments )
		OR  Countries.RegionID =4


