CREATE DATABASE ChuhoodGym;
USE ChuhoodGym;

CREATE TABLE Work(
	ID_Work VARCHAR(10) NOT NULL PRIMARY KEY,
	Title_Work VARCHAR(50) NOT NULL,
	Salary INT NULL
);


CREATE TABLE Employee(
	ID_Employee VARCHAR(10) NOT NULL PRIMARY KEY,
	Name_Employee VARCHAR(50) NOT NULL,
	Sex VARCHAR(10), 
	DOB Date,
	Emp_Address VARCHAR(200),
	Phone_Number VARCHAR(10) NOT NULL,
	Email VARCHAR(100),
	ID_Work VARCHAR(10) NOT NULL REFERENCES Work(ID_Work),
	Start_Working_Day DATE NOT NULL,
	Allowance INT
);

CREATE TABLE Account(
	ID_Employee VARCHAR(10) NOT NULL REFERENCES Employee(ID_Employee),
	Username VARCHAR(50) UNIQUE NOT NULL,
	Password VARCHAR(50) NOT NULL,
);

CREATE TABLE Customer(
	ID_Customer VARCHAR(10) NOT NULL PRIMARY KEY,
	Name_Customer VARCHAR(50) NOT NULL,
	Sex VARCHAR(10),
	DOB DATE,
	PhoneNumber_Customer VARCHAR(15) NOT NULL,
	Work VARCHAR(50)
);

CREATE TABLE Gym_service_package(
	ID_Package VARCHAR(10) NOT NULL PRIMARY KEY,
	Title_Package VARCHAR(50) NOT NULL,
	Cost INT,
	Time_Package VARCHAR(10)
);

CREATE TABLE Gym_Contract(
	ID_Contract VARCHAR(10) NOT NULL PRIMARY KEY,
	Date_Enroll Date,
	Date_End Date,
	Cost INT,
	status VARCHAR(20),
	ID_Customer VARCHAR(10) NOT NULL REFERENCES Customer(ID_Customer),
	ID_Package VARCHAR(10) NOT NULL REFERENCES Gym_service_package(ID_Package)
);


CREATE TABLE Weekdays(
	ID_Weekdays VARCHAR(10) NOT NULL,
	Date_Workout DATE,
	ID_Customer VARCHAR(10) NOT NULL REFERENCES Customer(ID_Customer),
	ID_Contract VARCHAR(10) NOT NULL REFERENCES Gym_Contract(ID_Contract)
);


---------------------------------------Employee-----------------------------------------
SELECT * FROM Employee;
INSERT INTO Employee VALUES('E001','Tran Nhan Nghia','Nam','Jan 24 2000','so 40 Duong So 3 KDC Thoi Nhut 2','0939635755','nghia@gmail.com','W01','Apr 24 2021',null);
INSERT INTO Employee VALUES('E002','Huynh Anh Thu','Nu','Dec 30 2001','so 57 Duong So 1 KDC Metro','0782966311','thu001@gmail.com','W01','Apr 24 2021',null);
INSERT INTO Employee VALUES('E003','Nguyen Le Thanh Cao','Nam','May 5 2000','Nguyen Thi Minh Khai','0523294259','cao@gmail.com','W02','Apr 24 2021',100000);

---------------------------------------Work-----------------------------------------
SELECT * FROM Work;

INSERT INTO Work VALUES('W01','Quan ly',null);
INSERT INTO Work VALUES('W02','PT',8000000);
INSERT INTO Work VALUES('W03','Tap vu',5000000);
INSERT INTO Work VALUES('W04','Bao ve',4000000);

---------------------------------------Account-----------------------------------------

SELECT * FROM Account;
INSERT INTO Account VALUES('E001','nghia','nghia123');
INSERT INTO Account VALUES('E002','thu','thu123');
INSERT INTO Account VALUES('E003','cao','cao123');
INSERT INTO Account VALUES('E004','khoi','khoi123');


---------------------------------------Customer-----------------------------------------
SELECT * FROM Customer
DELETE FROM Customer
INSERT INTO Customer VALUES('C001','Lu Thi Thanh Mi','Nu','Jun 10, 2000','0914635308','Sinh vien');
INSERT INTO Customer VALUES('C002','Nguyen Van Ha','Nam','Nov 11, 2000','0838720508', 'Hoc sinh');
INSERT INTO Customer VALUES('C003','Nguyen Dinh Quy','Nam','Jul 17, 2000','0832483050', 'Cong an');
INSERT INTO Customer VALUES('C004','Le Doan Khanh','Nam','Apr 30, 2000','0379026256', 'Nhan vien van phong');

---------------------------------------Gym Service packages-----------------------------------------
SELECT * FROM Gym_service_package;

INSERT INTO Gym_service_package VALUES('GSP1','Goi ngay',30000,'1 ngay');
INSERT INTO Gym_service_package VALUES('GSP2','Goi 1 thang',270000,'1 thang');
INSERT INTO Gym_service_package VALUES('GSP3','Goi 2 thang',400000,'2 thang');
INSERT INTO Gym_service_package VALUES('GSP4','Goi 6 thang',1000000,'6 thang');
INSERT INTO Gym_service_package VALUES('GSP5','Goi 12 thang',1800000,'12 thang');
INSERT INTO Gym_service_package VALUES('GSP6','Goi PT',5000000,'1 thang');

---------------------------------------Gym Contract-----------------------------------------
DELETE Gym_Contract

SELECT * FROM Gym_Contract;
INSERT INTO Gym_Contract VALUES('HD001','2021-04-12','2021-05-12','C001','GSP2',(270000-(270000*10/100)),'Live');
INSERT INTO Gym_Contract VALUES('HD002','2021-04-10','2021-06-12','C002','GSP3',400000-(400000*10/100),'Live');
INSERT INTO Gym_Contract VALUES('HD003','2021-04-20','2021-04-20','C003','GSP1',30000,'Expire');


------------------------------------WEEKDAYS-----------------------------
SELECT * FROM Weekdays;
DROP TABLE Weekdays;

INSERT INTO Weekdays VALUES('Mon','Apr 19 2021','C002','HD002');
INSERT INTO Weekdays VALUES('Mon','Apr 19 2021','C001','HD001');
INSERT INTO Weekdays VALUES('Tue','Apr 20 2021','C003','HD003');
INSERT INTO Weekdays VALUES('Wed','Apr 21 2021','C001','HD001');
INSERT INTO Weekdays VALUES('Wed','Apr 21 2021','C002','HD001');
INSERT INTO Weekdays VALUES('Thu','Apr 22 2021','C001','HD001');
INSERT INTO Weekdays VALUES('Thu','Apr 22 2021','C002','HD002');
INSERT INTO Weekdays VALUES('Thu','Apr 22 2021','C003','HD003');
INSERT INTO Weekdays VALUES('Fri','Apr 23 2021','C002','HD002');
INSERT INTO Weekdays VALUES('Fri','Apr 23 2021','C001','HD001');
INSERT INTO Weekdays VALUES('Sat','Apr 24 2021','C003','HD003');
INSERT INTO Weekdays VALUES('Sun','Apr 25 2021','C002','HD002');

INSERT INTO Weekdays VALUES('Mon','Apr 26 2021','C002','HD002');
INSERT INTO Weekdays VALUES('Tue','Apr 27 2021','C003','HD003');
INSERT INTO Weekdays VALUES('Wed','Apr 28 2021','C001','HD001');
INSERT INTO Weekdays VALUES('Wed','Apr 28 2021','C002','HD001');
INSERT INTO Weekdays VALUES('Thu','Apr 29 2021','C001','HD001');
INSERT INTO Weekdays VALUES('Sun','2021 -05- 02','C002','HD002');

--/////////////////////////////////////////////////////////////////////////

--In Thong tin nhan vien
SELECT E.ID_Employee, E.Name_Employee,W.Title_Work,A.Username,A.Password
FROM Employee E JOIN Account A ON E.ID_Employee=A.ID_Employee
				JOIN Work W ON E.ID_Work=W.ID_Work
WHERE E.ID_Work='W01';

--In thong tin co ban cua nhan vien
SELECT E.ID_Employee,E.Name_Employee,E.Sex,E.DOB,E.Emp_Address,E.Phone_Number,E.Email,W.Title_Work,E.Start_Working_Day,E.Allowance 
FROM Employee E JOIN Work W ON E.ID_Work=W.ID_Work;

--Set ID max
SELECT MAX(ID_Employee) AS MAX_ID FROM Employee;

SELECT * FROM Employee
--Xoa nhan vien
DELETE Employee WHERE ID_Employee='E007' AND Name_Employee='rewt';

--Chinh sua thong tin
UPDATE Employee SET Name_Employee='Hoang Thien Nhi', Sex='Male',DOB='2019-02-18',Emp_Address='Thao Dien Quan 2',Phone_Number='0906627513',Email='tom@gmail',ID_Work='W02',Start_Working_Day='2021-03-30', Allowance=0 WHERE ID_Employee='E005';


--Nhap username && password -> title work
SELECT W.Title_Work
FROM Employee E JOIN Account A ON E.ID_Employee=A.ID_Employee
				JOIN Work W ON E.ID_Work=W.ID_Work
WHERE A.Username='nghia' AND A.Password='nghia123';

--Dem so luong nhan vien
SELECT COUNT(*) AS SUM_Emp FROM Employee;

--Dem so luong nhan vien theo loai cong viec
SELECT COUNT(*) AS SUM_Emp FROM Employee E JOIN Work W ON E.ID_Work=W.ID_Work WHERE W.Title_Work='Bao ve';

--Show thong tin nhan vien theo cong viec
SELECT E.ID_Employee,E.Name_Employee,E.Sex,E.DOB,E.Emp_Address,E.Phone_Number,E.Email,W.Title_Work,E.Start_Working_Day,E.Allowance 
FROM Employee E JOIN Work W ON E.ID_Work=W.ID_Work
WHERE W.Title_Work='Quan ly';

SELECT * FROM Employee WHERE ID_Employee='E001';

--Nhap username -> pass
SELECT Password FROM Account WHERE Username='nghia';

SELECT * FROM Account

--In thong tin khach hang
SELECT * FROM Customer

SELECT MAX(ID_Customer) AS MAX_ID FROM Customer;

--Xoa khach hang
DELETE Customer WHERE ID_Customer='C005' AND Name_Customer='gfds';

--Chinh sua thong tin khach hang
UPDATE Customer SET Name_Customer='Truong tieu phung', Sex='Nu',DOB='Dec 2 2000',PhoneNumber_Customer='3425432', Work='Ngan hang' WHERE ID_Customer='C007'; 

--Tim kiem thong tin khach hang qua so dien thoai
SELECT ID_Customer FROM Customer WHERE PhoneNumber_Customer='0379026256';


--In thong tin khach hang tap vao thu 2
SELECT C.Name_Customer
FROM Weekdays W JOIN Customer C ON W.ID_Customer=C.ID_Customer
WHERE ID_Weekdays='Thu 2';


--In thong tin khach dang ky goi dich vu
SELECT C.Name_Customer
FROM Gym_Contract Co JOIN Customer C ON Co.ID_Customer=C.ID_Customer
					JOIN Gym_service_package P ON Co.ID_Package=P.ID_Package
WHERE P.Title_Package='Goi 2 thang';


--Kiem tra xem khach hang nay co nhung hop dong nao
SELECT Co.ID_Contract, C.Name_Customer,P.ID_Package, P.Title_Package,Co.Date_Enroll,Co.Date_End,Co.status
FROM Gym_Contract Co JOIN Customer C ON Co.ID_Customer=C.ID_Customer
						JOIN Gym_service_package P ON Co.ID_Package=P.ID_Package
WHERE ID_Contract=(SELECT MAX(ID_Contract) FROM Gym_Contract WHERE ID_Customer='C001');


--Get the last contract's status of customer

SELECT Co.status
FROM Gym_Contract Co JOIN Customer C ON Co.ID_Customer=C.ID_Customer
						JOIN Gym_service_package P ON Co.ID_Package=P.ID_Package
WHERE ID_Contract=(SELECT MAX(ID_Contract) FROM Gym_Contract WHERE ID_Customer='C001'); 


SELECT * FROM Weekdays;


SELECT * FROM Customer

SELECT * FROM Customer WHERE ID_Customer='C001';

SELECT * FROM Gym_Contract;

SELECT MAX(ID_Contract) AS MAX_ID FROM Gym_Contract;

SELECT * FROM Gym_service_package;

SELECT ID_Package FROM Gym_service_package WHERE Title_Package='Goi 6 thang';

SELECT Cost FROM Gym_service_package WHERE Title_Package='Goi 6 thang';

SELECT Work FROM Customer WHERE ID_Customer='C001';

SELECT * FROM Weekdays ORDER BY Date_Workout ASC

--Dem So luong khach hang tap theo ngay
SELECT ID_Weekdays, COUNT(ID_Customer)
FROM Weekdays
GROUP BY ID_Weekdays;

SELECT Date_Workout,COUNT(ID_Customer) AS SoLuongKhachHang
FROM Weekdays
WHERE ID_Weekdays='Thu'
GROUP BY Date_Workout;

--Dem tong so luong khach hang tap vao ngay thu 4 hang tuan

--Tinh trung binh vao mot buoi(thu) co trung binh bao nhieu khach hang den tap
--So luong khach hang vao buoi do trong cac tuan/so luong buoi o cac tuan

SELECT COUNT(*)
From (SELECT COUNT(ID_Customer) AS TongSoLuongKhachHangVaoBuoiCacTuan
FROM Weekdays
WHERE ID_Weekdays='Thu'
GROUP BY Date_Workout);


SELECT ID_Weekdays, COUNT(ID_Customer) AS So_Luong_Khach_Hang
FROM Weekdays
GROUP BY ID_Weekdays;

SELECT * FROM Weekdays;
--Tong So luong khach hang vao thu 2 
SELECT COUNT(ID_Customer) AS So_Luong_Khach_Hang
FROM Weekdays
WHERE ID_Weekdays='Mon';

--Tong so luong ngay thu 2
SELECT MIN(Date_Workout)
FROM Weekdays
WHERE ID_Weekdays='Mon';

SELECT MAX(Date_Workout)
FROM Weekdays
WHERE ID_Weekdays='Mon';

--Dem so luong khach hang vao cac ngay trong tuan trong 1 thang 
SELECT ID_Weekdays, COUNT(ID_Customer) AS So_luong_KH
FROM Weekdays 
WHERE MONTH( Date_Workout)='5' AND YEAR( Date_Workout)='2021'
GROUP BY ID_Weekdays
ORDER BY ID_Weekdays ASC;

--Lay ngay hien tai cua khach hang C001
SELECT MAX(Date_Workout) 
FROM Weekdays
WHERE ID_Customer='C001';

--Lay ngay hien tai cua khach hang C001 co hop dong ton tai
SELECT Date_End FROM Gym_Contract WHERE ID_Contract='HD009';

UPDATE Gym_Contract SET status='Expire' WHERE ID_Contract='HD009'
UPDATE Gym_Contract SET status='Live' WHERE ID_Contract='HD009'

--Lay id hop dong gan nhat cua khach hang C001
SELECT MAX(ID_Contract) IDContract FROM Gym_Contract WHERE ID_Customer='C001';


SELECT * FROM Gym_Contract;
SELECT * FROM Weekdays;
SELECT * FROM Customer;
DELETE Weekdays WHERE Date_Workout='2021-05-19';
DELETE Gym_Contract WHERE Date_End='2021-05-19';
DELETE Gym_Contract WHERE ID_Contract='HD012';

SELECT * FROM Gym_Contract WHERE ID_Contract='C007';

--Dem tong so tien va so hop dong trong ngay
SELECT SUM(Cost) AS Tong_Tien, COUNT(*) AS Tong_So_HD FROM Gym_Contract WHERE Date_Enroll='2021-05-19';


--Dem tong so nguoi den phong
SELECT COUNT(*) AS So_Luong_Nguoi FROM Weekdays WHERE Date_Workout='2021-05-24';

--Dem tong so tien trong thang
SELECT SUM(Cost) AS Tong_Tien FROM Gym_Contract WHERE MONTH(Date_Enroll)='4' AND YEAR( Date_Enroll)='2021';

--Dem tong so tien trong nam
SELECT SUM(Cost) AS Tong_Tien FROM Gym_Contract WHERE YEAR( Date_Enroll)='2021';


SELECT *
FROM Gym_Contract 
GROUP BY MONTH(Date_Enroll)

SELECT DISTINCT MONTH(Date_Enroll) FROM Gym_Contract

--Dem so luong KH trong cach thang
SELECT COUNT(*) AS So_Luong_KH FROM Weekdays WHERE MONTH(Date_Workout)='5' AND YEAR( Date_Workout)='2021';