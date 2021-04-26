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
);

CREATE TABLE Gym_service_packages(
	ID_Pack VARCHAR(10) NOT NULL PRIMARY KEY,
	Title_Pack VARCHAR(50) NOT NULL,
	Cost INT,
	Time_Pack VARCHAR(10)
);

CREATE TABLE Gym_Contract(
	ID_Contract VARCHAR(10) NOT NULL PRIMARY KEY,
	Date_Enroll Date,
	Date_End Date,
	ID_Customer VARCHAR(10) NOT NULL REFERENCES Customer(ID_Customer),
	ID_Pack VARCHAR(10) NOT NULL REFERENCES Gym_service_packages(ID_Pack)
);

CREATE TABLE Weekdays(
	ID_Weekdays VARCHAR(10) NOT NULL,
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

INSERT INTO Customer VALUES('KH001','Tran Nhan Nghia','Male','Jan 24, 2000','0939635755');
INSERT INTO Customer VALUES('KH002','Nguyen Le Thanh Cao','Male','May 5, 2000','0523294259');
INSERT INTO Customer VALUES('KH003','To Huynh Minh Khoi','Male','Jul 17, 2000','0945595503');

---------------------------------------Gym Service packages-----------------------------------------
SELECT * FROM Gym_service_packages;

INSERT INTO Gym_service_packages VALUES('GSP1','Goi ngay',30000,'1 ngay');
INSERT INTO Gym_service_packages VALUES('GSP2','Goi 1 thang',270000,'1 thang');
INSERT INTO Gym_service_packages VALUES('GSP3','Goi 2 thang',400000,'2 thang');
INSERT INTO Gym_service_packages VALUES('GSP4','Goi 6 thang',1000000,'6 thang');
INSERT INTO Gym_service_packages VALUES('GSP5','Goi 12 thang',1800000,'12 thang');
INSERT INTO Gym_service_packages VALUES('GSP6','Goi PT',5000000,'1 thang');

---------------------------------------Gym Contract-----------------------------------------
SELECT * FROM Gym_Contract;
INSERT INTO Gym_Contract VALUES('HD001','2021-04-12','2021-05-12','KH001','GSP2');
INSERT INTO Gym_Contract VALUES('HD002','2021-04-10','2021-06-12','KH002','GSP3');
INSERT INTO Gym_Contract VALUES('HD003','2021-04-20','2021-04-20','KH003','GSP1');


------------------------------------WEEKDAYS-----------------------------
SELECT * FROM Weekdays;

INSERT INTO Weekdays VALUES('Thu 2','KH002','HD002');
INSERT INTO Weekdays VALUES('Thu 2','KH001','HD001');
INSERT INTO Weekdays VALUES('Thu 3','KH003','HD003');
INSERT INTO Weekdays VALUES('Thu 4','KH001','HD001');
INSERT INTO Weekdays VALUES('Thu 4','KH001','HD001');
INSERT INTO Weekdays VALUES('Thu 5','KH001','HD001');
INSERT INTO Weekdays VALUES('Thu 5','KH002','HD002');
INSERT INTO Weekdays VALUES('Thu 5','KH003','HD003');
INSERT INTO Weekdays VALUES('Thu 6','KH002','HD002');
INSERT INTO Weekdays VALUES('Thu 6','KH001','HD001');
INSERT INTO Weekdays VALUES('Thu 7','KH003','HD003');
INSERT INTO Weekdays VALUES('Thu 7','KH002','HD002');


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

--In thong tin khach hang tap vao thu 2
SELECT C.Name_Customer
FROM Weekdays W JOIN Customer C ON W.ID_Customer=C.ID_Customer
WHERE ID_Weekdays='Thu 2';


--In thong tin khach dang ky goi dich vu
SELECT C.Name_Customer
FROM Gym_Contract Co JOIN Customer C ON Co.ID_Customer=C.ID_Customer
					JOIN Gym_service_packages P ON Co.ID_Pack=P.ID_Pack
WHERE P.Title_Pack='Goi 2 thang';
