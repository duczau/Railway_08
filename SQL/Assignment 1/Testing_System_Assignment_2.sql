-- Create database ---------------------------
DROP DATABASE IF EXISTS Testing_system_2;
CREATE DATABASE Testing_System_2;
USE	Testing_System_2;

-- Create table ---------------------------
DROP TABLE IF EXISTS Department;
CREATE TABLE Department (
	DepartmentID	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    DepartmentName	VARCHAR(30) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS Position;
CREATE TABLE Position (
	PositionID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    PositionName	ENUM('Dev', 'Test', 'Scrum Master', 'PM') NOT NULL 
);

DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account` (
	AcountID		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email			VARCHAR(100) NOT NULL UNIQUE KEY,
    Username		VARCHAR(100) NOT NULL UNIQUE KEY,
    FullName		VARCHAR(100) NOT NULL,
    DepartmentID	TINYINT UNSIGNED NOT NULL,
    PositionID		TINYINT UNSIGNED NOT NULL,
    CreateDate		DATE,
    FOREIGN KEY(DepartmentID) REFERENCES Department (DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES Position (PositionID)
);

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
	GroupID			TINYINT UNSIGNED AUTO_INCREMENT,
    GroupName		VARCHAR(30) NOT NULL UNIQUE KEY,
	CreatorID		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate		DATE,
    PRIMARY KEY (GroupID)
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
	GroupID			TINYINT UNSIGNED NOT NULL,
    AcountID		TINYINT UNSIGNED NOT NULL,
    JoinDate		DATE,
    FOREIGN KEY (GroupID) REFERENCES `Group` (GroupID),
    FOREIGN KEY (AcountID) REFERENCES `Account` (AcountID)
);

DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion (
	TypeID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    TypeName		ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion (
	CategoryID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    CategoryName	VARCHAR(50) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS Question;
CREATE TABLE Question (
	QuestionID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content			VARCHAR(200) NOT NULL,
    CategoryID		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    TypeID			TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreatorID		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreatorDate		DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (TypeID) REFERENCES TypeQuestion (TypeID),
    FOREIGN KEY (CreatorID) REFERENCES `Group` (CreatorID)
);

DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer (
	AnswerID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Content			VARCHAR(200) NOT NULL,
    QuestionID		TINYINT UNSIGNED,
    isCorrect		BOOLEAN NOT NULL,
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	ExamID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`			VARCHAR(50) NOT NULL,
    Title			VARCHAR(200) NOT NULL,
    CategoryID		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    Duration		TINYINT UNSIGNED NOT NULL,
    CreatorID		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate		DATE,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Group` (CreatorID)
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
	ExamID			TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    QuestionID		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

SET FOREIGN_KEY_CHECKS=0;

-- Add data ---------------------------
INSERT INTO Department
VALUES 		(1, 'Giám Đốc'), (2, 'MARKETING'), 
			(3, 'SALES'), (4, 'Bảo vệ'), 
            (5,'Thư kí'), (6, 'Nhân sự'), 
            (7, 'Kỹ thuật'), (8, 'Tài chính'), 
            (9, 'Phó Giám đốc'), (10, 'Bán hàng');

INSERT INTO Position
VALUES (1, 'Dev'), (2, 'Test'), (3, 'Scrum Master'), (4, 'PM');

INSERT INTO `Account`
VALUES 			(1,		'Giamdoc@gmail.com',				  'CEO',	  'Nguyễn Văn aA', 		1, 		1, 		'2020-01-02'), 
                (2,		'Marketting@gmail.com',		   'Marketting',	  'Nguyễn Văn q', 		2, 		2, 		'2020-01-03'), 
                (3,		'SALES@gmail.com',					'SALES',	  'Nguyễn Văn b', 		3, 		3, 		'2020-01-03'), 
                (4, 	'Baove@gmail.com', 					'Baove',	  'Nguyễn Văn c', 		4, 		4, 		'2020-01-04'), 
                (5, 	'Thuky@gmail.com', 					'Thuky',	  'Nguyễn Văn d', 		5, 		1, 		'2020-01-05'),
                (6, 	'Nhansu@gmail.com', 			   'Nhansu',	  'Nguyễn Văn e', 		6, 		2, 		'2020-01-05'),
                (7, 	'Kythuat@gmail.com', 			  'Kythuat',	  'Nguyễn Văn f', 		7, 		3, 		'2020-01-05'),
                (8, 	'Taichinh@gmail.com', 			 'Taichinh',	  'Nguyễn Văn i', 		8, 		2, 		'2020-01-05'),
                (9, 	'Phogiamdoc@gmail.com', 	   'Phogiamdoc',	  'Nguyễn Văn g', 		9, 		4, 		'2020-01-05'),
                (10, 	'Banhang@gmail.com', 		      'Banhang',	  'Nguyễn Văn h', 	   10, 		1, 		'2020-01-05');

INSERT INTO `Group`
VALUES 		(1,			'VTI_1', 		1, 	'2020-02-01'), 
			(2, 		'VTI_2', 		2, 	'2020-02-22'), 
            (3, 		'VTI_3', 		3, 	'2020-02-03'), 
            (4,		   	'VTI_4', 		4, 	'2020-02-04'), 
            (5,		  	'VTI_5', 		5, 	'2020-02-05'),
            (6,		  	'VTI_6', 		6, 	'2020-02-06'),
            (7,		  	'VTI_7', 		7, 	'2020-02-07'),
            (8,		  	'VTI_8', 		8, 	'2020-02-05'),
            (9,		   	'VTI_9', 		9, 	'2020-02-05'),
            (10,	   'VTI_10', 	   10, 	'2020-02-05');

INSERT INTO GroupAccount
VALUES 		(1,	 1, '2020-03-01'), 
			(2,	 2, '2020-03-22'), 
            (3,	 3, '2020-03-03'), 
            (4,	 4, '2020-03-04'), 
            (5,	 5, '2020-03-05'),
            (6,	 6, '2020-03-04'),
            (7,	 7, '2020-03-04'),
            (8,	 8, '2020-03-04'),
            (9,	 9, '2020-03-04'),
            (10, 10, '2020-03-04');

INSERT INTO TypeQuestion
VALUES (1, 'Essay'), (2, 'Multiple-Choice');

INSERT INTO CategoryQuestion
VALUES 		(1, 'category 1'), 	(2, 'category 2'), 
			(3, 'category 3'),		(4, 'category 4'), 
            (5,	'category 5'),		(6, 'category 6'),
			(7, 'category 7'), 		(8, 'category 8'), 
			(9, 'category 9'),		(10, 'category 10'); 

INSERT INTO Question
VALUES 		(1, 	'question 1', 	1,	 1,	 1, '2020-12-01'), 
			(2, 	'question 1', 	2,	 2,	 2, '2020-12-02'), 
            (3, 	'question 1', 	3,	 3,	 3, '2020-12-03'), 
            (4, 	'question 1', 	4,	 4,	 4, '2020-12-04'), 
            (5, 	'question 1', 	5,	 5,	 5, '2020-12-05'),
            (6, 	'question 1', 	6,	 6,	 6, '2020-12-05'),
            (7, 	'question 1', 	7,	 7,	 7, '2020-12-05'),
            (8, 	'question 1', 	8,	 8,	 8, '2020-12-05'),
            (9, 	'question 1', 	9,	 9,	 9, '2020-12-05'),
            (10, 	'question 10', 	10,	 10, 10, '2020-12-05');

INSERT INTO Answer
VALUES 		(1, 	'Answer 1', 	1, TRUE), 
			(2, 	'Answer 2', 	2, TRUE), 
            (3, 	'Answer 3', 	3, FALSE), 
            (4,		'Answer 4', 	4, FALSE), 
            (5,		'Answer 5', 	5, TRUE),
            (6,		'Answer 6', 	6, TRUE), 
            (7, 	'Answer 7', 	7, FALSE), 
            (8, 	'Answer 8', 	8, TRUE), 
            (9, 	'Answer 9', 	9, FALSE), 
            (10, 	'Answer 10',	10, FALSE); 

INSERT INTO Exam
VALUES 		(1, 	'A1', 	'Exam 1', 	1, 60, 	1, '2020-10-02'), 
			(2, 	'A1',	'Exam 2', 	2, 120, 2, '2020-10-03'), 
            (3, 	'A1', 	'Exam 3', 	3, 60, 	3, '2020-10-04'), 
            (4, 	'A1', 	'Exam 4', 	4, 60, 	4, '2020-10-05'), 
            (5,		'A1', 	'Exam 5', 	5, 120, 5, '2020-10-06'),
            (6, 	'A1', 	'Exam 6', 	6, 60, 	6, '2020-10-04'), 
            (7, 	'A1', 	'Exam 7', 	7, 180, 7, '2020-10-04'), 
            (8, 	'A1', 	'Exam 8', 	8, 60, 	8, '2020-10-04'), 
            (9, 	'A1', 	'Exam 9', 	9, 60, 	9, '2020-10-04'), 
            (10, 	'A1', 	'Exam 10', 	10, 60, 10, '2020-10-04'); 

INSERT INTO ExamQuestion
VALUES 		(1, 1), (2, 2), 
			(3, 3), (4, 4), 
            (5,	5), (6, 6),
			(7, 7), (8, 8), 
			(9, 9), (10, 10); 

