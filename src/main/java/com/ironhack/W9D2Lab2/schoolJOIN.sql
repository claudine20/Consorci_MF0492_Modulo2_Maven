drop schema if exists schoolJOIN;
create schema schoolJOIN;
use schoolJOIN;

create table teacher (
 id int primary key auto_increment,
 name varchar(100) not null
);

create table course (
	id int primary key auto_increment,
	course_name varchar(100) not null,
	hours int,
	teacher_id int,
	foreign key (teacher_id) references teacher(id)
);

INSERT INTO teacher (name) VALUES
('Ana'), ('Luis'), ('Carmen'), ('Jorge');

INSERT INTO course (course_name, hours, teacher_id) VALUES
('Matemáticas', 60, 1),   -- Ana
('Historia', 45, 2),      -- Luis
('Inglés', 30, NULL),     -- sin profesor
('Física', 70, 1);        -- Ana

--

-- Inner join (sólo coincidentes)
select c.course_name, c.hours, t.name as teacher
from course c
inner join teacher t on c.teacher_id = t.id;

-- Left join
select c.course_name, c.hours, t.name as teacher
from course c
left join teacher t on c.teacher_id = t.id;

select c.course_name, coalesce(t.name, 'Por asignar') as teacher
from course c
left join teacher t on c.teacher_id = t.id;

-- Right join
select t.name as teacher, c.course_name
from teacher t
right join course c on c.teacher_id = t.id;

select t.name as teacher, c.course_name
from teacher t
left join course c on c.teacher_id = t.id;

-- Cross join
select t.name, c.course_name
from teacher t
cross join course c;

-- Full outer join (Simulación, no existe en MySQL)
select c.course_name, t.name as teacher
from course c
left join teacher t on c.teacher_id = t.id

union

select c.course_name, t.name as teacher
from course c
right join teacher t on c.teacher_id = t.id;

-- Union
select name as person from teacher
union
select course_name from course;

-- Union all
select name as person from teacher
union all
select course_name from course;

-- Union añadiendo campos
select name as value, 'TEACHER' as source
from teacher
union
select course_name, 'COURSE'
from course;