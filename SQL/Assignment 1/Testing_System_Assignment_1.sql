CREATE DATABASE Testing_System;
-- USE	Testing_System;

CREATE TABLE Department (
	DepartmentID	INT AUTO_INCREMENT PRIMARY KEY,
    DepartmentName	VARCHAR(30)
);

CREATE TABLE Position (
	PositionID		INT AUTO_INCREMENT PRIMARY KEY,
    PositionName	VARCHAR(30)
);

CREATE TABLE Account (
	AcountID		INT AUTO_INCREMENT PRIMARY KEY,
    Email			VARCHAR(30),
    Username		VARCHAR(30),
    FullName		VARCHAR(30),
    DepartmentID	INT,
    PositionID		INT,
    CreateDate		DATE
);

CREATE TABLE `Group` (
	GroupID			INT AUTO_INCREMENT PRIMARY KEY,
    GroupName		VARCHAR(30),
	CreatorID		INT,
    CreateDate		DATE
);

CREATE TABLE GroupAccount (
	GroupID			INT,
    AcountID		INT,
    JoinDate		DATE
);

CREATE TABLE TypeQuestion (
	TypeID			INT AUTO_INCREMENT PRIMARY KEY,
    TypeName		VARCHAR(200)
);

CREATE TABLE CategoryQuestion (
	CategoryID 		INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName	VARCHAR(100)
);

CREATE TABLE Question (
	QuestionID 		INT AUTO_INCREMENT PRIMARY KEY,
    Content			VARCHAR(200),
    CategoryID		INT,
    TypeID			INT,
    CreatorID		INT,
    CreatorDate		DATE
);

CREATE TABLE Answer (
	AnswerID 		INT AUTO_INCREMENT PRIMARY KEY,
    Content			VARCHAR(200),
    QuestionID		INT,
    isCorrect		BOOLEAN
);

CREATE TABLE Exam (
	ExamID 			INT AUTO_INCREMENT PRIMARY KEY,
    `Code`			INT,
    Title			VARCHAR(100),
    CategoryID		INT,
    Duration		INT,
    CreatorID		INT,
    CreateDate		DATE
);

CREATE TABLE ExamQuestion (
	ExamID			INT AUTO_INCREMENT PRIMARY KEY,
    QuestionID		INT
);