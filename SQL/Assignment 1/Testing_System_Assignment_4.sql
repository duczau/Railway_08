-- QS 1 Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ--
-- SELECT a.FullName, d.DepartmentName
-- FROM `Account` a
-- INNER JOIN Department d
-- ON `Account`.DepartmentID = Department.DepartmentID;


-- QS 2 Viết lệnh để lấy ra thông tin các account được tạo sau ngày 04/01/2010 --
-- SELECT a.FullName, a.Username, a.CreateDate, d.DepartmentName, p.PositionName FROM `account` a
-- INNER JOIN Department d
-- ON a.DepartmentID = d.DepartmentID
-- INNER JOIN Position p
-- ON a.PositionID = p.PositionID
-- WHERE a.CreateDate > '2020-01-04';


-- QS 3 Viết lệnh để lấy ra tất cả các developer --
-- SELECT a.FullName, a.Email, p.PositionName FROM account AS a
-- INNER JOIN Position p
-- ON p.PositionID = a.PositionID
-- WHERE p.PositionName = 'DEV'


-- QS 4 Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên --
-- SELECT d.DepartmentName, count(a.DepartmentID) soluong FROM Department d
-- INNER JOIN Account a
-- ON a.DepartmentID = d.DepartmentID
-- GROUP BY a.DepartmentID 
-- HAVING count(a.DepartmentID) >= 2;


-- QS 5 Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất--
-- SELECT q.Content, count(q.QuestionID) FROM question q
-- INNER JOIN examquestion eq
-- ON eq.QuestionID = q.QuestionID
-- GROUP BY q.Content
-- HAVING count(q.QuestionID) = ( SELECT MAX(QuestionID)
-- 								FROM
-- 								(SELECT COUNT(q.QuestionID) as QuestionID	FROM ExamQuestion eq 
-- 								INNER JOIN 	Question q ON eq.QuestionID = q.QuestionID
-- 								GROUP BY q.QuestionID) eqs)


-- QS 6  Thông kê mỗi category Question được sử dụng trong bao nhiêu Question--
-- SELECT q.content, q.QuestionID, count(q.QuestionID) FROM question q
-- INNER JOIN categoryquestion cq
-- ON q.CategoryID = cq.CategoryID
-- GROUP BY cq.CategoryID


-- QS 7 Thông kê mỗi Question được sử dụng trong bao nhiêu Exam --
-- SELECT q.Content, count(e.ExamID) FROM question q
-- LEFT JOIN examquestion e
-- on e.QuestionID = q.QuestionID
-- GROUP BY e.QuestionID
-- ORDER BY count(e.ExamID) DESC


-- QS 8  Lấy ra Question có nhiều câu trả lời nhất--
-- SELECT QuestionID, Content, MAX(maxquestion) FROM (SELECT Q.QuestionID, Q.Content, COUNT(a.questionID) as maxquestion
-- FROM Question Q 
-- INNER JOIN 	Answer A ON	Q.QuestionID = A.QuestionID      
-- GROUP BY Q.QuestionID) a;


-- QS 9  Thống kê số lượng account trong mỗi group--
-- SELECT g.GroupName, count(a.AcountID) FROM `group` g
-- LEFT JOIN groupaccount a
-- ON a.GroupID = g.GroupID
-- GROUP BY g.GroupName
-- ORDER BY g.GroupID 


-- QS 10 Tìm chức vụ có ít người nhất--
SELECT * from account a
inner join position p
on p.PositionID = a.PositionID
group by a.AcountID


-- QS 11 Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM--


-- QS 12 Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … --


-- QS 13 Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm--


-- QS 14 Lấy ra group không có account nào--


-- QS 15 Lấy ra question không có answer nào--