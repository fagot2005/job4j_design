package gs;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public User() {

    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("DELETED");
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println(sizeOf(user));
        user = null;
        System.gc();
    }
}
