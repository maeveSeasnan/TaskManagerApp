USE TaskManager;
GO

-- Drop the table if it exists
DROP TABLE IF EXISTS tasks;

-- Create the table with the correct columns
CREATE TABLE tasks (
    task_id INT PRIMARY KEY IDENTITY(1,1),  -- auto-incrementing task ID
    task_name VARCHAR(255) NOT NULL,         -- task name
    task_description TEXT,                   -- task description
    task_status VARCHAR(50) NOT NULL         -- task status
);
