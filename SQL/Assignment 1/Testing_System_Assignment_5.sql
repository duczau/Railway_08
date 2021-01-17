-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale --
-- DROP VIEW IF EXISTS sale;
-- CREATE VIEW sale AS
-- SELECT a.FullName, d.DepartmentName as sales FROM account a
-- INNER JOIN department d
-- ON d.DepartmentID = a.DepartmentID 
-- WHERE d.DepartmentName LIKE 'SALE%';
-- SELECT * FROM sale;


-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất --
-- DROP VIEW IF EXISTS info_acc;
-- CREATE VIEW info_acc AS
-- SELECT a.*, g.GroupID, count(g.GroupID) as `soluong group` FROM account a
-- INNER JOIN groupaccount g
-- ON g.AcountID = a.AcountID
-- GROUP BY g.AcountID
-- HAVING count(g.GroupID) = (SELECT max(number_group) FROM 
-- 							(SELECT g.AcountID, count(g.GroupID) number_group FROM account a
-- 							INNER JOIN groupaccount g
-- 							ON g.AcountID = a.AcountID
-- 							GROUP BY g.AcountID
--                             ORDER BY g.AcountID) as ac);
-- SELECT * FROM info_acc


-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi --
DROP VIEW IF EXISTS cauhoi;
CREATE VIEW cauhoi AS
SELECT q.QuestionID, q.Content, ((length(q.Content) - length(replace(q.content, ' ', ''))) + 1) AS number_of_words  FROM question q
WHERE (length(q.Content) - length(replace(q.content, ' ', ''))) > 1;

SELECT * FROM cauhoi; 

DELETE FROM question
WHERE question.QuestionID IN (SELECT cauhoi.QuestionID
							  FROM cauhoi);


-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất --
-- DROP VIEW IF EXISTS phongban;
-- CREATE VIEW phongban AS
-- SELECT d.DepartmentID, d.DepartmentName, count(a.DepartmentID) as 'so luong' FROM account a
-- INNER JOIN department d
-- ON d.DepartmentID = a.DepartmentID
-- GROUP BY d.DepartmentID
-- HAVING count(a.DepartmentID) = (SELECT max(gr) FROM 
-- 							(SELECT d.DepartmentID, count(a.DepartmentID) gr FROM account a
-- 							INNER JOIN department d
-- 							ON d.DepartmentID = a.DepartmentID
-- 							GROUP BY d.DepartmentID
--                          ORDER BY d.DepartmentID) as ac);
-- SELECT * FROM phongban


-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo --
-- SELECT a.FullName, q.Content FROM question q
-- INNER JOIN account a
-- ON a.AcountID = q.CreatorID
-- WHERE a.FullName LIKE 'f%'
