package chapter02.item01;

public class Merit2 {
    public static class DatabaseConnection {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();

        private DatabaseConnection() {

        }

        public static DatabaseConnection getInstance() {
            return INSTANCE;
        }
    }
}
