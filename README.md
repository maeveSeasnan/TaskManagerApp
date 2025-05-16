# Task Management App

A simple Java application that allows users to manage tasks using a SQL Server database. This project demonstrates basic CRUD operations, Java-SQL integration, and command-line user interaction.

---

## Features

- Add, update, view, and delete tasks
- Stores tasks persistently in a SQL Server database
- Uses JDBC for database connectivity
- Basic console-based user interface

---

## Technologies Used

- Java (Eclipse IDE)
- SQL Server
- JDBC (Java Database Connectivity)

---

## Setup Instructions

1. **Database Setup**  
   - Create a SQL Server database named `TaskManager`.  
   - Run the provided SQL script (`tasks_schema.sql`) to create the necessary tables.

2. **Configure Database Connection**  
   - Update the database connection details (URL, username, password) in the Java code (`TaskDAO.java`).

3. **Build and Run**  
   - Open the project in Eclipse.  
   - Make sure the SQL Server JDBC driver is added to your project’s build path.  
   - Run the `Main` class to start the app.

---

## Usage

- Follow on-screen prompts to add, update, delete, and list tasks.
- Tasks are stored in the SQL Server database and persist between sessions.
