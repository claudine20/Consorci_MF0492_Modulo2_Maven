-- ***************************************************************
-- PART 0: DATABASE SETUP
-- ***************************************************************

-- Drop the database if it exists to ensure we start fresh
DROP DATABASE IF EXISTS FilmStudioDB;
-- Create the new database for movie data
CREATE DATABASE FilmStudioDB;
-- Select the database to begin operations
USE FilmStudioDB;

-- ***************************************************************
-- PART 1: TABLE CREATION (MOVIES)
-- ***************************************************************

-- Create the table named 'Movies'
CREATE TABLE Movies (
    -- Primary Key: unique, auto-incrementing ID for each movie
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    -- Title of the movie (up to 255 characters)
    title VARCHAR(255) NOT NULL,
    -- Main protagonist or lead actor (up to 100 characters)
    protagonist VARCHAR(100) NOT NULL,
    -- Year of production (using YEAR data type)
    production_year YEAR,
    -- Genre of the film (up to 50 characters)
    genre VARCHAR(50),
    -- Worldwide box office revenue (in millions of USD, 15 total digits, 2 decimal places)
    box_office_revenue DECIMAL(15, 2)
);

-- ***************************************************************
-- PART 2: DATA INSERTION (AT LEAST 10 MOVIES)
-- ***************************************************************

-- Insert 11 records into the Movies table
-- NOTE: box_office_revenue values are in Millions of USD

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Inception', 'Leonardo DiCaprio', 2010, 'Sci-Fi', 836.80);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Titanic', 'Leonardo DiCaprio', 1997, 'Romance', 2200.00);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Dune', 'Timothée Chalamet', 2021, 'Sci-Fi', 402.00);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('The Matrix', 'Keanu Reeves', 1999, 'Action', 465.30);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Parasite', 'Song Kang-ho', 2019, 'Thriller', 258.70);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Barbie', 'Margot Robbie', 2023, 'Comedy', 1446.00);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Oppenheimer', 'Cillian Murphy', 2023, 'Biography', 952.00);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Get Out', 'Daniel Kaluuya', 2017, 'Horror', 255.40);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Spirited Away', 'Chieko Baisho', 2001, 'Animation', 395.60);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Pulp Fiction', 'John Travolta', 1994, 'Crime', 213.90);

INSERT INTO Movies (title, protagonist, production_year, genre, box_office_revenue)
VALUES ('Avengers: Endgame', 'Robert Downey Jr.', 2019, 'Action', 2798.00);


-- ***************************************************************
-- PART 3: QUERIES AND ANALYSIS
-- ***************************************************************

-- 1. Ver solo titulo y año (See only title and year)
SELECT title, production_year
-- Retrieve data from the Movies table
FROM Movies;


-- 2. Todas las películas producidas a partir de cierto año, en orden ascendente (Movies produced after 2015, ascending)
SELECT *
FROM Movies
-- Filter for production years greater than or equal to 2015
WHERE production_year >= 2015
-- Order the results by the production year (ASC is default, but explicit is clear)
ORDER BY production_year ASC;


-- 3. Ordenar por titulo (Order by title alphabetically)
SELECT *
FROM Movies
-- Sorts the entire result set based on the movie title
ORDER BY title;


-- 4. Agrupar por género y contar (Group by genre and count)
SELECT genre,
-- COUNT(*) counts the number of rows in each group
COUNT(*) AS total_movies_in_genre -- Rename the count column using AS
FROM Movies
-- GROUP BY combines rows with the same genre into a summary row
GROUP BY genre;


-- 5. Ver solo las pelis con recaudación menor que X (See movies with revenue less than $500 Million)
SELECT title, box_office_revenue
FROM Movies
-- Filter where the box office revenue is strictly less than 500.00
WHERE box_office_revenue < 500.00
-- Order by revenue to see the lowest earners first
ORDER BY box_office_revenue DESC;


-- 6. Ver películas entre un año y otro de producción (Movies between 1990 and 2000, inclusive)
SELECT *
FROM Movies
-- The BETWEEN operator selects values within a given range (inclusive)
WHERE production_year BETWEEN 1990 AND 2000
ORDER BY production_year;


-- 7. Ver cuantas pelis hay en la lista (See how many movies are in the list)
SELECT
-- COUNT(*) returns the number of rows in the table
COUNT(*) AS total_movie_count -- Rename the resulting column using AS
FROM Movies;


-- 8. Ver la suma de todas las recaudaciones (See the sum of all revenues)
SELECT
-- SUM() calculates the total of a numeric column
SUM(box_office_revenue) AS grand_total_revenue_million_usd -- Rename and specify units
FROM Movies;


-- 9. Ver la media de las recaudaciones (See the average of the revenues)
SELECT
-- AVG() calculates the arithmetic mean of a numeric column
AVG(box_office_revenue) AS average_revenue_million_usd -- Rename and specify units
FROM Movies;
