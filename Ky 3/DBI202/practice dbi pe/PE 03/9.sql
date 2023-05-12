select * from Student where Student.studentID in (
SELECT Student.studentID, avg(Exam.examScore)
FROM     Exam INNER JOIN
                  Student ON Exam.studentID = Student.studentID group by student.studentID
having avg(Exam.examScore) =
(Select max(tmp.Avg_Score) from (
SELECT avg(Exam.examScore) as Avg_Score, Student.studentID
FROM     Exam INNER JOIN
                  Student ON Exam.studentID = Student.studentID group by Student.studentID ) tmp))

union

SELECT Student.*
FROM     Scholarship INNER JOIN
                  Student_Scholarship ON Scholarship.schoName = Student_Scholarship.schoName INNER JOIN
                  Student ON Student_Scholarship.StudentID = Student.studentID
				  				  where Scholarship.schoGranted = (

SELECT max(Scholarship.schoGranted)
FROM     Scholarship INNER JOIN
                  Student_Scholarship ON Scholarship.schoName = Student_Scholarship.schoName INNER JOIN
                  Student ON Student_Scholarship.StudentID = Student.studentID);