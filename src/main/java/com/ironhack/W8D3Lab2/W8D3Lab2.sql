-- ***************************************************************
-- PART 0: DATABASE SETUP
-- ***************************************************************

-- Drop the database if it exists to ensure a clean start for the new structure
DROP DATABASE IF EXISTS RelationshipDB;
-- Create the new database named 'RelationshipDB'
CREATE DATABASE RelationshipDB;
-- Switch to using the new database
USE RelationshipDB;


-- ***************************************************************
-- PART 1: PRODUCTS AND CATEGORIES RELATIONSHIP (One-to-Many)
-- ***************************************************************

-- 1. Create the 'Categories' table (The "One" side of the relationship)
CREATE TABLE Categories (
    -- Primary Key for categories
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    -- Name of the category
    category_name VARCHAR(100) NOT NULL
);

-- Insert at least 3 categories
INSERT INTO Categories (category_name) VALUES ('Electronics');
INSERT INTO Categories (category_name) VALUES ('Home Goods');
INSERT INTO Categories (category_name) VALUES ('Books & Media');
-- Adding a fourth category for variety
INSERT INTO Categories (category_name) VALUES ('Apparel');


-- 2. Create the 'Products' table (The "Many" side of the relationship)
-- How do we relate them? We add a Foreign Key (FK) column to the 'Products' table
CREATE TABLE Products (
    -- Primary Key for products
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    -- Title/Name of the product
    product_title VARCHAR(255) NOT NULL,
    -- Price of the product
    price DECIMAL(10, 2) NOT NULL,
    -- *** FOREIGN KEY COLUMN ***
    -- This column links the product back to its specific category
    category_fk_id INT NOT NULL,
    -- Define the relationship: category_fk_id in Products references category_id in Categories
    FOREIGN KEY (category_fk_id) REFERENCES Categories(category_id)
);

-- Insert at least 6 products, linking them to the categories by category_fk_id
-- (Assuming 1=Electronics, 2=Home Goods, 3=Books & Media, 4=Apparel)
INSERT INTO Products (product_title, price, category_fk_id) VALUES ('Smartphone Model X', 799.99, 1);
INSERT INTO Products (product_title, price, category_fk_id) VALUES ('Smart Watch Series 5', 349.50, 1);
INSERT INTO Products (product_title, price, category_fk_id) VALUES ('Coffee Maker Deluxe', 89.99, 2);
INSERT INTO Products (product_title, price, category_fk_id) VALUES ('Duvet Cover Set', 55.00, 2);
INSERT INTO Products (product_title, price, category_fk_id) VALUES ('Best Seller Novel', 19.95, 3);
INSERT INTO Products (product_title, price, category_fk_id) VALUES ('Sci-Fi Magazine Subscription', 12.00, 3);
INSERT INTO Products (product_title, price, category_fk_id) VALUES ('Summer T-Shirt', 25.00, 4);


-- QUERY 1: Show all products and their category names (using INNER JOIN)
select p.product_title, p.price, c.category_name -- Retrieve the category name from the Categories table
FROM Products p -- Use 'p' as an alias for Products
INNER JOIN Categories c -- Combine Products with Categories
ON p.category_fk_id = c.category_id; -- Where the foreign key equals the primary key



-- ***************************************************************
-- PART 2: ESTABLISHING RELATIONSHIPS IN EXISTING ComicUniverseDB
-- ***************************************************************

-- Select the database created in the previous exercise
USE ComicUniverseDB;

-- SECTION 1: ADDING FOREIGN KEY COLUMNS

-- Add the column to ComicAuthors that will link it to the Countries table
ALTER TABLE ComicAuthors
ADD COLUMN country_fk_id INT;

-- Add the column to ComicCharacters that will link it to the ComicAuthors table
ALTER TABLE ComicCharacters
ADD COLUMN creator_fk_id INT;


-- SECTION 2: ADDING DATA FOR NEW RELATIONSHIPS (Countries and Sample Data)
-- We need to ensure the Country table is populated with IDs we can use for linking.

-- 1. TEMPORARILY DISABLE FOREIGN KEY CONSTRAINTS
-- This is a common practice when re-inserting dependent data (Parent/Child)
-- It ensures that the order of INSERTS doesn't trigger the error 1452
SET FOREIGN_KEY_CHECKS = 0;

-- 2. CLEAN UP (Delete all existing data for a clean re-link)
-- Note: We delete Characters first because they depend on Authors (Foreign Key constraint)

-- Note: We use DELETE/INSERT here to ensure clean Country IDs (1, 2, 3) for linking.
DELETE FROM Countries;
DELETE FROM ComicCharacters; 
DELETE FROM ComicAuthors;

-- 3. RE-INSERT data into tables

-- 3.1- RE-INSERT countries with known IDs (needed for the authors' country_fk_id)
-- Insert United States with ID 1 for linking
INSERT INTO Countries (country_id, country_name, capital, wealth_index) 
VALUES (1, 'United States', 'Washington D.C.', 80035.00);
-- Insert United Kingdom with ID 2 for linking
INSERT INTO Countries (country_id, country_name, capital, wealth_index) 
VALUES (2, 'United Kingdom', 'London', 51200.00);
-- Insert France with ID 3 for linking
INSERT INTO Countries (country_id, country_name, capital, wealth_index) 
VALUES (3, 'France', 'Paris', 46300.00);

-- Check the newly inserted data
SELECT * FROM Countries;

-- 3.2- RE-INSERT AUTHORS with specific, known IDs and correct foreign keys
-- FIXED: Removed 'registration_date' and 'modification_date' columns
INSERT INTO ComicAuthors (author_id, first_name, last_name, date_of_birth, country_fk_id)
VALUES 
(1, 'Stan', 'Lee', '1922-12-28', 1), -- Stan Lee (US: ID 1)
(2, 'Jack', 'Kirby', '1917-08-28', 1), -- Jack Kirby (US: ID 1)
(3, 'Alan', 'Moore', '1953-11-18', 2), -- Alan Moore (UK: ID 2)
(4, 'Neil', 'Gaiman', '1960-11-10', 2), -- Neil Gaiman (UK: ID 2)
(5, 'Will', 'Eisner', '1917-03-06', 1), -- Will Eisner (US: ID 1)
(6, 'René', 'Goscinny', '1926-08-14', 3); -- René Goscinny (France: ID 3)

-- 3.3-  RE-INSERT CHARACTERS (Linking to Authors)
-- We insert the user's original 6 characters, plus 'Asterix' to ensure the France query works.
INSERT INTO ComicCharacters (character_name, species, favorite_quote, first_appearance_year, creator_fk_id)
VALUES 
-- Original Characters linked to the original authors (IDs 1-5)
('Wonder Woman', 'Amazon', 'A hero is always ready for the moment.', 1941, 5), -- Linked to Will Eisner (ID 5)
('Batman', 'Human', 'I am the night.', 1939, 2), -- Linked to Jack Kirby (ID 2)
('Superman', 'Kryptoninian', 'Up, up and away!', 1938, 1), -- Linked to Stan Lee (ID 1)
('Black Panther', 'Human', 'Wakanda Forever!', 1966, 1), -- Linked to Stan Lee (ID 1)
('The Flash', 'Human (Mutate)', 'I just ran a thousand miles in an hour.', 1940, 2), -- Linked to Jack Kirby (ID 2)
('Martian Manhunter', 'Martian', 'My soul is a desert, my life is a tomb.', 1955, 3), -- Linked to Alan Moore (ID 3)
-- French Character linked to the French Author (ID 6)
('Asterix', 'Human', 'By Toutatis!', 1959, 6); -- Linked to René Goscinny (ID 6)

-- RE-ENABLE FOREIGN KEY CONSTRAINTS
SET FOREIGN_KEY_CHECKS = 1;


-- SECTION 3: DEFINING FOREIGN KEY CONSTRAINTS (The formal relationship)

-- Add the Foreign Key constraint linking ComicAuthors.country_fk_id to Countries.country_id
ALTER TABLE ComicAuthors
ADD CONSTRAINT FK_AuthorCountry
FOREIGN KEY (country_fk_id) REFERENCES Countries(country_id);

-- Add the Foreign Key constraint linking ComicCharacters.creator_fk_id to ComicAuthors.author_id
ALTER TABLE ComicCharacters
ADD CONSTRAINT FK_CharacterCreator
FOREIGN KEY (creator_fk_id) REFERENCES ComicAuthors(author_id);


-- SECTION 4: LINKING EXISTING AUTHORS AND CHARACTERS TO COUNTRIES AND CREATORS
-- We use UPDATE to populate the new FK columns in the existing data.

-- Link Authors to Countries (e.g., Stan Lee is US/ID 1, Alan Moore is UK/ID 2)
UPDATE ComicAuthors SET country_fk_id = 1 WHERE first_name = 'Stan';
UPDATE ComicAuthors SET country_fk_id = 2 WHERE first_name = 'Alan';
UPDATE ComicAuthors SET country_fk_id = 1 WHERE first_name = 'Jack';
UPDATE ComicAuthors SET country_fk_id = 3 WHERE first_name = 'René';


-- Link Characters to Authors (e.g., Spider-Man creator_fk_id is 1/Stan Lee)
UPDATE ComicCharacters SET creator_fk_id = 1 WHERE character_name = 'Wonder Woman'; -- Assuming Stan Lee for example
UPDATE ComicCharacters SET creator_fk_id = 2 WHERE character_name = 'Dr. Manhattan';
UPDATE ComicCharacters SET creator_fk_id = 1 WHERE character_name = 'Batman';
UPDATE ComicCharacters SET creator_fk_id = 3 WHERE character_name = 'Superman';


-- ***************************************************************
-- SECTION 4: ADVANCED JOIN QUERIES
-- ***************************************************************

-- QUERY 1:: Verify the author-country link (Step 1 of debugging)
SELECT 
    A.first_name, 
    C.country_name
FROM ComicAuthors A 
INNER JOIN Countries C ON A.country_fk_id = C.country_id 
WHERE C.country_name = 'France';
-- EXPECTED RESULT: 1 row ('René', 'France')



-- QUERY 2: Display all characters and their country of origin, ordered by country.
-- This also requires linking all three tables together.
SELECT
    CH.character_name AS `Character`, -- The fix: wrap 'Character' in backticks (`)
    A.first_name AS Creator,
    C.country_name AS Creator_Country
FROM ComicCharacters CH 
INNER JOIN ComicAuthors A ON CH.creator_fk_id = A.author_id
INNER JOIN Countries C ON A.country_fk_id = C.country_id
ORDER BY C.country_name ASC;


-- FINAL QUERY: Display author, country, and created character for 'France'
SELECT
    -- Concatenate the author's first and last names
    CONCAT(A.first_name, ' ', A.last_name) AS Author_Name,
    -- Get the country name from the Countries table
    C.country_name AS Birth_Country,
    -- Get the character name from the ComicCharacters table
    CH.character_name AS `Created_Character` -- FIXED: Using backticks (`) for the alias
FROM ComicAuthors A
-- INNER JOIN links Authors (A) to Countries (C) on the Country Foreign Key
INNER JOIN Countries C ON A.country_fk_id = C.country_id
-- INNER JOIN links Authors (A) to ComicCharacters (CH) on the Creator Foreign Key
INNER JOIN ComicCharacters CH ON A.author_id = CH.creator_fk_id
-- Filter the final result to only show authors from 'France'
WHERE C.country_name = 'France';
-- EXPECTED RESULT: 1 row ('René Goscinny', 'France', 'Asterix')

