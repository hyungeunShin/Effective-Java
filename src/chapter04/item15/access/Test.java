package chapter04.item15.access;

public class Test {
    public static void main(String[] args) {
        new TestClass.PublicClass();
        new TestClass.PackagePrivateClass();
        new TestClass.ProtectedClass();
        //new TestClass.PrivateClass();
    }
}
