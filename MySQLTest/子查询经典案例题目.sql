#1. 查询工资最低的员工信息：last_name，salary
SELECT last_name,salary
FROM employees
WHERE salary=(
	SELECT MIN(salary)
	FROM employees
);
#2. 查询平均工资最低的部门信息
#方式一：
#1)各部门的平均工资
SELECT AVG(salary),department_id
FROM employees e
GROUP BY department_id
#2)查询1)结果的最低平均工资
SELECT MIN(avg_sal)
FROM (
	SELECT AVG(salary) avg_sal,department_id
	FROM employees e
	GROUP BY department_id
) avg_dep
#3)查询2)结果对应的部门编号
SELECT AVG(salary),department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary)=(
	SELECT MIN(avg_sal)
	FROM (
		SELECT AVG(salary) avg_sal,department_id
		FROM employees e
		GROUP BY department_id
	) avg_dep
)
#4)查询部门信息
SELECT d.*
FROM departments d
WHERE d.department_id=(
	SELECT department_id
	FROM employees
	GROUP BY department_id
	HAVING AVG(salary)=(
		SELECT MIN(avg_sal)
		FROM (
			SELECT AVG(salary) avg_sal,department_id
			FROM employees e
			GROUP BY department_id
		) avg_dep
	)
)

#方式二：
#1)各部门的平均工资
SELECT AVG(salary),department_id
FROM employees e
GROUP BY department_id
#2)通过排序获取平均工资最低的部门id
SELECT department_id
FROM employees e
GROUP BY department_id
ORDER BY AVG(salary) ASC
LIMIT 1
#3)查询部门信息
SELECT *
FROM departments
WHERE department_id=(
	SELECT department_id
	FROM employees e
	GROUP BY department_id
	ORDER BY AVG(salary) ASC
	LIMIT 1
)

#3. 查询平均工资最低的部门信息和该部门的平均工资
#1)各部门的平均工资
SELECT AVG(salary),department_id
FROM employees e
GROUP BY department_id
#2)通过排序获取平均工资最低的平均工资和部门id
SELECT AVG(salary),department_id
FROM employees e
GROUP BY department_id
ORDER BY AVG(salary) ASC
LIMIT 1
#3)
SELECT d.*,avg_dep.avg_sal
FROM departments d
INNER JOIN (
	SELECT AVG(salary) avg_sal,department_id
	FROM employees e
	GROUP BY department_id
	ORDER BY AVG(salary) ASC
	LIMIT 1
) avg_dep
ON d.department_id=avg_dep.department_id

#4. 查询平均工资最高的 job 信息
#1)
SELECT AVG(salary),job_id
FROM employees
GROUP BY job_id
#2)
SELECT AVG(salary),job_id
FROM employees
GROUP BY job_id
ORDER BY AVG(salary) DESC
LIMIT 1
#3)
SELECT *
FROM jobs
WHERE job_id=(
	SELECT job_id
	FROM employees
	GROUP BY job_id
	ORDER BY AVG(salary) DESC
	LIMIT 1
);

SELECT j.*
FROM jobs j
INNER JOIN (
	SELECT AVG(salary),job_id
	FROM employees
	GROUP BY job_id
	ORDER BY AVG(salary) DESC
	LIMIT 1
) avg_job
ON j.job_id=avg_job.job_id;

#5. 查询平均工资高于公司平均工资的部门有哪些
#1)
SELECT AVG(salary),department_id
FROM employees
GROUP BY department_id
#2)
SELECT AVG(salary)
FROM employees
#3)
SELECT department_id
FROM employees
GROUP BY department_id
HAVING AVG(salary)>(
	SELECT AVG(salary)
	FROM employees
)

#6. 查询出公司中所有manager的详细信息
#1)
SELECT DISTINCT manager_id
FROM employees
WHERE manager_id IS NOT NULL
#2)
SELECT *
FROM employees
WHERE employee_id IN(
	SELECT DISTINCT manager_id
	FROM employees
	WHERE manager_id IS NOT NULL
)

#7. 各个部门中，最高工资中最低的那个部门，最低工资是多少
#1)
SELECT MAX(salary),department_id
FROM employees
GROUP BY department_id
#2)
SELECT MAX(salary),department_id
FROM employees
GROUP BY department_id
ORDER BY MAX(salary) ASC
LIMIT 1
#3)
SELECT MIN(salary)
FROM employees
WHERE department_id=(
	SELECT department_id
	FROM employees
	GROUP BY department_id
	ORDER BY MAX(salary) ASC
	LIMIT 1
)

#8. 查询平均工资最高的部门的manager的详细信息：last_name，department_id，email，salary
#1)各部门的平均工资
SELECT AVG(salary),department_id
FROM employees e
GROUP BY department_id
#2)通过排序获取平均工资最高的部门id
SELECT department_id
FROM employees e
GROUP BY department_id
ORDER BY AVG(salary) DESC
LIMIT 1
#3)获取平均工资最高的部门的manager_id
SELECT DISTINCT manager_id
FROM employees
WHERE department_id=(
	SELECT department_id
	FROM employees e
	GROUP BY department_id
	ORDER BY AVG(salary) DESC
	LIMIT 1
) AND manager_id IS NOT NULL
#4)获取该manager_id的详细信息
SELECT last_name,department_id,email,salary
FROM employees
WHERE employee_id=(
	SELECT DISTINCT manager_id
	FROM employees
	WHERE department_id=(
		SELECT department_id
		FROM employees e
		GROUP BY department_id
		ORDER BY AVG(salary) DESC
		LIMIT 1
	) AND manager_id IS NOT NULL
)

SELECT last_name,d.department_id,email,salary
FROM employees e
JOIN departments d ON e.employee_id=d.manager_id
WHERE d.department_id=(
	SELECT department_id
	FROM employees e
	GROUP BY department_id
	ORDER BY AVG(salary) DESC
	LIMIT 1
)