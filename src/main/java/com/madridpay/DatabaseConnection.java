import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/madrid_payment";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "global@123";
    private static final Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    public static boolean testConnection() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            if (connection != null) {
                logger.info("Database connection successful.");
                return true;
            }
        } catch (SQLException e) {
            logger.severe("Database connection failed: " + e.getMessage());
        }
        return false;
    }
}
