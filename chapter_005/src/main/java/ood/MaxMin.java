package ood;

import java.util.*;


public class MaxMin {
    public static <T> T max(List<T> value, Comparator<T> comparator) {
        return value.isEmpty() ? null : maxMin(value, comparator.reversed());
    }

    public static <T> T min(List<T> value, Comparator<T> comparator) {
        return value.isEmpty() ? null : maxMin(value, comparator);
    }

    private static <T> T maxMin(List<T> list, Comparator<T> comparator) {
        Iterator <T> i = list.iterator();
        T val = i.next();
        while (i.hasNext()) {
            T cur = i.next();
            if (comparator.compare(val, cur) > 0) {
                val = cur;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(35);
        list.add(23);
        list.add(4);
        list.add(6);
        list.add(30);
        System.out.println("Original list " + list);
        System.out.println("Search max " + max(list, Comparator.naturalOrder()));
        System.out.println("Search min " + min(list, Comparator.naturalOrder()));
    }
}
