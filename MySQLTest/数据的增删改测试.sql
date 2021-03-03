CREATE TABLE my_employees(
Id INT(10),
First_name VARCHAR(10),
Last_name VARCHAR(10),
Userid VARCHAR(10),
Salary DOUBLE(10,2)
);
CREATE TABLE users(
id INT,
userid VARCHAR(10),
department_id INT
);

#向my_employees表中插入下列数据
INSERT INTO my_employees
VALUES(1,'patel','Ralph','Rpatel',895),
(2,'Dancs','Betty','Bdancs',860),
(3,'Biri','Ben','Bbiri',1100),
(4,'Newman','Chad','Cnewman',750),
(5,'Ropeburn','Audrey','Aropebur',1550);

#向users表中插入数据
INSERT INTO Users
VALUES (1,'Ralph',10),
(2,'Bdancs',10),
(3,'Bbiri',20),
(4,'Cnewman',30),
(NULL,NULL,NULL),
(5,'Aropebur',40);

#将3号员工的last_name修改为“drelxer”
UPDATE my_employees SET last_name='drelxer' WHERE id=3;

#将所有工资少于900的员工的工资修改为1000
UPDATE my_employees SET salary=1000 WHERE salary<900;

#将userid 为Bbiri的user表和my_employees表的记录全部删除
DELETE u,e
FROM users u
INNER JOIN my_employees e
ON u.`userid`=e.`Userid`
WHERE e.`Userid`='Bbiri';

#删除所有数据
DELETE FROM my_employees;
DELETE FROM users;

#清空表my_employees
TRUNCATE TABLE my_employees;



