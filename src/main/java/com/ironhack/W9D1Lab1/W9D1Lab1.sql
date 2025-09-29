-- ***************************************************************
-- PODCAST DATABASE SETUP (USER, PODCAST, DOWNLOADS)
-- This script creates a database and sets up a Many-to-Many relationship
-- via the 'Downloads' junction table.
-- ***************************************************************

-- 1. DATABASE CREATION
-- Create a new database for the podcast project
CREATE DATABASE PodcastDB;
-- Switch to the new database for all subsequent commands
USE PodcastDB;

---

-- 2. TABLE CREATION (Parent Tables First)

-- TABLE 1: Users (The 'who' is downloading)
CREATE TABLE Users (
    -- Primary Key: Unique ID for each user, auto-incremented
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    -- User's name
    username VARCHAR(100) NOT NULL,
    -- User's email (unique constraint ensures no duplicate emails)
    email VARCHAR(100) UNIQUE NOT NULL
);

-- TABLE 2: Podcasts (The 'what' is being downloaded)
CREATE TABLE Podcasts (
    -- Primary Key: Unique ID for each podcast
    podcast_id INT AUTO_INCREMENT PRIMARY KEY,
    -- Title of the podcast episode/show
    title VARCHAR(255) NOT NULL,
    -- Duration in minutes (numeric data type)
    duration_minutes INT,
    -- The genre or topic of the podcast
    genre VARCHAR(50)
);

-- TABLE 3: Downloads (The Junction Table - The 'event' that links User and Podcast)
CREATE TABLE Downloads (
    -- Primary Key: A unique identifier for the download event itself
    download_id INT AUTO_INCREMENT PRIMARY KEY,
    
    -- Foreign Key to the Users table (who downloaded)
    user_fk_id INT NOT NULL,
    -- Foreign Key to the Podcasts table (what was downloaded)
    podcast_fk_id INT NOT NULL,
    
    -- The moment of download (TIMESTAMP data)
    -- Stores the exact date and time of the download, defaults to current time
    download_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    
    -- Define the relationship constraints
    -- Link user_fk_id to the user_id column in the Users table
    CONSTRAINT FK_UserDownload FOREIGN KEY (user_fk_id) REFERENCES Users(user_id),
    -- Link podcast_fk_id to the podcast_id column in the Podcasts table
    CONSTRAINT FK_PodcastDownload FOREIGN KEY (podcast_fk_id) REFERENCES Podcasts(podcast_id)
);

---

-- 3. INSERTING RECORDS (Parent data must be inserted first!)

-- Insert Users
INSERT INTO Users (username, email) VALUES 
('Ana_Listener', 'ana@email.com'),          -- User ID 1
('Ben_MusicFan', 'ben@email.com'),          -- User ID 2
('Chris_TechNerd', 'chris@email.com');      -- User ID 3

-- Insert Podcasts
INSERT INTO Podcasts (title, duration_minutes, genre) VALUES 
('SQL Secrets Explained', 45, 'Technology'),    -- Podcast ID 1
('History of Joins', 30, 'Education'),          -- Podcast ID 2
('Database Design Fails', 60, 'Technology'),     -- Podcast ID 3
('The Latest in Rock', 55, 'Music');             -- Podcast ID 4

-- Insert Downloads (The 'Downloads' table links the IDs)
INSERT INTO Downloads (user_fk_id, podcast_fk_id) VALUES 
-- Ana downloaded two tech podcasts
(1, 1), -- Ana downloaded 'SQL Secrets Explained'
(1, 3), -- Ana downloaded 'Database Design Fails'
-- Ben downloaded history and music
(2, 2), -- Ben downloaded 'History of Joins'
(2, 4), -- Ben downloaded 'The Latest in Rock'
-- Chris downloaded a tech podcast
(3, 1), -- Chris downloaded 'SQL Secrets Explained' (Again, demonstrating Many-to-Many)
(3, 2); -- Chris downloaded 'History of Joins'

---

-- 4. MULTI-TABLE QUERY (Answering: Which podcast was downloaded by which client, and when?)

SELECT 
    U.username AS Client_Name,               -- Retrieve the user's name
    P.title AS Podcast_Title,                -- Retrieve the podcast title
    D.download_time AS Time_of_Download      -- Retrieve the event time from the junction table
FROM Downloads D                             -- Start with the junction table (D)
-- Join Downloads (D) to Users (U) to get the client's name
INNER JOIN Users U ON D.user_fk_id = U.user_id
-- Join Downloads (D) to Podcasts (P) to get the podcast's title
INNER JOIN Podcasts P ON D.podcast_fk_id = P.podcast_id
-- Sort the result by user and then by the time of download
ORDER BY U.username, D.download_time DESC;

-- Example Query: Find all podcasts downloaded by 'Ana_Listener'
SELECT
    P.title AS Ana_Downloaded_Podcast,
    D.download_time
FROM Downloads D
INNER JOIN Users U ON D.user_fk_id = U.user_id
INNER JOIN Podcasts P ON D.podcast_fk_id = P.podcast_id
WHERE U.username = 'Ana_Listener'
ORDER BY D.download_time;
