-- ***************************************************************
-- ADVANCED JOINS DEMONSTRATION: INNER, LEFT, and RIGHT
-- ***************************************************************

-- Create a new database for this exercise
CREATE DATABASE ProjectDB;
USE ProjectDB;

-- 1. Create the main table: Projects
CREATE TABLE Projects (
    project_id INT PRIMARY KEY,
    project_name VARCHAR(100) NOT NULL,
    start_date DATE
);

-- 2. Create the child table: Tasks
-- resource_fk_id is nullable (allowing tasks to be unassigned)
CREATE TABLE Tasks (
    task_id INT PRIMARY KEY,
    project_fk_id INT, -- FK to Projects
    task_description VARCHAR(255) NOT NULL,
    due_date DATE,
    resource_fk_id INT, -- This is the crucial nullable field for join testing (FK to Resources)

    CONSTRAINT FK_TaskProject FOREIGN KEY (project_fk_id) REFERENCES Projects(project_id)
);

-- 3. Create the second child table: Resources (Personnel)
-- task_fk_id is nullable (allowing resources to be unassigned)
CREATE TABLE Resources (
    resource_id INT PRIMARY KEY,
    resource_name VARCHAR(100) NOT NULL,
    department VARCHAR(50),
    task_fk_id INT, -- This is the crucial nullable field for join testing (FK to Tasks)

    CONSTRAINT FK_ResourceTask FOREIGN KEY (task_fk_id) REFERENCES Tasks(task_id)
);

-- ***************************************************************
-- INSERT DATA WITH STRATEGIC NULL VALUES
-- ***************************************************************

-- Insert 3 Projects
INSERT INTO Projects (project_id, project_name, start_date) VALUES
(101, 'Website Redesign', '2025-01-10'),
(102, 'Database Migration', '2025-02-01'),
(103, 'Marketing Campaign', '2025-03-15');


-- Insert 5 Tasks
INSERT INTO Tasks (task_id, project_fk_id, task_description, due_date, resource_fk_id) VALUES
-- Assigned Tasks (Will work with INNER JOIN)
(1, 101, 'Design Mockups', '2025-01-20', 1), -- Assigned to Resource 1 (Tom)
(2, 102, 'Setup SQL Schema', '2025-02-15', 2), -- Assigned to Resource 2 (Sarah)
(3, 101, 'Develop Homepage', '2025-02-28', 1), -- Assigned to Resource 1 (Tom)

-- Task with NO assigned resource (NULL in FK) - Should only show up in RIGHT JOIN
(4, 103, 'Draft Ad Copy', '2025-03-25', NULL),

-- Task not yet assigned to a resource (NULL in FK) - Should only show up in RIGHT JOIN
(5, 103, 'Launch Event Planning', '2025-04-10', NULL);


-- Insert 4 Resources
INSERT INTO Resources (resource_id, resource_name, department, task_fk_id) VALUES
-- Assigned Resources (Will work with INNER JOIN)
(1, 'Tom', 'Design', 1), -- Assigned to Task 1
(2, 'Sarah', 'Engineering', 2), -- Assigned to Task 2

-- Unassigned Resource (NULL in FK) - Should only show up in LEFT JOIN
(3, 'Unassigned Analyst', 'QA', NULL),

-- Resource not linked to any task (NULL in FK) - Should only show up in LEFT JOIN
(4, 'David', 'Sales', NULL);


-- ***************************************************************
-- 1. INNER JOIN (Matchmaker: Only returns rows with matches in BOTH tables)
-- ***************************************************************
SELECT
    T.task_description,
    R.resource_name,
    P.project_name
FROM Tasks T
INNER JOIN Resources R ON T.resource_fk_id = R.resource_id
INNER JOIN Projects P ON T.project_fk_id = P.project_id
ORDER BY P.project_name, T.task_id;



-- ***************************************************************
-- 2. LEFT JOIN (Resource-Centric: Returns ALL rows from the LEFT table)
-- ***************************************************************
SELECT
    R.resource_name,
    R.department,
    T.task_description -- NULL where resource is unassigned
FROM Resources R -- LEFT Table
LEFT JOIN Tasks T ON R.resource_id = T.resource_fk_id
ORDER BY R.resource_id;



-- ***************************************************************
-- 3. RIGHT JOIN (Task-Centric: Returns ALL rows from the RIGHT table)
-- ***************************************************************
SELECT
    T.task_description,
    T.due_date,
    R.resource_name -- NULL where task is unassigned
FROM Resources R -- LEFT Table (but the RIGHT table drives the result)
RIGHT JOIN Tasks T ON R.resource_id = T.resource_fk_id
ORDER BY T.task_id;
