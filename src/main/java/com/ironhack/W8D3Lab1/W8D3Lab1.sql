-- Create Database
CREATE DATABASE IF NOT EXISTS empleadoss_departamentoss CHARACTER SET utf8 COLLATE utf8_bin;
USE empleadoss_departamentoss;


---
## 1. Create Parent Table: empleados

-- empleados is created first because departamentos references it (via codDirector).
DROP TABLE IF EXISTS empleados;
CREATE TABLE empleados (
  nDIEmp varchar(12) COLLATE utf8_bin NOT NULL,
  nomEmp varchar(30) COLLATE utf8_bin NOT NULL,
  sexEmp char(1) COLLATE utf8_bin NOT NULL,
  fecNac date NOT NULL,
  fecIncorporacion date NOT NULL,
  salEmp float NOT NULL,
  comisionE float NOT NULL,
  cargoE varchar(15) COLLATE utf8_bin NOT NULL,
  jefeID varchar(12) COLLATE utf8_bin DEFAULT NULL,
  codDepto varchar(4) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (nDIEmp),
  KEY FK_Empl (jefeID),
  KEY FK_Dpto (codDepto),
  -- Self-referencing foreign key: jefeID references nDIEmp
  CONSTRAINT FK_Empl FOREIGN KEY (jefeID) REFERENCES empleados (nDIEmp)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

---
## 2. Create Child Table: departamentos

-- departamentos is created second. It references empleados.
-- The foreign key to empleados (FK_Dpto) is omitted here and added later to break the circular dependency.
DROP TABLE IF EXISTS departamentos;
CREATE TABLE departamentos (
  codDepto varchar(4) COLLATE utf8_bin NOT NULL,
  nombreDpto varchar(20) COLLATE utf8_bin NOT NULL,
  ciudad varchar(15) COLLATE utf8_bin DEFAULT NULL,
  codDirector varchar(12) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (codDepto),
  KEY FK_EmpDir (codDirector),
  -- Foreign key: codDirector references nDIEmp in empleados
  CONSTRAINT FK_EmpDir FOREIGN KEY (codDirector) REFERENCES empleados (nDIEmp)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

---

## 3. Add Final Foreign Key Constraint

-- This resolves the circular dependency: empleados references departamentos (codDepto).
ALTER TABLE empleados
ADD CONSTRAINT FK_Dpto FOREIGN KEY (codDepto) REFERENCES departamentos (codDepto);
---


---
## 4. Dump Data for empleados (PARENT DATA)

-- Temporarily disable foreign key checks to allow self-referencing inserts to pass.
SET FOREIGN_KEY_CHECKS = 0;

-- LOCK TABLES empleados WRITE;
/*!40000 ALTER TABLE empleados DISABLE KEYS */;
INSERT INTO empleados VALUES ('1.130.222','José Giraldo','M','1985-01-20','2000-11-01',1200000,400000,'Asesor','22.222.222','3500');
INSERT INTO empleados VALUES ('1.130.333','Pedro Blanco','M','1987-10-28','2000-10-01',800000,3000000,'Vendedor','31.178.144','2000');
INSERT INTO empleados VALUES ('1.130.444','Jesús Alfonso','M','1988-03-14','2000-10-01',800000,3500000,'Vendedor','31.178.144','2000');
INSERT INTO empleados VALUES ('1.130.555','Julián Mora','M','1989-07-03','2000-10-01',800000,3100000,'Vendedor','31.178.144','2200');
INSERT INTO empleados VALUES ('1.130.666','Manuel Millán','M','1990-12-08','2004-06-01',800000,3700000,'Vendedor','31.178.144','2300');
INSERT INTO empleados VALUES ('1.130.777','Marcos Cortez','M','1986-06-23','2000-04-16',2550000,500000,'Mecánico','333.333.333','4000');
INSERT INTO empleados VALUES ('1.130.782','Antonio Gil','M','1980-01-23','2010-04-16',850000,1500000,'Técnico','16.211.383','1500');
INSERT INTO empleados VALUES ('1.751.219','Melissa Roa','F','1960-06-19','2001-03-16',2250000,2500000,'Vendedor','31.178.144','2100');
INSERT INTO empleados VALUES ('11.111.111','Irene Díaz','F','1979-09-28','2004-06-01',1050000,200000,'Mecánico','333.333.333','4200');
INSERT INTO empleados VALUES ('16.211.383','Luis Pérez','M','1956-02-25','2000-01-01',5050000,0,'Director','31.840.269','1500');
INSERT INTO empleados VALUES ('16.759.060','Darío Casas','M','1960-04-05','1992-11-01',4500000,500000,'Investigador','31.840.269','3000');
INSERT INTO empleados VALUES ('19.709.802','William Daza','M','1982-10-09','1999-12-16',2250000,1000000,'Investigador','16.759.060','3000');
INSERT INTO empleados VALUES ('22.222.222','Carla López','F','1975-05-11','2005-07-16',4500000,500000,'Jefe Mercadeo','31.840.269','3500');
INSERT INTO empleados VALUES ('22.222.333','Carlos Rozo','M','1975-05-11','2001-09-16',750000,500000,'Vigilante','31.840.269','3500');
INSERT INTO empleados VALUES ('31.174.099','Diana Solarte','F','1957-11-19','1990-05-16',1250000,500000,'Secretaria','31.840.269','1000');
INSERT INTO empleados VALUES ('31.178.144','Rosa Angulo','F','1957-03-15','1998-08-16',3250000,3500000,'Jefe Ventas','31.840.269','2000');
INSERT INTO empleados VALUES ('31.840.269','María Rojas','F','1959-01-15','1990-05-16',6250000,1500000,'Gerente',NULL,'1000');
INSERT INTO empleados VALUES ('333.333.333','Elisa Rojas','F','1979-09-28','2004-06-01',3000000,1000000,'Jefe Mecánicos','31.840.269','4000');
INSERT INTO empleados VALUES ('333.333.334','Marisol Pulido','F','1979-10-01','1990-05-16',3250000,1000000,'Investigador','16.759.060','3000');
INSERT INTO empleados VALUES ('333.333.335','Ana Moreno','F','1992-01-05','2004-06-01',1200000,400000,'Secretaria','16.759.060','3000');
INSERT INTO empleados VALUES ('333.333.336','Carolina Ríos','F','1992-02-15','2000-10-01',1250000,500000,'Secretaria','16.211.383','1500');
INSERT INTO empleados VALUES ('333.333.337','Edith Muñoz','F','1992-03-31','2000-10-01',800000,3600000,'Vendedor','31.178.144','2100');
INSERT INTO empleados VALUES ('444.444','Abel Gómez','M','1939-12-24','2000-10-01',1050000,200000,'Mecánico','333.333.333','4300');
INSERT INTO empleados VALUES ('737.689','Mario Llano','M','1945-08-30','1990-05-16',2250000,2500000,'Vendedor','31.178.144','2300');
INSERT INTO empleados VALUES ('768.782','Joaquín Rosas','M','1947-07-07','1990-05-16',2250000,2500000,'Vendedor','31.178.144','2200');
INSERT INTO empleados VALUES ('888.888','Iván Duarte','M','1955-08-12','1998-05-16',1050000,200000,'Mecánico','333.333.333','4100');
/*!40000 ALTER TABLE empleados ENABLE KEYS */;
-- UNLOCK TABLES;

-- Re-enable foreign key checks immediately after the table data dump.
SET FOREIGN_KEY_CHECKS = 1;



---
## 5. Dump Data for departamentos (CHILD DATA)

-- MUST be executed second, as the director IDs must exist in the empleados table.
-- LOCK TABLES departamentos WRITE;
/*!40000 ALTER TABLE departamentos DISABLE KEYS */;
INSERT INTO departamentos VALUES ('1000','GERENCIA','CIUDAD REAL','31.840.269');
INSERT INTO departamentos VALUES ('1500','PRODUCCIÓN','CIUDAD REAL','16.211.383');
INSERT INTO departamentos VALUES ('2000','VENTAS','CIUDAD REAL','31.178.144');
INSERT INTO departamentos VALUES ('2100','VENTAS','BARCELONA','16.211.383');
INSERT INTO departamentos VALUES ('2200','VENTAS','VALENCIA','16.211.383');
INSERT INTO departamentos VALUES ('2300','VENTAS','MADRID','16.759.060');
INSERT INTO departamentos VALUES ('3000','INVESTIGACIÓN','CIUDAD REAL','16.759.060');
INSERT INTO departamentos VALUES ('3500','MERCADEO','CIUDAD REAL','22.222.222');
INSERT INTO departamentos VALUES ('4000','MANTENIMIENTO','CIUDAD REAL','333.333.333');
INSERT INTO departamentos VALUES ('4100','MANTENIMIENTO','BARCELONA','16.759.060');
INSERT INTO departamentos VALUES ('4200','MANTENIMIENTO','VALENCIA','16.759.060');
INSERT INTO departamentos VALUES ('4300','MANTENIMIENTO','MADRID','16.759.060');
/*!40000 ALTER TABLE departamentos ENABLE KEYS */;
-- UNLOCK TABLES;


---
## PART 2: QUERIES 
--

-- 1. Obtener los datos completos de los empleados.
select * 
from empleados;

-- 2. Obtener los datos completos de los departamentos.
select * 
from departamentos;

-- 3. Obtener los datos de los empleados con cargo ‘Secretaria’.
select * 
from empleados 
where lower(cargoE)='secretaria';

-- 4. Obtener el nombre y salario de los empleados.
select nomemp, salemp 
from empleados;

-- 5. Obtener los datos de los empleados vendedores, ordenado por nombre.
select * 
from empleados 
where lower(cargoE)='vendedor' 
order by nomEmp asc;

-- 6. Listar el nombre de los departamentos.
select distinct nombreDPto 
from departamentos;

-- 7. Obtener el nombre y cargo de todos los empleados, ordenado por salario.

select nomEmp, cargoE, salemp 
from empleados 
order by salemp;

-- 8. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión.
select salemp, comisione 
from empleados 
order by comisionE;

-- 9. Listar todas las comisiones.
select distinct comisione 
from empleados;

-- 10. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una bonificación de 500.000, en orden alfabético del empleado
select nomemp, salemp, (salemp+500000) as 'pago estimado'
from empleados 
where codDepto = '3000' 
order by nomemp;

-- 11. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
select nomemp,salemp,comisione 
from empleados
where comisionE > salEmp;

-- 12. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo
select nomemp,salemp,comisione 
from empleados
where comisionE <= (salEmp*0.3);

-- 13.Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo para cada empleado.
select nomemp as 'Nombre', cargoe as 'Cargo' 
from empleados;

-- 14. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad es superior al ‘19.709.802’.
select nDIEmp,salemp,comisione 
from empleados
where nDIEmp > '19.709.802';

-- 15. Muestra los empleados cuyo nombre empiece entre las letras J y Z (rango). Liste estos empleados y su cargo por orden alfabético.
select nomemp, cargoe
from empleados
where lower(nomemp) > 'j' and lower(nomemp) < 'z'
order by nomemp;

-- 16. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del empleado y nombre, de aquellos empleados que tienen comisión superior a 1.000.000, ordenar el informe por el número del documento de identidad
select salemp,
            comisione,
            (salemp + comisione) as 'Salario total', 
            ndiemp
from empleados
where comisione > 1000000
order by ndiemp;

-- 17. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión
select salemp,
            comisione,
            (salemp + comisione) as 'Salario total',
            ndiemp 
from empleados 
where comisione = 0 
order by ndiemp;

-- 18. Hallar los empleados cuyo nombre no contiene la cadena «MA»
select nomEmp 
from empleados 
where lower(nomEmp) not like '%ma%';

-- 24. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado entre la mitad de la comisión la propia comisión.
select nomEmp, salEmp, comisionE 
from empleados 
where salEmp between (comisionE/2) and comisionE;

-- 25. Mostrar el salario más alto de la empresa.
select nomEmp,salEmp AS 'Salario mayor'
from empleados
WHERE salEmp = (SELECT MAX(salEmp) FROM empleados);

-- 27. Mostrar el nombre del último empleado de la lista por orden alfabético.
select max(nomemp) as 'Mayor alfabeticamente' 
from empleados;


-- 28. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
select max(salemp) as 'Salario mayor', min(salemp) as 'Salario menor', max(salemp) - min(salemp) as 'Diferencia' 
from empleados;

-- 31. Mostrar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa. Ordenarlo por departamento.
select nDIEmp, salEmp 
from empleados 
where salemp >= (select avg(salemp) from empleados);