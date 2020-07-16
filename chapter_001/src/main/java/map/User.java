package map;

import java.util.Calendar;

public class User {
    public String name;
    public int children;
    public Calendar birdhday;

    public User(String name, int children, Calendar birdhday) {
        this.name = name;
        this.children = children;
        this.birdhday = birdhday;
    }
}
