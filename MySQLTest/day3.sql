SELECT employee_id,job_id,last_name
FROM employees
ORDER BY department_id DESC, salary ASC;

SELECT job_id
FROM employees
WHERE job_id LIKE '%a%e%';

SELECT last_name,department_name,l.location_id,city
FROM employees e,departments d,locations l
WHERE e.`department_id` = d.`department_id`
AND d.`location_id` = l.`location_id`
AND commission_pct IS NOT NULL;

SELECT last_name,job_id,d.department_id,department_name
FROM employees e,departments d,locations l
WHERE e.`department_id` = d.`department_id`
AND d.`location_id` = l.`location_id`
AND city='Toronto';

SELECT department_name,job_title,MIN(salary)
FROM departments d,employees e,jobs j
WHERE d.`department_id` = e.`department_id`
AND e.`job_id` = j.`job_id`
GROUP BY j.job_id,d.department_id;

SELECT country_id,COUNT(*)
FROM locations l,departments d
WHERE l.`location_id` = d.`location_id`
GROUP BY country_id
HAVING COUNT(*)>2;

SELECT e.last_name employees,e.employee_id "Emp#",m.last_name manager,m.employee_id "Mgr#"
FROM employees e,employees m
WHERE m.manager_id = e.employee_id;

#二、SQL99语法
/*
语法：
	select 查询列表
	from 表1 别名【连接类型】
	join 表2 别名
	on 连接条件
	【where 筛选条件】
	【group by 分组】
	【having 筛选条件】
	【order by 排序列表】
	
分类：
内连接：inner
	inner可省略
外连接
	左外：left【outer】
	右外：right【outer】
	全外：full【outer】
交叉连接：cross
*/

#1. 内连接
#等值连接
SELECT last_name,job_title
FROM employees e
INNER JOIN jobs j
ON e.`job_id` = j.`job_id`
WHERE e.`last_name` LIKE '%e%';

SELECT city,COUNT(*)
FROM departments d
INNER JOIN locations l
ON d.`location_id`=l.`location_id`
GROUP BY city
HAVING COUNT(*)>=2;

SELECT COUNT(*),department_name
FROM employees e
INNER JOIN departments d
ON e.`department_id` = d.`department_id`
GROUP BY department_name
HAVING COUNT(*)>3
ORDER BY COUNT(*) DESC;

SELECT last_name,department_name,job_title
FROM employees e
INNER JOIN departments d ON e.`department_id`=d.`department_id`
INNER JOIN jobs j ON e.`job_id`=j.`job_id`
ORDER BY department_name DESC;

#非等值连接
SELECT last_name,salary,grade_level
FROM employees e
JOIN job_grades j
ON e.`salary` BETWEEN j.`lowest_sal` AND j.`highest_sal`;

#查询每个工资等级中的员工个数，并降序
SELECT COUNT(*),grade_level
FROM employees e
JOIN job_grades j
ON e.`salary` BETWEEN j.`lowest_sal` AND j.`highest_sal`
GROUP BY grade_level
HAVING COUNT(*)>20
ORDER BY grade_level DESC;

#自连接
SELECT e.last_name,m.last_name
FROM employees e
JOIN employees m
ON e.`manager_id`=m.`employee_id`;

#2. 外连接
/*
应用场景：用于查询一个表中有，另一个表中没有的记录

特点：
1. 外连接的查询结果为主表中的所有记录
	如果从表中有匹配记录，则显示匹配的值
	如果从表中没有匹配记录，则显示为null
	外连接查询结果=内连接查询结果+主表中有而从表中没有的记录
2. 左外连接：left join 左边的为主表
   右外连接：right join右边的是主表
3. 全外连接：两个表中的内容取并集
*/

#左外连接
SELECT b.name
FROM beauty b
LEFT OUTER JOIN boys bo
ON b.`boyfriend_id`=bo.`id`
WHERE bo.`id` IS NOT NULL;

#右外连接
SELECT b.name
FROM boys bo
RIGHT OUTER JOIN beauty b
ON b.`boyfriend_id`=bo.`id`
WHERE bo.`id` IS NOT NULL;

#交叉连接
SELECT b.*,bo.*
FROM beauty b
CROSS JOIN boys bo;

#查询哪个城市没有部门
SELECT city,d.*
FROM locations l
LEFT JOIN departments d
ON l.`location_id`=d.`location_id`
WHERE d.`department_id` IS NULL;