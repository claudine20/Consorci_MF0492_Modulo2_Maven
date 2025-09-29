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

-- Crear vistas a partir de consultas

create view vista_cursos_profesores as
select c.course_name, c.hours, t.name as teacher
from course c
left join teacher t on c.teacher_id = t.id;

-- Mostrar sólo los cursos con más de 50 horas
create view v_cursos_largos as
select course_name, hours
from course
where hours > 50;

-- Número de cursos por profesor
create view v_num_cursos_profesor as
select t.name, count(c.id) as total_courses
from teacher t
left join course c on t.id = c.teacher_id
group by t.name;

-- Actualizar vista
create or replace view v_cursos_largos as
select id, course_name, hours
from course
where hours > 30;

-- Eliminar vistas
drop view v_cursos_largos;

-- ---------------------------------------------------------------

-- Crear tablas a partir de consultas

create table nueva_tabla as
select ...
from tabla_existente
where ...;

create table big_courses as
select course_name, hours, teacher_id
from course
where hours > 30;

create table big_courses_struct as
select id, course_name, hours, teacher_id
from course
where 1=0;

create temporary table t_high_hours as
select * from course where hours > 30;