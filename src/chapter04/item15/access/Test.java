package chapter04.item15.access;

public class Test {
    public static void main(String[] args) {
        new PublicClass();
        new PackagePrivateClass();
        //new PrivateClass();
        new ProtectedClass();
    }
}
