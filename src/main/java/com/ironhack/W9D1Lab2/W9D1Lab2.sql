-- ***************************************************************
-- PART 1: AGGREGATE QUERIES, GROUP BY, HAVING, LIKE, and NULL
-- ***************************************************************

-- Drop the database if it exists to ensure we start fresh
DROP DATABASE IF EXISTS EmployeeDataDB;
-- Create a new database to demonstrate aggregates
CREATE DATABASE EmployeeDataDB;
USE EmployeeDataDB;

-- Create the Employees table
CREATE TABLE Employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    department VARCHAR(50),
    job_title VARCHAR(50),
    salary DECIMAL(10, 2),
    hire_year YEAR,
    commission_pct DECIMAL(3, 2) -- Field for NULL and LIKE checks
);

-- Insert sample data
INSERT INTO Employees (first_name, last_name, department, job_title, salary, hire_year, commission_pct) VALUES
('Alex', 'Smith', 'Sales', 'Manager', 95000.00, 2021, 0.15),
('Bella', 'Jones', 'Sales', 'Rep', 62000.00, 2023, 0.10),
('Carlos', 'Vega', 'Sales', 'Rep', 58000.00, 2024, 0.10),
('Diana', 'Prince', 'Marketing', 'Specialist', 70000.00, 2022, 0.05),
('Ethan', 'Hunt', 'Marketing', 'Manager', 105000.00, 2021, NULL),
('Fiona', 'Gala', 'Marketing', 'Analyst', 68000.00, 2023, 0.05),
('George', 'Martin', 'R&D', 'Engineer', 85000.00, 2022, NULL),
('Hannah', 'Montana', 'R&D', 'Engineer', 88000.00, 2023, NULL),
('Ivy', 'Manderly', 'Sales', 'Rep', 64000.00, 2023, 0.10);


-- 1. Query using COUNT and GROUP BY
SELECT
    department, -- Show the department
    COUNT(employee_id) AS Total_Employees -- Count the number of employees in each group
FROM Employees
GROUP BY department -- Group the results by the 'department' column
ORDER BY Total_Employees DESC; -- Order the groups by the employee count, descending

-- 2. Query using SUM, AVG, GROUP BY, and HAVING
SELECT
    job_title, -- Show the job title
    SUM(salary) AS Total_Salary_Paid, -- Calculate the sum of salaries for the group
    AVG(salary) AS Avg_Salary -- Calculate the average salary for the group
FROM Employees
WHERE hire_year < 2024 -- WHERE filters rows *before* they are grouped
GROUP BY job_title -- Group the results by 'job_title'
HAVING COUNT(employee_id) > 1 -- HAVING filters the *groups* (only show job titles with more than 1 employee hired before 2024)
ORDER BY Avg_Salary DESC; -- Order the final result by the calculated average salary

-- 3. Query using LIKE and checking for NULL
SELECT
    first_name,
    last_name,
    job_title,
    commission_pct -- Show commission status
FROM Employees
WHERE job_title LIKE '%Rep%' -- Use LIKE to find all job titles containing 'Rep' (Represents the 'like' operator)
OR commission_pct IS NULL -- Use IS NULL to find records where commission_pct is empty (Represents the 'null' value check)
ORDER BY first_name ASC; -- Order the result alphabetically by first name

-- ***************************************************************
-- PART 2: RELATING TWO TABLES 1:1 (Using the existing PodcastDB)
-- ***************************************************************

-- Switch to the existing Podcast database
-- NOTE: This assumes PodcastDB has already been created and populated with the Downloads table.
USE PodcastDB;

-- 1. Create the new "OrderDetails" table
CREATE TABLE OrderDetails (
    -- This FK also serves as the PRIMARY KEY, enforcing the 1:1 relationship.
    download_fk_id INT PRIMARY KEY, 
    -- Additional detail fields
    file_size_mb DECIMAL(5, 2) NOT NULL,
    file_format VARCHAR(10) NOT NULL,
    download_link VARCHAR(255),
    order_status VARCHAR(20) DEFAULT 'COMPLETE',
    
    -- Define the 1:1 relationship (FK to Downloads table)
    CONSTRAINT FK_DownloadDetail FOREIGN KEY (download_fk_id) 
        REFERENCES Downloads(download_id)
        -- Prevents a download record from being deleted if details exist
        ON DELETE RESTRICT 
);

-- 2. Insert records into OrderDetails (Must use IDs that exist in the Downloads table!)
-- (Using the download_id values 1, 3, 5 from the previous exercise)
INSERT INTO OrderDetails (download_fk_id, file_size_mb, file_format, download_link) VALUES
(1, 45.30, 'MP3', 'http://link.to/sql-secrets'),
(3, 30.15, 'WAV', 'http://link.to/history-joins'),
(5, 60.40, 'MP3', 'http://link.to/tech-nerd-sql');


-- 3. Query demonstrating the 1:1 join
-- Retrieve the user, the podcast, the download time, and the specific file details
SELECT
    U.username AS Client, -- User name from Users table
    P.title AS Podcast_Title, -- Podcast title from Podcasts table
    D.download_time AS Time_Stamp, -- Event time from Downloads table
    OD.file_size_mb, -- File size from OrderDetails (1:1 linked)
    OD.file_format -- File format from OrderDetails (1:1 linked)
FROM Downloads D
-- Join 1: To Users (getting client name)
INNER JOIN Users U ON D.user_fk_id = U.user_id
-- Join 2: To Podcasts (getting podcast title)
INNER JOIN Podcasts P ON D.podcast_fk_id = P.podcast_id
-- Join 3: To OrderDetails (getting the 1:1 details)
INNER JOIN OrderDetails OD ON D.download_id = OD.download_fk_id
ORDER BY U.username;
