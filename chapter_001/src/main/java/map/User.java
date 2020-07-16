package map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    public String name;
    public int children;
    public Calendar birdhday;

    public User(String name, int children, Calendar birdhday) {
        this.name = name;
        this.children = children;
        this.birdhday = birdhday;
    }

    public static void main(String[] args) {
        User us1 = new User("Ivan", 2, new GregorianCalendar(1970, 12, 5));
        User us2 = new User("Ivan", 2, new GregorianCalendar(1970, 12, 5));
        Map<User, Object> map = new HashMap<>();
        map.put(us1, "USER1");
        map.put(us2, "USER2");
        System.out.println(map);
    }
}
