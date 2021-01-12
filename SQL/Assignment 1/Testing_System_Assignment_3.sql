-- Quesion 2 --
-- SELECT * FROM testing_system_2.department;

-- Quesion 3 --
-- SELECT DepartmentID FROM testing_system_2.department WHERE DepartmentName LIKE '%sa%';

-- Quesion 4 --
-- SELECT * FROM `Account`
-- WHERE length(fullname)=(SELECT MAX(length(fullname)) From `Account`);

-- Question 5 --
-- SELECT Email,Username,FullName,length(fullname) 
-- FROM `account`
-- WHERE DepartmentID = 2 
-- AND length(fullname) = (SELECT MAX(length(fullname)) FROM `account` WHERE DepartmentID=4)

-- Question 6 --
-- SELECT GroupName, CreateDate FROM testing_system_2.`group` WHERE CreateDate < '2020-02-05';

-- Question 7-- 
-- SELECT QuestionID, COUNT(AnswerID) 
-- FROM Answer
-- GROUP BY QuestionID 
-- HAVING Count(AnswerID) >= 2;

-- QS 8 -- 
-- SELECT Code, CreateDate, Duration FROM Exam 
-- WHERE Duration >= 60 AND CreateDate < '2020-10-04';

-- Qs 9 --
-- SELECT * FROM `Group`
-- ORDER BY Createdate DESC 
-- LIMIT 5;

-- QS 10--
-- SELECT DepartmentName, count(DepartmentID) 
-- FROM department 
-- GROUP BY DepartmentID HAVING DepartmentID = 6;
 
-- QS 11 --
-- SELECT *
-- FROM testing_system_2.`account`
-- WHERE LEFT(FullName, 1) = 'n' AND RIGHT(FullName, 1) = 'd';

-- QS 12--
-- DELETE FROM examquestion
-- WHERE ExamID 
-- IN (SELECT ExamID FROM exam
-- 				  WHERE CreateDate < '2020-10-02');
-- DELETE FROM exam
-- WHERE CreateDate < '2020-10-02';

-- QS 13 --
-- DELETE FROM question
-- WHERE Content LIKE '%1%';

-- QS 14 --
-- UPDATE `account`
-- SET FullName = "Nguyễn Bá Lộc" , Email = "loc.nguyenba@vti.com.vn"
-- WHERE AcountID = 5;

-- Question 15 --
-- UPDATE Groupaccount
-- SET GroupID = 4
-- WHERE AcountID = 5;