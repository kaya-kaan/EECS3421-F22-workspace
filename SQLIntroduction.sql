DROP TABLE student;

create table student (
student_id INT auto_increment,
name VARCHAR(20) NOT NULL,
major VARCHAR(20) DEFAULT 'Undecided',
primary key(student_id)
);
describe student;

/*DROP TABLE student;

ALTER table student add gpa DECIMAL(3, 2);

ALTER table student drop column gpa; */

SELECT * FROM student;

INSERT INTO student(name, major) VALUES('Kaan', 'Computer Science');
INSERT INTO student(name, major) VALUES('Miray', 'Arts');
INSERT INTO student(student_id, name) VALUES(3, 'Hakan');
INSERT INTO student(name) VALUES('Yesim');
INSERT INTO student(name) VALUES('Jack');
INSERT INTO student(name) VALUES('Julia');
INSERT INTO student(name) VALUES('Bob');

UPDATE student
SET major = 'CS'
WHERE major = 'Computer Science' OR name = 'Hakan';

DELETE FROM student
WHERE student_id = 7;



