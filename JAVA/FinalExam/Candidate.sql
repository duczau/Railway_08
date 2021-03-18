-- Create Database-- 
 
DROP DATABASE IF EXISTS Candidate; 
CREATE DATABASE Candidate;
USE Candidate;

-- Create table

DROP TABLE IF EXISTS Candidate;
CREATE TABLE Candidate (
	id					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    firstName			VARCHAR(50),
    lastName			VARCHAR(50),
    phone				VARCHAR(13),
    email				VARCHAR(30) UNIQUE KEY NOT NULL,
   `password`			VARCHAR(30),
    `type`				VARCHAR(30),
    expInYear			TINYINT,
    proSkill			VARCHAR(30),
    graduationRank		ENUM('good','excellent','fair','poor')
);


-- Insert table

INSERT INTO Candidate (firstName, lastName, phone,			 email, 		`password`,			`type`, 			expInYear, 	proSkill, 		graduationRank)
VALUES			('Nguyen', 		'A'	,	0123456789,		'A@gmail.com', 		'nguyenA',			'experiencecandidate'	,	10,		'PM', 					  NULL),
				('Hoang',	 	'B'	,	0123456799,		'B@gmail.com', 		'HoangB',			'freshercandidate'		,	NULL,	NULL,					'good'),
				('Tran',		'C'	,	0123455782,		'C@gmail.com', 		'tranCC',			'freshercandidate'		,	NULL,	NULL, 			   'excellent'),
				('Le Van',		'D'	,	0123458781,		'D@gmail.com', 		'levanD',			'experiencecandidate'	,	20, 	'DEV',				      NULL),
                ('Canon',		'E'	,	0123456789,		'E@gmail.com', 		'CanonInE',			'freshercandidate'		,	NULL, 	NULL, 					'fair'),
                ('Java',		'G'	,	0123451188,		'G@gmail.com', 		'java123',			'freshercandidate'		,	NULL, 	NULL, 				    'poor');
