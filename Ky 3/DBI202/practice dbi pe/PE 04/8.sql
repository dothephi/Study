WITH t AS(
SELECT s.schoName, s.schoGranted, COUNT(sc.StudentID) AS 'Number'
FROM dbo.Scholarship s
LEFT OUTER JOIN dbo.Student_Scholarship sc
ON sc.schoName = s.schoName
GROUP BY s.schoName, s.schoGranted)
SELECT t.schoName, t.schoGranted, t.Number, t.schoGranted*t.Number AS 'Total'
FROM t
