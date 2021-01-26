-- Create database ---------------------------
DROP DATABASE IF EXISTS ThucTap;
CREATE DATABASE ThucTap;
USE	ThucTap;

-- Create table ---------------------------
DROP TABLE IF EXISTS Country;
CREATE TABLE Country (
	country_id		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    country_name	VARCHAR(50) NOT NULL UNIQUE KEY
);

DROP TABLE IF EXISTS Location;
CREATE TABLE Location (
	location_id		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    street_address	VARCHAR(150) NOT NULL UNIQUE KEY,
    postal_code		INT UNSIGNED UNIQUE KEY,
    country_id		TINYINT UNSIGNED,
	FOREIGN KEY(country_id) REFERENCES Country (country_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Employee;
CREATE TABLE Employee (
	employee_id		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    full_name		VARCHAR(50) NOT NULL UNIQUE KEY,
    email			VARCHAR(100) NOT NULL UNIQUE KEY,
    location_id		TINYINT UNSIGNED,
	FOREIGN KEY(location_id) REFERENCES Location (location_id) ON DELETE SET NULL
);

-- 1. Add data ---------------------------
INSERT INTO Country(country_name)
VALUES 		('Viet Nam'), 
			('Lao'), 
			('Canada');

INSERT INTO Location (street_address, postal_code, country_id)
VALUES 		('135 Nam Kỳ Khởi Nghĩa',	71000, 	1), 
			('1138 Toy Avenue',			550000, 3), 
            ('125 Phùng Hưng', 			10000, 	1);

INSERT INTO Employee(full_name,email,location_id)
VALUES 		('Nguyen Van Anh', 	'nn03@gmail.com', 			1),
			('michael henry', 	'michael@gmail.com', 		2),
            ('bui xuong trach', 'trachbuixuong@gmail.com',	1);
            
-- 2.Viết lệnh để
-- a) Lấy tất cả các nhân viên thuộc Việt nam

SELECT e.employee_id, e.full_name, c.country_name FROM Location l 
INNER JOIN Employee e
ON l.location_id = e.location_id
INNER JOIN Country c
ON c.country_id = l.country_id
WHERE c.country_name = 'Viet Nam';

-- b) Lấy ra tên quốc gia của employee có email là "nn03@gmail.com"

SELECT e.email, c.country_name FROM Location l 
INNER JOIN Employee e
ON l.location_id = e.location_id
INNER JOIN Country c
ON c.country_id = l.country_id
WHERE e.email = 'nn03@gmail.com';

-- c) Thống kê mỗi country, mỗi location có bao nhiêu employee đang làm việc.

SELECT c.country_name, l.street_address, count(e.location_id) as number_of_employee FROM Location l
INNER JOIN Employee e
ON l.location_id = e.location_id
INNER JOIN Country c
ON c.country_id = l.country_id
GROUP BY c.country_name;

-- 3. Tạo trigger cho table Employee chỉ cho phép insert mỗi quốc gia có tối đa 10 employee
USE ThucTap;
DROP TRIGGER IF EXISTS insert_emp;
DELIMITER $$
CREATE TRIGGER insert_emp
BEFORE INSERT ON employee
FOR EACH ROW 
BEGIN
    DECLARE max_emp int;
    (SELECT max(number_of_employee) into max_emp from 
									(SELECT *,count(l.country_id) as number_of_employee FROM Location l
									INNER JOIN Employee e
									ON l.location_id = e.location_id
									INNER JOIN Country c
									ON c.country_id = l.country_id
									GROUP BY c.country_name) a);
	IF max_emp > 3 THEN
		SIGNAL SQLSTATE '33333'
		SET MESSAGE_TEXT = 'Maximun employee is 10';
    END IF;

END $$
DELIMITER ;

INSERT INTO employee (employee_id, full_name, email, location_id)
VALUES 		
            (11, 'pogba', 			'pogba@hotmail.com', 	3);
                                    
-- 4. Hãy cấu hình table sao cho khi xóa 1 location nào đó thì tất cả employee ở
-- location đó sẽ có location_id = null

-- đã cấu hình ở phần create table
DELETE FROM location
WHERE location_id = 1;
