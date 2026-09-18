package utils.helper;

import java.sql.*;

public class JDBCManager {

    private static final String DB_URL = System.getProperty("db.url", "jdbc:postgresql://localhost:5432/testdb");
    private static final String DB_USER = System.getProperty("db.user", "test_user");
    private static final String DB_PASS = System.getProperty("db.password", "secret_pass");

    // ThreadLocal ensures thread safety during parallel Selenium runs
    private static final ThreadLocal<Connection> connectionHolder = new ThreadLocal<>();

    private JDBCManager() {}

    public static Connection getConnection() {
        try {
            if (connectionHolder.get() == null || connectionHolder.get().isClosed()) {
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                // Optional: set auto-commit off for transactional integrity
                conn.setAutoCommit(true);
                connectionHolder.set(conn);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to establish JDBC Connection", e);
        }
        return connectionHolder.get();
    }

    public static void closeConnection() {
        try {
            Connection conn = connectionHolder.get();
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing JDBC Connection: " + e.getMessage());
        } finally {
            connectionHolder.remove(); // Prevents memory leaks in ThreadLocal
        }
    }

    public class UserDAO {

        public boolean isUserVerified(String userEmail) {
            String sql = "SELECT is_verified FROM users WHERE email = ?";

            // Get connection from ThreadLocal JDBC manager
            Connection conn = JDBCManager.getConnection();

            // Statements and ResultSets auto-close when the block ends
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setString(1, userEmail);

                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return rs.getBoolean("is_verified");
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("JDBC Query execution failed for email: " + userEmail, e);
            }
            return false;
        }
    }
}




