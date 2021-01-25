-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
use Testing_System_2;
DROP TRIGGER IF EXISTS not_allow;
DELIMITER $$
CREATE TRIGGER not_allow
BEFORE INSERT on `Group`
FOR EACH ROW
BEGIN

	IF YEAR(NEW.CreateDate) <= YEAR(NOW()) - 2 THEN
		SIGNAL SQLSTATE '12345' 
		SET MESSAGE_TEXT = 'khong duoc tao truoc nam 2019';
	END IF;

END$$group
DELIMITER ;

INSERT into `Group`
VALUEs (1, 'adda', 2, '2010-02-05');


-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
--  department "Sale" nữa, khi thêm thì hiện ra thông báo "Department Sale cannot add more user"
use Testing_System_2;
DROP TRIGGER IF EXISTS do_not_allow;
DELIMITER $$
CREATE TRIGGER do_not_allow
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
	declare dept_name INT;
	select DepartmentID into dept_name from department
    where DepartmentName = 'SALES';
    
    if new.Departmentid = dept_name then
		signal sqlstate '12345'
		set message_text = 'Department Sale cannot add more user';
    end if;
END$$
DELIMITER ;

INSERT into `account` (Email, Username, FullName,DepartmentID)
VALUEs ('ajsdkj@afna', 'adda', 'rhtr', 3);


-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
use Testing_System_2;
DROP TRIGGER IF EXISTS max_user;
DELIMITER $$
CREATE TRIGGER max_user
BEFORE INSERT ON groupaccount
FOR EACH ROW 
BEGIN

	IF NEW.GroupID = (SELECT GroupID FROM (SELECT GroupID, COUNT(GroupID) AS number_of_accounts
											  FROM groupaccount
                                              GROUP BY GroupID
                                              HAVING number_of_accounts = 3) AS temp) THEN
		SIGNAL SQLSTATE '22222'
		SET MESSAGE_TEXT = 'Maximun account is 3';
    END IF;

END $$
DELIMITER ;

INSERT into groupaccount
VALUEs (1, 5, '2010-02-05');


-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
use Testing_System_2;
DROP TRIGGER IF EXISTS max_questions;
DELIMITER $$
CREATE TRIGGER max_questions
BEFORE INSERT ON examquestion
FOR EACH ROW 
BEGIN

	IF NEW.ExamID = (SELECT ExamID FROM (SELECT ExamID, COUNT(QuestionID) AS number_of_questions
											  FROM examquestion
                                              GROUP BY ExamID
                                              HAVING number_of_questions = 3) AS a) THEN
		SIGNAL SQLSTATE '33333'
		SET MESSAGE_TEXT = 'Maximun question is 3';
    END IF;

END $$
DELIMITER ;

INSERT into examquestion
VALUEs (1, 5);



-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là
--  admin@gmail.com (đây là tài khoản admin, không cho phép user xóa),
--  còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
use Testing_System_2;
DROP TRIGGER IF EXISTS do_not_delete;
DELIMITER $$
create trigger do_not_delete
before delete on `account`
for each row
begin
	declare cant_delete varchar(50);
    
	select AcountID into cant_delete from account
    where email = old.email;
    
    IF OLD.email like '%t%' THEN
		SIGNAL SQLSTATE '44444'
		SET MESSAGE_TEXT = 'can not delete!';
	ELSE 
		DELETE FROM groupaccount WHERE AcountID = cant_delete;
        UPDATE `group` SET CreatorID = NULL WHERE CreatorID = cant_delete;
        UPDATE exam SET CreatorID = NULL WHERE CreatorID = cant_delete;
        UPDATE question SET CreatorID = NULL WHERE CreatorID = cant_delete;
    end if;
    
end$$
DELIMITER ;

delete from account
where AcountID = 2;


-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account, 
-- hãy tạo trigger cho phép người dùng khi tạo account không điền
--  vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
use Testing_System_2;
DROP TRIGGER IF EXISTS waiting_dept;
DELIMITER $$
CREATE TRIGGER waiting_dept
BEFORE INSERT ON account
FOR EACH ROW BEGIN
	declare waiting_room int;
    select DepartmentID into waiting_room from department
    where DepartmentName like '%waiting%';
    
    if new.DepartmentID is null 
    then set new.DepartmentID = waiting_room;
    end if;

END$$
DELIMITER ;
INSERT into account (AcountID, Email, FullName, Username)
values (11, 'adk@bafb', 'gjirjg', 'bbb');


-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi
--  question, trong đó có tối đa 2 đáp án đúng.
 use Testing_System_2;
DROP TRIGGER IF EXISTS max_answer;
DELIMITER $$
CREATE TRIGGER max_answer
BEFORE INSERT ON answer
FOR EACH ROW
BEGIN
	declare maxAnswer int;
    declare maxAnswer_correct int;
    
    SELECT COUNT(AnswerID) INTO maxAnswer
    FROM answer
    WHERE QuestionID = NEW.QuestionID;
    
    SELECT COUNT(AnswerID) INTO maxAnswer_correct
    FROM answer
    WHERE QuestionID = NEW.QuestionID and isCorrect = 1;
    
    if maxAnswer > 3  then
		signal sqlstate '45484'
        set message_text = 'Tối đa là 3 đáp án trong 1 câu hỏi';
    end if;
    if maxAnswer_correct > 2  then
		signal sqlstate '45484'
        set message_text = 'Tối đa là 2 đáp án đúng trong 1 câu hỏi';
    end if;
    
END$$
DELIMITER ;
INSERT into answer (Content, QuestionID, isCorrect)
values ('adk@bafb', 1, 1);
INSERT into answer (Content, QuestionID, isCorrect)
values ('adk@htj', 5, 1);
 
 
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
--  Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
--  Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database
use Testing_System_2;
DROP TRIGGER IF EXISTS update_data;
DELIMITER $$
CREATE TRIGGER update_data
BEFORE INSERT ON account
FOR EACH ROW
BEGIN
	if new.Gender = 'nam'
    then set new.Gender = 'M';
    elseif new.Gender = 'nu'
    then set new.Gender = 'F';
    elseif new.Gender in ('Chưa xác định', 'gay','less','bede')
    then set new.Gender = 'U';
    else 
		signal sqlstate '77777'
        set message_text = 'yeu cau nhap chinh xac gioi tinh';
    end if;
END$$
DELIMITER ;
INSERT INTO account (Email,Username,Gender,FullName )
values ('sioejgi@gkln','new name','NỮ','ahhaa sa' );
 
 
-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
use Testing_System_2;
DROP TRIGGER IF EXISTS not_delete_exam;
DELIMITER $$
CREATE TRIGGER not_delete_exam
BEFORE DELETE ON exam
FOR EACH ROW BEGIn
	if OLD.ExamID IN (SELECT ExamID
					   FROM exam
                       WHERE DAY('2020-10-06') - DAY(CreateDate) <= 2) then
		signal sqlstate '77777'
        set message_text = 'không cho phép xóa bài thi mới tạo được 2 ngày';
	end if;
END $$
DELIMITER ;
DELETE from exam 
WHERE ExamID = 1;
DELETE from exam 
WHERE ExamID = 10;


-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các
--  question khi question đó chưa nằm trong exam nào
 
 -- update --
 use Testing_System_2;
DROP TRIGGER IF EXISTS not_update_question;
DELIMITER $$
CREATE TRIGGER not_update_question
BEFORE UPDATE ON question
FOR EACH ROW BEGIn

	if old.QuestionID in (SELECT DISTINCT QuestionID FROM answer) 
		or old.QuestionID in (SELECT DISTINCT QuestionID FROM examquestion) 
    then
		signal sqlstate '88888'
        set message_text = 'question này đã nằm trong exam';
	end if;
end$$
DELIMITER ;

UPDATE question
set Content = 'ajvb'
where QuestionID = 8;

 -- delete --
use Testing_System_2;
DROP TRIGGER IF EXISTS not_delete_question;
DELIMITER $$
CREATE TRIGGER not_delete_question
BEFORE delete ON question
FOR EACH ROW BEGIn

	if old.QuestionID in (SELECT DISTINCT QuestionID FROM answer) 
		or old.QuestionID in (SELECT DISTINCT QuestionID FROM examquestion) 
    then
		signal sqlstate '88888'
        set message_text = 'question này đã nằm trong exam';
	end if;
end$$
DELIMITER ;
delete from question
WHERE QuestionID = 8;
 
-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"
select *,
CASE 
	WHEN Duration <= 30 THEN 'Short time'
    WHEN 30 < Duration <= 60 THEN 'Medium time'
    ELSE 'Long time'
END AS duration_time
from exam;


-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên
--  là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher
select GroupID, count(AcountID), 
case
	when count(AcountID)<=5 then 'few' 
    when 5<count(AcountID)<=20 then 'normal' 
    else 'normal' 
end as the_number_user_amount
 from groupaccount
 group by GroupID;


-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào
--  không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
select d.DepartmentID, d.DepartmentName, 
	case 
	when count(a.DepartmentID) = 0 then  "Không có User" 
    else count(a.DepartmentID)
    end as `so luong user` 
from account a
right join department d
on d.DepartmentID = a.DepartmentID
GROUP BY d.DepartmentID