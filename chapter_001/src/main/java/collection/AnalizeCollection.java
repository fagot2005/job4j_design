package collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalizeCollection {

    public int[] diff(List<UserColl> previous, List<UserColl> current) {
        int[] info = new int[3];
        Map<Integer, UserColl> previousMap = new HashMap<>();
        for (int i = 0; i < previous.size(); i++) {
            previousMap.put(previous.get(i).id, previous.get(i));
        }
        for (UserColl curr : current) {
            if (previousMap.containsKey(curr.id)) {
                if (!previousMap.get(curr.id).name.equals(curr.name)) {
                    info[0]++;
                    info[1]++;
                } else {
                    info[0]++;
                }
            } else {
                info[2]++;
            }
        }
        info[0] = current.size() - info[0];
        return info;
    }

    public static class UserColl {
        int id;
        String name;

        public UserColl(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
