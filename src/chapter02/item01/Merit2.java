package chapter02.item01;

//2. 호출될 때마다 인스턴스를 새로 생성하지는 않아도 된다.
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
