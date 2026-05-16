# Write your MySQL query statement below
SELECT e.name AS Employee
FROM Employee e
INNER JOIN Employee m
ON m.id = e.managerId
where e.salary > m.salary;