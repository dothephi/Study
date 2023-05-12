CREATE TABLE Hobbies(
	ho_id INT PRIMARY KEY,
	ho_nam VARCHAR(30)
);
CREATE TABLE Hobbies_Students(
	hs_ho_id INT,
	hs_st_id VARCHAR(10)
);
ALTER TABLE dbo.Student
ADD hometown VARCHAR(200);

ALTER TABLE dbo.Student
ALTER COLUMN studentAddress VARCHAR(200);

