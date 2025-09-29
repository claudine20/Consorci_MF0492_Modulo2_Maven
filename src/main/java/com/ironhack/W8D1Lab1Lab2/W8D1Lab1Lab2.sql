-- ***************************************************************
-- PART 0: DATABASE SETUP (COMMON TO ALL EXERCISES)
-- ***************************************************************

-- Remove the database if it already exists to ensure a clean start
DROP DATABASE IF EXISTS ComicUniverseDB;
-- Create the new database named 'ComicUniverseDB'
CREATE DATABASE ComicUniverseDB;
-- Switch to using the newly created database for all subsequent commands
USE ComicUniverseDB;

-- ***************************************************************
-- PART 1: MANUAL TABLE CREATION AND DATA MANIPULATION (SQL ONLY)
-- ***************************************************************

-- Create the 'ComicCharacters' table as requested
CREATE TABLE ComicCharacters (
    -- The primary key: a unique identifier for each character, automatically increases (AUTOCREMENT)
    character_id INT AUTO_INCREMENT PRIMARY KEY,
    -- The character's name: a variable-length string (VARCHAR)
    character_name VARCHAR(100) NOT NULL,
    -- The character's species/type: a variable-length string
    species VARCHAR(50) NOT NULL,
    -- The character's favorite quote: a variable-length string
    favorite_quote VARCHAR(255),
    -- The character's first appearance year: a numeric data type
    first_appearance_year INT 
);

-- Insert at least 5 records manually into the ComicCharacters table

-- Record 1
INSERT INTO ComicCharacters (character_name, species, favorite_quote, first_appearance_year)
VALUES ('Wonder Woman', 'Amazon', 'A hero is always ready for the moment.', 1941);

-- Record 2
INSERT INTO ComicCharacters (character_name, species, favorite_quote, first_appearance_year)
VALUES ('Batman', 'Human', 'I am the night.', 1939);

-- Record 3 (Inserting with an intentional typo to demonstrate UPDATE next)
INSERT INTO ComicCharacters (character_name, species, favorite_quote, first_appearance_year)
VALUES ('Superman', 'Kryptoninian', 'Up, up and away!', 1938);

-- Record 4
INSERT INTO ComicCharacters (character_name, species, favorite_quote, first_appearance_year)
VALUES ('Black Panther', 'Human', 'Wakanda Forever!', 1966);

-- Record 5
INSERT INTO ComicCharacters (character_name, species, favorite_quote, first_appearance_year)
VALUES ('The Flash', 'Human (Mutate)', 'I just ran a thousand miles in an hour.', 1940);

-- Record 6 (More than 5 for better testing)
INSERT INTO ComicCharacters (character_name, species, favorite_quote, first_appearance_year)
VALUES ('Martian Manhunter', 'Martian', 'My soul is a desert, my life is a tomb.', 1955);


-- COMMAND: Manually correct one of the data points (Correcting the 'Kryptoninian' typo for Superman)
UPDATE ComicCharacters
-- Set the new value for the 'species' column
SET species = 'Kryptonian'
-- Specify the condition (WHERE) to target only the 'Superman' record
WHERE character_name = 'Superman';


-- COMMAND: Manually delete one of the records (Deleting the record for 'The Flash')
DELETE FROM ComicCharacters
-- Specify the condition (WHERE) to target only 'The Flash'
WHERE character_name = 'The Flash';


-- ***************************************************************
-- PART 2: VISUAL TABLE CREATION (SQL SCRIPT FOR STRUCTURE)
-- ***************************************************************

-- Create the 'ComicAuthors' table structure (designed to simulate visual creation)
CREATE TABLE ComicAuthors (
    -- Unique author identifier, auto-incrementing
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    -- Author's first name
    first_name VARCHAR(50) NOT NULL,
    -- Author's last name
    last_name VARCHAR(50) NOT NULL,
    -- Author's date of birth (DATE data type)
    date_of_birth DATE,
    -- Timestamp when the record was created (like 'alta de registro')
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    -- Timestamp when the record was last updated (like 'modificación de registro')
    last_modified TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create the 'Countries' table structure (designed to simulate visual creation)
CREATE TABLE Countries (
    -- Unique country identifier
    country_id INT AUTO_INCREMENT PRIMARY KEY,
    -- Name of the country
    country_name VARCHAR(100) NOT NULL,
    -- Name of the capital city
    capital VARCHAR(100) NOT NULL,
    -- Numeric value for the index of wealth (DECIMAL for precise numeric data)
    wealth_index DECIMAL(15, 2)
);


-- SIMULATED INSERT DATA (These INSERTs simulate the data you would export/reimport from DBeaver's result grid)

-- Insert data into ComicAuthors (At least 5 authors)
INSERT INTO ComicAuthors (first_name, last_name, date_of_birth) VALUES ('Stan', 'Lee', '1922-12-28');
INSERT INTO ComicAuthors (first_name, last_name, date_of_birth) VALUES ('Jack', 'Kirby', '1917-08-28');
INSERT INTO ComicAuthors (first_name, last_name, date_of_birth) VALUES ('Alan', 'Moore', '1953-11-18');
INSERT INTO ComicAuthors (first_name, last_name, date_of_birth) VALUES ('Neil', 'Gaiman', '1960-11-10');
INSERT INTO ComicAuthors (first_name, last_name, date_of_birth) VALUES ('Will', 'Eisner', '1917-03-06');

-- Insert data into Countries (At least 5 countries)
INSERT INTO Countries (country_name, capital, wealth_index) VALUES ('United States', 'Washington, D.C.', 80035.00);
INSERT INTO Countries (country_name, capital, wealth_index) VALUES ('Monaco', 'Monaco', 240000.00);
INSERT INTO Countries (country_name, capital, wealth_index) VALUES ('Canada', 'Ottawa', 55562.00);
INSERT INTO Countries (country_name, capital, wealth_index) VALUES ('Mexico', 'Mexico City', 13351.00);
-- Inserting a record with a NULL value in wealth_index to test that functionality
INSERT INTO Countries (country_name, capital, wealth_index) VALUES ('Narnia', 'Cair Paravel', NULL);
INSERT INTO Countries (country_name, capital, wealth_index) VALUES ('Japan', 'Tokyo', 42953.00);


-- ***************************************************************
-- PART 3: QUERIES (SELECT, WHERE, ORDER BY, LIKE, Comparison)
-- ***************************************************************

-- 1. SELECT and WHERE: How selects the data of a given id? (Select the character with ID 1)
SELECT *
FROM ComicCharacters
-- Filter results where the primary key (book_id) is exactly 1
WHERE character_id = 1;


-- 2. SELECT Specific Column: As shows a specific column? (Show only the name and species)
SELECT character_name, species
-- Select data from the ComicCharacters table
FROM ComicCharacters;


-- 3. LIKE with %: How do you find any element that contains the letter 'm'? (Find characters with 'm' in their name)
SELECT *
FROM ComicCharacters
-- Use LIKE to match the pattern
WHERE character_name LIKE '%m%';
-- % (percent) is a wildcard that matches any sequence of zero or more characters


-- 4. LIKE with _: Find authors whose first name has exactly 4 letters
SELECT *
FROM ComicAuthors
-- Use LIKE and four underscores
WHERE first_name LIKE '____';
-- _ (underscore) is a wildcard that matches exactly one single character


-- 5. ORDER BY and DESC: How do you order the result according to its numeric value? (Order by first appearance year)
SELECT *
FROM ComicCharacters
-- Sort the results based on the 'first_appearance_year' column
ORDER BY first_appearance_year;
-- By default, this sorts in ascending (ASC) order (earliest to latest)

-- 6. ORDER BY DESC: Order countries by their wealth index from highest to lowest
SELECT *
FROM Countries
-- Sort the results based on the 'wealth_index' column
ORDER BY wealth_index DESC;
-- DESC stands for descending order


-- 7. WHERE with Comparison Operators: Select countries with a wealth index greater than (>) 60000.00
SELECT *
FROM Countries
-- Filter results where the numeric value is greater than the specified amount
WHERE wealth_index > 60000.00;


-- ***************************************************************
-- PART 4: DATA MANIPULATION (DML) COMMANDS
-- Demonstrating UPDATE, DELETE, and setting values to NULL
-- ***************************************************************

-- DML COMMAND 1: MODIFY A VALUE (UPDATE)
-- This command corrects the intentional typo in Superman's species from 'Kryptoninian' to 'Kryptonian'.
UPDATE ComicCharacters
-- Use the SET clause to specify the column and its new value
SET species = 'Kryptonian'
-- Use the WHERE clause to ensure only the target row is changed (based on the name)
WHERE character_name = 'Superman';

-- Another UPDATE example: Changing the last name of author 'Alan Moore' to 'Moorish' (just for demonstration)
UPDATE ComicAuthors
SET last_name = 'Moorish'
WHERE first_name = 'Alan';


-- DML COMMAND 2: DELETE AN ENTIRE RECORD
-- This command removes the record for 'Martian Manhunter'.
DELETE FROM ComicCharacters
-- The WHERE clause ensures only this specific record is deleted
WHERE character_name = 'Martian Manhunter';

-- Another DELETE example: Removing 'Narnia' from the Countries table
DELETE FROM Countries
-- The WHERE clause targets the country by name
WHERE country_name = 'Narnia';


-- DML COMMAND 3: CHANGE A VALUE TO NULL (actually null, that appears different in DBeaver)
-- This command updates a non-NULL date of birth for 'Will Eisner' to NULL.
UPDATE ComicAuthors
-- Set the date_of_birth field to the keyword NULL (not 'null' string)
SET date_of_birth = NULL
-- Target the specific author
WHERE first_name = 'Will';

-- Let's see the final state of the tables after all the DML operations
-- Check the Characters table (Superman species corrected, The Flash deleted)
SELECT * FROM ComicCharacters;

-- Check the Authors table (Alan Moore last name changed, Will Eisner's DOB is NULL)
SELECT * FROM ComicAuthors;

-- Check the Countries table (Narnia deleted)
SELECT * FROM Countries;
