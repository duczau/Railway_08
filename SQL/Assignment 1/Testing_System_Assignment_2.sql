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
	AcountID		INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Email			VARCHAR(100) NOT NULL UNIQUE KEY,
    Username		VARCHAR(100) NOT NULL UNIQUE KEY,
	Gender			VARCHAR(50) DEFAULT 'M',	
    FullName		VARCHAR(100) NOT NULL,
    DepartmentID	TINYINT UNSIGNED,
    PositionID		TINYINT UNSIGNED,
    CreateDate		DATE,
    FOREIGN KEY(DepartmentID) REFERENCES Department (DepartmentID) ON DELETE CASCADE,
    FOREIGN KEY(PositionID) REFERENCES Position (PositionID) ON DELETE CASCADE
); 

DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group` (
	GroupID			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    GroupName		VARCHAR(30) NOT NULL UNIQUE KEY,
	CreatorID		INT UNSIGNED,
    CreateDate		DATE,
    FOREIGN KEY (CreatorID) REFERENCES `Account` (AcountID)
);

DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount (
	GroupID			TINYINT UNSIGNED NOT NULL,
    AcountID		INT UNSIGNED NOT NULL,
    JoinDate		DATE,
    FOREIGN KEY (GroupID) REFERENCES `Group` (GroupID) ON DELETE CASCADE,
    FOREIGN KEY (AcountID) REFERENCES `Account` (AcountID) ON DELETE CASCADE,
    PRIMARY KEY (GroupID,AcountID)
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
    CategoryID		TINYINT UNSIGNED NOT NULL,
    TypeID			TINYINT UNSIGNED NOT NULL,
    CreatorID		INT UNSIGNED NOT NULL,
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
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam (
	ExamID 			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    `Code`			VARCHAR(50) NOT NULL,
    Title			VARCHAR(200) NOT NULL,
    CategoryID		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    Duration		TINYINT UNSIGNED NOT NULL,
    CreatorID		INT UNSIGNED NOT NULL UNIQUE KEY,
    CreateDate		DATE,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Group` (CreatorID)
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
	ExamID			TINYINT UNSIGNED NOT NULL,
    QuestionID		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID) ON DELETE CASCADE,
    PRIMARY KEY (ExamID,QuestionID)
);

SET FOREIGN_KEY_CHECKS=0;

-- Add data ---------------------------
INSERT INTO Department(departmentNAme)
VALUES 		('Giám Đốc'), ('MARKETING'), 
			('SALES'), ('Bảo vệ'), 
            ('Thư kí'), ('Nhân sự'), 
            ('Kỹ thuật'), ('Tài chính'), 
            ('Phó Giám đốc'), ('Waiting Room');

INSERT INTO Position (PositionName)
VALUES ('Dev'), ('Test'), ('Scrum Master'), ('PM');

INSERT INTO `Account`(Email,Username,Gender,FullName,DepartmentID,PositionID,CreateDate)
VALUES 		(	'Giamdoc@gmail.com',				  'CEO',	'M',  'Le Văn aA', 			5, 		1, 		'2020-01-02'), 
			(	'Marketting@gmail.com',		   'Marketting',	'F',  'Nguyễn Văn q', 		2, 		2, 		'2020-01-03'), 
			(	'SALES@mail.com',					'SALES',	'F',  'Nguyễn Văn b', 		3, 		3, 		'2020-01-03'), 
			(	'Baove@gmail.com', 					'Baove',	'M',  'Nguyễn Văn c', 		7, 		4, 		'2020-01-04'), 
			(	'Thuky@mail.com', 					'Thuky',	'F',  'Nguyễn Văn d', 		5, 		1, 		'2020-01-05'),
			(	'Nhansu@gmail.com', 			   'Nhansu',	'U',  'Nguyễn Văn e', 		1, 		2, 		'2020-01-05'),
			(	'Kythuat@mail.com', 			  'Kythuat',	'M',  'Nguyễn Văn f', 		7, 		3, 		'2020-01-05'),
			(	'Taichinh@mail.com', 			 'Taichinh',	'F',  'Nguyễn Văn i', 		2, 		2, 		'2020-01-05'),
			(	'Phogiamdoc@gmail.com', 	   'Phogiamdoc',	'M',  'Nguyễn Văn g', 		2, 		4, 		'2020-01-05'),
			( 	'Banhang@gmail.com', 		      'Banhang',	'U',  'Nguyễn Văn h',  	    7, 		1, 		'2020-01-05');

INSERT INTO `Group`(GroupName,CreatorID,CreateDate)
VALUES 		(		'VTI_1', 		1, 	'2020-02-01'), 
			(		'VTI_2', 		2, 	'2020-02-22'), 
            (		'VTI_3', 		3, 	'2020-02-03'), 
            (	   	'VTI_4', 		4, 	'2020-02-04'), 
            (	  	'VTI_5', 		5, 	'2020-02-05'),
            (	  	'VTI_6', 		6, 	'2020-02-06'),
            (	  	'VTI_7', 		7, 	'2020-02-07'),
            (	  	'VTI_8', 		8, 	'2020-02-05'),
            (	   	'VTI_9', 		9, 	'2020-02-05'),
            (	   'VTI_10', 	   10, 	'2020-02-05');

INSERT INTO GroupAccount
VALUES 		(1,	 1, '2020-03-01'), 
			(2,	 2, '2020-03-22'), 
            (3,	 3, '2020-03-03'), 
            (4,	 4, '2020-03-04'), 
            (1,	 2, '2020-03-05'),
            (6,	 6, '2020-03-04'),
            (7,	 7, '2020-03-04'),
            (4,	 2, '2020-03-04'),
            (1,	 9, '2020-03-04'),
            (10, 10, '2020-03-04');

INSERT INTO TypeQuestion
VALUES (1,'Essay'), (2,'Multiple-Choice');

INSERT INTO CategoryQuestion
VALUES 		(1, 'category 1'), 	(2, 'category 2'), 
			(3, 'category 3'),		(4, 'category 4'), 
            (5,	'category 5'),		(6, 'category 6'),
			(7, 'category 7'), 		(8, 'category 8'), 
			(9, 'category 9'),		(10, 'category 10'); 

INSERT INTO Question
VALUES 		(1, 	'question 1 21', 	1,	 1,	 7, '2020-12-01'), 
			(2, 	'question 2', 	2,	 2,	 2, '2020-12-02'), 
            (3, 	'question 3', 	3,	 1,	 7, '2020-10-03'), 
            (4, 	'question 414 6 84 849', 	1,	 1,	 4, '2020-12-04'), 
            (5, 	'question 51 5665', 	5,	 1,	 5, '2020-12-05'),
            (6, 	'question 6', 	6,	 2,	 6, '2020-12-05'),
            (7, 	'question 12', 	1,	 1,	 7, '2020-10-05'),
            (8, 	'question 13', 	8,	 2,	 8, '2020-12-05'),
            (9, 	'question 14', 	3,	 2,	 9, '2020-10-05'),
            (10, 	'question 10', 	10,	 1, 10, '2020-12-05');

INSERT INTO Answer
VALUES 		(1, 	'Answer 1', 	1, TRUE), 
			(2, 	'Answer 2', 	1, TRUE), 
            (3, 	'Answer 3', 	1, FALSE), 
            (4,		'Answer 4', 	4, FALSE), 
            (5,		'Answer 5', 	5, TRUE),
            (6,		'Answer 6', 	6, TRUE), 
            (7, 	'Answer 7', 	7, FALSE), 
            (8, 	'Answer 8', 	8, TRUE), 
            (9, 	'Answer 9', 	9, FALSE), 
            (10, 	'Answer 10',	10, FALSE); 

INSERT INTO Exam
VALUES 		(1, 	'A1', 	'Exam 1', 	1, 60, 	1, '2010-10-02'), 
			(2, 	'A1',	'Exam 2', 	2, 120, 2, '2020-10-03'), 
            (3, 	'A1', 	'Exam 3', 	3, 60, 	3, '2020-10-04'), 
            (4, 	'A1', 	'Exam 4', 	4, 60, 	4, '2020-10-05'), 
            (5,		'A1', 	'Exam 5', 	5, 120, 5, '2015-10-06'),
            (6, 	'A1', 	'Exam 6', 	6, 60, 	6, '2020-10-04'), 
            (7, 	'A1', 	'Exam 7', 	7, 180, 7, '2010-10-04'), 
            (8, 	'A1', 	'Exam 8', 	8, 60, 	8, '2020-10-04'), 
            (9, 	'A1', 	'Exam 9', 	9, 60, 	9, '2020-10-04'), 
            (10, 	'A1', 	'Exam 10', 	10, 60, 10, '2020-10-04'); 

INSERT INTO ExamQuestion
VALUES 		(1, 1), (2, 2), 
			(1, 3), (4, 4), 
            (5,	5), (6, 5),
			(7, 1), (1, 8), 
			(9, 5), (10, 1); 

