package taskmanager;

import java.sql.*;

public class TaskDAO {

    // Insert task into database
    public static void insertTask(String taskName, String taskDescription, String taskStatus) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TaskManager;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        String insertQuery = "INSERT INTO Tasks (task_name, task_description, task_status) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            stmt.setString(1, taskName);
            stmt.setString(2, taskDescription);
            stmt.setString(3, taskStatus);
            stmt.executeUpdate();
            System.out.println("Task inserted successfully!");

        } catch (SQLException e) {
            System.out.println("Error inserting task:");
            e.printStackTrace();
        }
    }

    // Read tasks from database
    public static void readTasks() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TaskManager;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        String selectQuery = "SELECT * FROM Tasks";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectQuery)) {

            System.out.println("Tasks in database:");
            while (rs.next()) {
                int id = rs.getInt("task_id");
                String taskName = rs.getString("task_name");
                String taskDescription = rs.getString("task_description");
                String taskStatus = rs.getString("task_status");
                
                // Display tasks
                System.out.println("ID: " + id + ", Name: " + taskName + ", Description: " + taskDescription + ", Status: " + taskStatus);
            }

        } catch (SQLException e) {
            System.out.println("Error reading tasks:");
            e.printStackTrace();
        }
    }
    
 // Update task in the database
    public static void updateTask(int taskId, String newTaskName, String newTaskDescription, String newTaskStatus) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TaskManager;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        String updateQuery = "UPDATE Tasks SET task_name = ?, task_description = ?, task_status = ? WHERE task_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(updateQuery)) {

            stmt.setString(1, newTaskName);
            stmt.setString(2, newTaskDescription);
            stmt.setString(3, newTaskStatus);
            stmt.setInt(4, taskId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task updated successfully!");
            } else {
                System.out.println("No task found with the provided ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating task:");
            e.printStackTrace();
        }
    }

    // Delete task from the database
    public static void deleteTask(int taskId) {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=TaskManager;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
        String deleteQuery = "DELETE FROM Tasks WHERE task_id = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {

            stmt.setInt(1, taskId);

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Task deleted successfully!");
            } else {
                System.out.println("No task found with the provided ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting task:");
            e.printStackTrace();
        }
    }
}
