-- EX 1 --
-- Create database
DROP DATABASE IF EXISTS Fresher;
CREATE DATABASE Fresher;
USE Fresher;

-- Create table
CREATE TABLE Trainee (
	TraineeID			SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Full_Name			VARCHAR(50) NOT NULL,
    Birth_Date			DATE,
    Gender				BIT, 
    ET_IQ				TINYINT UNSIGNED NOT NULL,
    ET_Gmath			TINYINT UNSIGNED NOT NULL,
    ET_English			TINYINT UNSIGNED NOT NULL,
    Training_Class		VARCHAR(50) NOT NULL,
    Evaluation_Notes	MEDIUMTEXT
);

ALTER TABLE Trainee
ADD VTI_Account			VARCHAR(100) NOT NULL UNIQUE;

-- EX 2 --
-- DROP DATABASE IF EXISTS EX2;
-- CREATE DATABASE EX2;
-- USE EX2;

-- Create table
-- CREATE TABLE DataType (
-- 	ID					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--     `Name`				VARCHAR(200),
--     `Code`				VARCHAR(5),
--     ModifiedDate		DATETIME
-- );

-- EX 3 --
-- DROP DATABASE IF EXISTS EX3;
-- CREATE DATABASE EX3;
-- USE EX3;

-- Create table
-- CREATE TABLE DataType_2 (
-- 	ID					INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
--     `Name`				VARCHAR(50),
--     BirthDate			DATE,
--     Gender				BIT,
--     IsDeletedFlag	 	BIT
-- );

-- --------------------------------------------------------------------------------

-- Assignment 3 ---

-- QS 1 --
INSERT INTO Trainee (Full_Name,Birth_Date,Gender,ET_IQ, ET_Gmath, ET_English, Training_Class, Evaluation_Notes, VTI_Account)
VALUE 		('Alida Greenhead', 	'1993-08-15', 	0, 		15, 	15, 	20,		'VTI 10', 	'xin chao moi nguoi	Alida Greenhead', 		1),
            ('Norina Fargher', 		'1997-04-22', 	1, 		2, 		2, 		20,	  	'VTI 2', 	'xin chao moi nguoi	Norina Fargher', 		2),
            ('Tamma Shoesmith', 	'1995-01-31', 	1, 		20, 	15, 	19,		'VTI 1', 	'xin chao moi nguoi	Tamma Shoesmith',		3),
            ('Briana McAmish', 		'1997-08-17', 	0, 		20, 	15, 	50,	   	'VTI 1', 	'xin chao moi nguoi	Briana McAmish',		4),
            ('Joelle Ambrosi', 		'1997-09-13', 	1, 		15, 	7, 		42,		'VTI 5', 	'xin chao moi nguoi	Joelle Ambrosi', 		5),
            ('Christiano Acreman', 	'2000-05-15', 	0,		16, 	6, 		42,	  	'VTI 10', 	'xin chao moi nguoi	Christiano Acreman',	6),
            ('Aundrea Gookey', 		'1992-09-03', 	0, 		7, 		16, 	20,	   	'VTI 5', 	'xin chao moi nguoi	Aundrea Gookey',		7),
            ('Livy Somerton', 		'1993-06-03', 	1, 		10, 	19, 	48,	  	'VTI 6', 	'xin chao moi nguoi	Livy Somerton', 		8),
            ('Stephan Leschelle', 	'1998-01-20', 	1, 		20, 	20, 	50, 	'VTI 10', 	'xin chao moi nguoi	Stephan Leschelle',		9),
            ('Warde Ferrini', 		'1997-07-16', 	1, 		10, 	8,	 	38,	   	'VTI 2', 	'xin chao moi nguoi	Warde Ferrini',			10);
            
-- QS 2 --
-- SELECT *, month(Birth_Date) FROM Trainee
-- WHERE ET_IQ > 10 AND ET_Gmath > 10 AND  ET_English > 10
-- ORDER BY month(Birth_Date);
            
-- QS 3--
-- SELECT *, length(Full_Name) AS `Charactor` FROM Trainee
-- WHERE length(Full_Name)=(SELECT MAX(length(Full_Name)) FROM Trainee);
            
-- QS 4 --
-- SELECT * FROM trainee
-- WHERE ET_IQ + ET_Gmath >=31 AND ET_IQ >=8 AND ET_Gmath >= 8 AND ET_English >= 18;

-- QS 5 --
-- DELETE FROM trainee
-- WHERE TraineeID = 3;

-- QS 6 --    
-- UPDATE trainee
-- SET Training_Class = 'lop 2'
-- WHERE TraineeID = 5;