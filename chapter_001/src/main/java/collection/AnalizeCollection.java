package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AnalizeCollection {

    public Info diff(List<UserColl> previous, List<UserColl> current) {
        List<Integer> add = new ArrayList<>();
        List<Integer> cheng = new ArrayList<>();
        List<Integer> dellete = new ArrayList<>();
        List<Integer> idPrevious = new ArrayList<>();
        List<Integer> idCurrent = new ArrayList<>();
        for (int i = 0; i < previous.size(); i++) {
            idPrevious.add(previous.get(i).id);
        }
        for (int i = 0; i < current.size(); i++) {
            idCurrent.add(current.get(i).id);
        }
        for (int i = 0; i < idCurrent.size(); i++) {
            //  for (int j = 0; j < idCurrent.size(); j++) {
            if (!idPrevious.contains(idCurrent.get(i))) {
                System.out.println("ADD" + idCurrent.get(i));
                add.add(current.get(i).id);
            } else {
                if (!previous.get(i).name.equals(current.get(i).name)) {
                    System.out.println("CHENG" + previous.get(i).id + previous.get(i).name);
                    cheng.add(previous.get(i).id);
                }
            }
        }
        for (int i = 0; i < idPrevious.size(); i++) {
            //  for (int j = 0; j < idCurrent.size(); j++) {
            if (!idCurrent.contains(idPrevious.get(i))) {
                System.out.println("DELLETE" + idPrevious.get(i));
                dellete.add(previous.get(i).id);
            }
        }
        Info resalt = new Info(add.size(), cheng.size(), dellete.size());
        return resalt;
    }


    public static class UserColl {
        int id;
        String name;

        public UserColl(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    public static class Info {
        int added;
        int chenget;
        int delleted;

        public Info(int added, int chenget, int delleted) {
            this.added = added;
            this.chenget = chenget;
            this.delleted = delleted;
        }
    }
}
