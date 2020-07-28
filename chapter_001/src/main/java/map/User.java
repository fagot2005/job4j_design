package map;

import java.util.*;

public class User {
    public String name;
    public int children;
    public Calendar birdhday;

    public User(String name, int children, Calendar birdhday) {
        this.name = name;
        this.children = children;
        this.birdhday = birdhday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children &&
                Objects.equals(name, user.name) &&
                Objects.equals(birdhday, user.birdhday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birdhday);
    }

    public static void main(String[] args) {
        User us1 = new User("Ivan", 2, new GregorianCalendar(1970, 12, 5));
        User us2 = new User("Ivan", 2, new GregorianCalendar(1970, 12, 5));
        Map<User, Object> map = new HashMap<>();
        map.put(us1, "USER1");
        map.put(us2, "USER2");
        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.keySet());
            System.out.println(map.hashCode());
        }
//        System.out.println(map.hashCode());
//        System.out.println(map.get(us1));
//        System.out.println(map.get(us2));
//        System.out.println(map.keySet().equals(map.keySet()));

    }
}
