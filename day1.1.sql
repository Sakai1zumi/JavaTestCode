#进阶1：基础查询
USE myemployees;

SELECT last_name FROM employees;

SELECT email,phone_number FROM employees;

SELECT 
  `first_name`,
  `last_name`,
  `email`,
  `phone_number`,
  `job_id`,
  `salary` 
FROM
  employees 
  
SELECT * FROM employees;

SELECT 100;
SELECT 'john';

SELECT 100%98;

SELECT VERSION();

SELECT 100%98 AS 结果;

SELECT last_name AS 姓,first_name AS 名 FROM employees;

SELECT last_name 姓,first_name 名 FROM employees;

SELECT salary AS "Out put" FROM employees;

#去重
#例子：去除重复的部门编号
SELECT department_id FROM employees;

SELECT DISTINCT department_id FROM employees;

#+号的作用：有且仅有一个功能--运算符
SELECT 100+90;
SELECT '123'+90;#将字符转换为数值
SELECT 'john'+90;#转换不成功则转换成0
SELECT NULL+90;

SELECT 
  CONCAT('a', 'b', 'c') AS 结果 ;
  
SELECT 
  CONCAT(last_name, first_name) AS 姓名 
FROM
  employees ;
#null与任何值相连接都是null

#显示表departments的结构，并查询其中的全部数据
DESC departments;
SELECT * FROM departments;

#显示表employees的全部列，用逗号连接，列头显示为out_put
SELECT 
  CONCAT(
    `first_name`,
    ',',
    `last_name`,
    ',',
    `email`,
    ',',
    `phone_number`,
    ',',
    `salary`,
    ','
  ) AS out_put 
FROM
  employees ;
  
SELECT 
  IFNULL(commission_pct, 0) AS 奖金率,
  commission_pct
FROM
  employees ;
  
SELECT 
  CONCAT(
    `first_name`,
    ',',
    `last_name`,
    ',',
    `email`,
    ',',
    `phone_number`,
    ',',
    `salary`,
    ',',
    IFNULL(commission_pct,0)
  ) AS out_put 
FROM
  employees ;

