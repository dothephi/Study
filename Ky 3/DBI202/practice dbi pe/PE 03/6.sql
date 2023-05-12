SELECT s.studentFName, c.className
FROM dbo.Student s, dbo.Class c, dbo.Student_Class sc
WHERE s.studentID = sc.studentID AND sc.classCode =c.classCode