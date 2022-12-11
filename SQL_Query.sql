SELECT *
FROM student
WHERE name IN ('Kaan', 'Jack') OR student_id > 3
ORDER BY name DESC;