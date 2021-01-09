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
    PRIMARY KEY (GroupID, CreatorID)
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
    CreateDate		DATE UNIQUE KEY,
    FOREIGN KEY (CategoryID) REFERENCES CategoryQuestion (CategoryID),
    FOREIGN KEY (CreatorID) REFERENCES `Group` (CreatorID)
);

DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion (
	ExamID			TINYINT UNSIGNED PRIMARY KEY,
    QuestionID		TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY (ExamID) REFERENCES Exam (ExamID),
    FOREIGN KEY (QuestionID) REFERENCES Question (QuestionID)
);

-- SET FOREIGN_KEY_CHECKS=0;

-- Add data ---------------------------
INSERT INTO Department
VALUES (1, 'CEO'), (2, 'MARKETING'), (3, 'SALES'), (4, 'Bảo vệ'), (5,'Thư kí');

INSERT INTO Position
VALUES (1, 'Dev'), (2, 'Test'), (3, 'Scrum Master'), (4, 'PM');

INSERT INTO `Account`
VALUES 			(1, 'CEO@gmail.com', 'CEO', 'C E O', 5, 1, '2020-01-01'), 
				(2, 'MARKETING@gmail.com', 'MARKETING', 'ma ket ting', 1, 2, '2020-01-02'), 
                (3, 'SALES@gmail.com','SALES', 'sa le', 2, 3, '2020-01-03'), 
                (4, 'Baove@gmail.com', 'Baove', 'bao ve', 3, 4, '2020-01-04'), 
                (5, 'Thuky@gmail.com', 'Thuky', 'thu ky', 5, 5, '2020-01-05');

INSERT INTO `Group`
VALUES 		(1, 'CEO', 1, '2020-02-01'), 
			(2, 'MARKETING', 2, '2020-02-22'), 
            (3, 'SALES', 3, '2020-02-03'), 
            (4, 'Bảo vệ', 4, '2020-02-04'), 
            (5, 'Thư kí', 5, '2020-02-05');

INSERT INTO GroupAccount
VALUES 		(1, 1, '2020-03-01'), 
			(2, 2, '2020-03-22'), 
            (3, 3, '2020-03-03'), 
            (4, 4, '2020-03-04'), 
            (5, 5, '2020-03-05');

INSERT INTO TypeQuestion
VALUES (1, 'Essay'), (2, 'Multiple-Choice');

INSERT INTO CategoryQuestion
VALUES (1, 'CEO'), (2, 'MARKETING'), (3, 'SALES'), (4, 'Bảo vệ'), (5,'Thư kí');

INSERT INTO Question
VALUES 		(1, 'CEO', 1, 1, 1, '2020-12-01'), 
			(2, 'MARKETING', 2, 2, 2, '2020-12-02'), 
            (3, 'SALES', 3, 3, 3, '2020-12-03'), 
            (4, 'Bảo vệ', 4, 4, 4, '2020-12-04'), 
            (5,'Thư kí', 5, 5, 5, '2020-12-05');

INSERT INTO Answer
VALUES 		(1, 'CEO', 1, TRUE), 
			(2, 'MARKETING', 2, TRUE), 
            (3, 'SALES', 3, FALSE), 
            (4, 'Bảo vệ', 4, FALSE), 
            (5,'Thư kí', 5, FALSE);

INSERT INTO Exam
VALUES 		(1, 'CEO?', 'as', 2, 60, 3, '2020-10-02'), 
			(2, 'MARKETING?','ff', 5, 60, 8, '2020-10-03'), 
            (3, 'SALES?', 'qw', 8, 60, 7, '2020-10-04'), 
            (4, 'Bảo vệ?', 'wq', 9, 60, 4, '2020-10-05'), 
            (5,'Thư kí?', 'afd', 1, 60, 2, '2020-10-06');

INSERT INTO ExamQuestion
VALUES (1, 2), (2, 3), (3, 4), (4, 5), (5,6);