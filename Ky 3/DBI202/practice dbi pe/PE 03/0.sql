CREATE TABLE NewCity(
	CityID SMALLINT IDENTITY(1,1),
	City VARCHAR(50) NOT NULL,
	CountryID SMALLINT FOREIGN KEY REFERENCES dbo.country(country_id),
	LasUpdated SMALLDATETIME NOT NULL CHECK(LasUpdated <= GETDATE()),
	CityCode VARCHAR(7) NOT NULL PRIMARY KEY CHECK(CityCode LIKE '%VN[0-9][0-9][0-9]')
)

INSERT INTO dbo.NewCity
(
    City,
    CountryID,
    LasUpdated,
    CityCode
)
VALUES
(   'HaNoi',                    -- City - varchar(50)
    105,                     -- CountryID - smallint
    GETDATE()-5, -- LasUpdated - smalldatetime
    'VN024'                     -- CityCode - varchar(7)
	)