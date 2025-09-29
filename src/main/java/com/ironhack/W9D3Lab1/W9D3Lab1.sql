-- ***************************************************************
-- ONE-TO-MANY (1:N) RELATIONSHIP: Dealerships and Cars
-- ***************************************************************
-- Create a new database for this project
CREATE DATABASE DealershipsDB;
-- Set the current database context
USE DealershipsDB;

-- 1. Create the PARENT table: Dealerships (The "One" side)
CREATE TABLE Dealerships (
    dealership_id INT PRIMARY KEY AUTO_INCREMENT, -- Primary Key, auto-incrementing
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL
);

-- 2. Create the CHILD table: Cars (The "Many" side)
CREATE TABLE Cars (
    car_id INT PRIMARY KEY AUTO_INCREMENT,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    year YEAR,
    price DECIMAL(10, 2),
    -- Foreign Key column that links to the Dealerships table
    dealership_fk_id INT,

    -- Define the Foreign Key constraint
    CONSTRAINT FK_CarDealership
    FOREIGN KEY (dealership_fk_id)
    REFERENCES Dealerships(dealership_id)
);


-- ***************************************************************
-- INSERT DATA
-- ***************************************************************

-- Insert 5 Dealerships
INSERT INTO Dealerships (dealership_id, name, city) VALUES
(1001, 'Velocity Motors', 'Miami'),
(1002, 'Bay Area Imports', 'San Francisco'),
(1003, 'Mountain View Auto', 'Denver'),
(1004, 'Coastline Classics', 'San Diego'),
(1005, 'The Electric Hub', 'Austin');


-- Insert at least 5 Cars (linking to the Dealerships)
INSERT INTO Cars (make, model, year, price, dealership_fk_id) VALUES
-- Cars at Velocity Motors (ID 1001)
('Toyota', 'Camry', 2023, 25000.00, 1001),
('Honda', 'Civic', 2022, 19500.00, 1001),

-- Cars at Bay Area Imports (ID 1002)
('BMW', 'X5', 2024, 65000.00, 1002),
('Audi', 'A4', 2023, 41000.00, 1002),

-- Cars at Mountain View Auto (ID 1003)
('Ford', 'F-150', 2024, 52000.00, 1003),
('Chevy', 'Corvette', 2020, 78000.00, 1003),

-- Car at Coastline Classics (ID 1004)
('Mazda', 'Miata', 2019, 15500.00, 1004);


-- ***************************************************************
-- MULTI-TABLE QUERIES WITH NEW OPTIONS
-- ***************************************************************

-- QUERY 1: Display Car Details and Dealership using CONCAT
SELECT
    -- Concatenate the car make and model into one column
    CONCAT(C.make, ' ', C.model, ' (', C.year, ')') AS Full_Car_Name,
    D.name AS Dealership_Name,
    D.city AS Dealership_City
FROM Cars C
INNER JOIN Dealerships D ON C.dealership_fk_id = D.dealership_id
WHERE D.city = 'Miami' OR D.city = 'Austin';


-- QUERY 2: Display the price using FORMAT
SELECT
    D.name AS Dealership,
    C.make,
    C.model,
    -- Format the price column as currency with two decimal places
    FORMAT(C.price, 2) AS Formatted_Price
FROM Cars C
INNER JOIN Dealerships D ON C.dealership_fk_id = D.dealership_id
WHERE C.price > 40000.00;


-- QUERY 3: Find the top 3 most expensive cars using ORDER BY and LIMIT
SELECT
    CONCAT(C.make, ' ', C.model) AS Vehicle,
    D.name AS Located_At,
    FORMAT(C.price, 2) AS Price
FROM Cars C
INNER JOIN Dealerships D ON C.dealership_fk_id = D.dealership_id
-- Order the results by price in descending order (highest first)
ORDER BY C.price DESC
-- Limit the result set to only the top 3 rows
LIMIT 3;


-- QUERY 4: Combining aggregates (COUNT) and the 1:N Relationship
SELECT
    D.name AS Dealership_Name,
    COUNT(C.car_id) AS Total_Cars_In_Stock
FROM Dealerships D
INNER JOIN Cars C ON D.dealership_id = C.dealership_fk_id
-- Group the results by dealership name
GROUP BY D.name
ORDER BY Total_Cars_In_Stock DESC;
