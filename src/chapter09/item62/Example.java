package chapter09.item62;

public class Example {
    private static final ThreadLocalV2.Key USER_KEY_V2 = ThreadLocalV2.getKey();
    private static final ThreadLocalV2.Key ROLE_KEY_V2 = ThreadLocalV2.getKey();

    private static final ThreadLocalV3 USER_KEY_V3 = new ThreadLocalV3();
    private static final ThreadLocalV3 ROLE_KEY_V3 = new ThreadLocalV3();

    private static final ThreadLocalV3 USER_KEY_V4 = new ThreadLocalV3();
    private static final ThreadLocalV3 ROLE_KEY_V4 = new ThreadLocalV3();

    public static void main(String[] args) {
        ThreadLocalV2.set(USER_KEY_V2, "aliceV2");
        ThreadLocalV2.set(ROLE_KEY_V2, "adminV2");
        System.out.println("User: " + ThreadLocalV2.get(USER_KEY_V2));
        System.out.println("Role: " + ThreadLocalV2.get(ROLE_KEY_V2));

        USER_KEY_V3.set("aliceV3");
        ROLE_KEY_V3.set("adminV3");
        System.out.println("User: " + USER_KEY_V3.get());
        System.out.println("Role: " + ROLE_KEY_V3.get());

        USER_KEY_V4.set("aliceV4");
        ROLE_KEY_V4.set("adminV4");
        System.out.println("User: " + USER_KEY_V4.get());
        System.out.println("Role: " + ROLE_KEY_V4.get());
    }
}