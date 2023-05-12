WITH t AS(
SELECT s.studentID, s.studentFName, s.studentLName, sc.schoGranted
FROM dbo.Student s, dbo.Student_Scholarship ss, dbo.Scholarship sc
WHERE s.studentID = ss.StudentID AND ss.schoName = sc.schoName)
SELECT t.*
FROM t
WHERE t.schoGranted = (SELECT MAX(t.schoGranted) FROM t)
