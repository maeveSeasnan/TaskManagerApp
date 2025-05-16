package taskmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=TaskManager;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";

    /**
     * Establishes and returns a connection to the SQL Server database.
     *
     * @return Connection object to the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
