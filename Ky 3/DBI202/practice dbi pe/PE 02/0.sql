CREATE TABLE FilmActor(
	ActorID SMALLINT FOREIGN KEY REFERENCES dbo.actor(actor_id),
	FilmID SMALLINT FOREIGN KEY REFERENCES dbo.film(film_id),
	Active BIT NOT NULL ,
	LastUpdated SMALLDATETIME NOT NULL CHECK(LastUpdated <= GETDATE()),
	JoinedDate SMALLDATETIME NOT NULL CHECK(JoinedDate <= LastUpdated)
)
