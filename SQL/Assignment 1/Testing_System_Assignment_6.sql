-- qs 1 Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó --
use testing_system_2;
DROP PROCEDURE IF EXISTS sp_accountOfDepartment;
DELIMITER $$
CREATE PROCEDURE sp_accountOfDepartment (IN in_department_name VARCHAR(50))
BEGIN

	SELECT 		A.Email, A.Username, A.CreateDate 
    FROM		Department D 
	INNER JOIN 	`Account` A ON D.DepartmentID = A.DepartmentID
    WHERE		DepartmentName like in_department_name;
	
END $$
DELIMITER ;

Call sp_accountOfDepartment('marketing');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
use testing_system_2;
DROP PROCEDURE IF EXISTS number_account;
DELIMITER $$
CREATE PROCEDURE number_account()
BEGIN

	SELECT g.GroupName, count(a.AcountID) soluongAccount FROM groupaccount a
    Right JOIN `Group` g
    ON g.GroupID = a.GroupID
    Group by g.GroupID;

END $$
DELIMITER ;
CALL number_account();


-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS num_ques;
DELIMITER $$
CREATE PROCEDURE num_ques()
BEGIN
SELECT q.TypeID,tq.TypeName, count(q.TypeID) as 'so luong cau hoi thang 12' FROM question q
INNER JOIN typequestion tq
ON q.TypeID = tq.TypeID
where month(q.CreatorDate) = month('2020-12-20')
GROUP BY tq.TypeID;
end$$
DELIMITER ;
call num_ques();


-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS id_max_ques;
DELIMITER $$
CREATE PROCEDURE id_max_ques()
BEGIN

	select TypeID, max(max) 'so cau hoi cua type question' from (select TypeID, count(TypeID) max from question
										group by TypeID) a;
                                        
end$$
DELIMITER ;
call id_max_ques();


-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS name_type_ques;
DELIMITER $$
CREATE PROCEDURE name_type_ques()
BEGIN

	select tq.TypeID,tq.TypeName, count(q.TypeID) 'so cau hoi cua type question' from question q
	INNER join typequestion tq on q.TypeID = tq.TypeID
    group by tq.TypeID
    having count(q.TypeID) = (select max(max) from (select q.TypeID,tq.TypeName, count(q.TypeID) max from question q
																	INNER join typequestion tq on q.TypeID = tq.TypeID
                                                                    group by tq.TypeID) b);                                   
end$$
DELIMITER ;
call name_type_ques();


-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào
--  hoặc trả về user có username chứa chuỗi của người dùng nhập vào
DROP PROCEDURE IF EXISTS input_name;
DELIMITER $$
CREATE PROCEDURE input_name(in string_input varchar(50))
BEGIN
   
    SELECT g.GroupName
    FROM `group` g
    WHERE g.GroupName LIKE CONCAT('%', string_input, '%')
    union all
    SELECT a.Username
    FROM account a
    WHERE a.Username LIKE CONCAT('%', string_input, '%');
    
end$$
DELIMITER ;
call input_name('c');


-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
--  Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS input_info;
DELIMITER $$
CREATE PROCEDURE input_info(in full_name varchar(50), in email_in varchar(50))
BEGIN
   DECLARE v_DepartmentID INT(10) DEFAULT 0;
    DECLARE v_PositionID INT(10) DEFAULT 0;
    
    SELECT DepartmentID INTO v_DepartmentID
    FROM department 
    WHERE DepartmentName = 'Waiting Room';
       
	SELECT PositionID INTO v_PositionID
    FROM position
    WHERE PositionName = 'Developer';
    
    INSERT INTO account
	(email, 		Username, 								FullName, 		DepartmentID, 		PositionID) 
    VALUES
    (email_in, 		SUBSTRING_INDEX(email_in, '@', 1), 		full_name, 	v_DepartmentID, 	v_PositionID);
        
end$$
DELIMITER ;
call input_info('nfqofo', 'iqiufe@com');


-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
--  để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS input_type;
DELIMITER $$
CREATE PROCEDURE input_type(in type_in varchar(20))
BEGIN

    select q.TypeID,tq.TypeName,q.Content, max(length(q.Content)) from question q
    left join typequestion tq
    on q.TypeID = tq.TypeID
    where tq.TypeName like concat('%',type_in ,'%')
    group by tq.TypeID;
        
end$$
DELIMITER ;
call input_type('mu');


-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS exam_delete;
DELIMITER $$
CREATE PROCEDURE exam_delete(in id_input varchar(20))
BEGIN
	delete from examquestion
    where ExamID = id_input;
    
    delete from exam
    where ExamID = id_input;
        
end$$
DELIMITER ;
call exam_delete(2);


-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
--  Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
DROP PROCEDURE IF EXISTS exam_old_delete;
DELIMITER $$
CREATE PROCEDURE exam_old_delete()
BEGIN
	declare exam_id int;
    declare exam_id2 int;
    declare exam_id3 int;
	
    select ExamID into exam_id from exam
	where year(current_date()) - year(CreateDate) = 11
	group by ExamID;
	
    drop view if exists exam_deleted;
    create view exam_deleted as
    select * from exam
	where year(current_date()) - year(CreateDate) = 11;
    select row_count() into exam_id2;
    
	drop view if exists exam_deleted_2;
	create view exam_deleted_2 as
	select * from examquestion eq
    left join exam e on e.ExamID = eq.ExamID
	where year(current_date()) - year(e.CreateDate) = 11;
	select row_count() into exam_id3;

    
	delete from examquestion
    where ExamID = exam_id;

    delete from exam
    where ExamID = exam_id;
	
    select exam_id2,exam_id3;
end$$
DELIMITER ;
call exam_old_delete();


-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng
--  nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
--  chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS dept_delete;
DELIMITER $$
CREATE PROCEDURE dept_delete(in dept_name varchar(50))
BEGIN
	    
	DECLARE id_waiting INT;
    DECLARE id_dept_name INT;
    
    SELECT DepartmentID INTO id_waiting
    FROM department
    WHERE DepartmentName = 'Waiting Room';
    
    SELECT DepartmentID INTO id_dept_name
    FROM department
    WHERE DepartmentName = dept_name;
    
    UPDATE account
    SET DepartmentID = id_waiting
    WHERE DepartmentID = id_dept_name;
    
    DELETE FROM department
    WHERE DepartmentName = dept_name;
end$$
DELIMITER ;
call dept_delete('marketing');


-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DROP PROCEDURE IF EXISTS month_ques;
DELIMITER $$
CREATE PROCEDURE month_ques()
BEGIN
	    
	SELECT months.*, COUNT(q.QuestionID) AS number_ques
	FROM question q 
    RIGHT JOIN (SELECT 1 AS `month` UNION
				SELECT 2 AS `month` UNION
				SELECT 3 AS `month` UNION
				SELECT 4 AS `month` UNION
				SELECT 5 AS `month` UNION
				SELECT 6 AS `month` UNION
				SELECT 7 AS `month` UNION
				SELECT 8 AS `month` UNION
				SELECT 9 AS `month` UNION
				SELECT 10 AS `month` UNION
				SELECT 11 AS `month` UNION
				SELECT 12 AS `month`) AS months
	ON MONTH(q.CreatorDate) = months.`month`
	GROUP BY months.`month`;
   
end$$
DELIMITER ;
call month_ques();


-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
--  (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")
DROP PROCEDURE IF EXISTS ques_nearest;
DELIMITER $$
CREATE PROCEDURE ques_nearest()
BEGIN
	SELECT last_six_months.`month`, 
    IF(COUNT(q.QuestionID) = 0, 'khong co cau hoi nao trong thang', COUNT(q.QuestionID)) AS number_ques
	FROM (SELECT MONTH(CURRENT_DATE - INTERVAL 5 MONTH) AS `month` UNION
		  SELECT MONTH(CURRENT_DATE - INTERVAL 4 MONTH) AS `month` UNION
		  SELECT MONTH(CURRENT_DATE - INTERVAL 3 MONTH) AS `month` UNION
		  SELECT MONTH(CURRENT_DATE - INTERVAL 2 MONTH) AS `month` UNION
		  SELECT MONTH(CURRENT_DATE - INTERVAL 1 MONTH) AS `month` UNION
		  SELECT MONTH(CURRENT_DATE - INTERVAL 0 MONTH) AS `month`) AS last_six_months
	LEFT JOIN question q ON last_six_months.`month` = MONTH(q.CreatorDate)
	GROUP BY last_six_months.`month`;
	
end$$
DELIMITER ;
call ques_nearest();