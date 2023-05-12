INSERT INTO dbo.Class
(
    classCode,
    className
)
VALUES
(   'PC2016', -- classCode - varchar(10)
    'SE2016'  -- className - varchar(150)
    )
INSERT INTO dbo.Student
(
    studentID,
    studentFName,
    studentLName,
    studentGender,
    studentDOB,
    studentAddress
)
VALUES
(   'SE05740',        -- studentID - varchar(10)
    'Hoa',        -- studentFName - varchar(150)
    'Pham Ngoc',        -- studentLName - varchar(150)
    1,      -- studentGender - bit
    '3/20/1998',-- studentDOB - date
    'Ninh binh'         -- studentAddress - varchar(150)
    )
INSERT INTO dbo.Student
(
    studentID,
    studentFName,
    studentLName,
    studentGender,
    studentDOB,
    studentAddress
)
VALUES
(   'SE05574',        -- studentID - varchar(10)
    'A',        -- studentFName - varchar(150)
    'Pham Van',        -- studentLName - varchar(150)
    0,      -- studentGender - bit
    '2/22/1998', -- studentDOB - date
    'Ha Noi'         -- studentAddress - varchar(150)
    );


INSERT INTO dbo.Hobbies_Students
(
    hs_ho_id,
    hs_st_id
)
VALUES
(   '1', -- hs_ho_id - int
    'SE05740' -- hs_st_id - varchar(10)
    )
INSERT INTO dbo.Hobbies_Students
(
    hs_ho_id,
    hs_st_id
)
VALUES
(   '2', -- hs_ho_id - int
    'SE05741' -- hs_st_id - varchar(10)
    )
INSERT INTO dbo.Hobbies_Students
(
    hs_ho_id,
    hs_st_id
)
VALUES
(   '3', -- hs_ho_id - int
    'SB05741' -- hs_st_id - varchar(10)
    )
INSERT INTO dbo.Hobbies_Students
(
    hs_ho_id,
    hs_st_id
)
VALUES
(   '4', -- hs_ho_id - int
    'SE02412' -- hs_st_id - varchar(10)
    );

