package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnalizeCollection {

    public int[] diff(List<UserColl> previous, List<UserColl> current) {
        int[] info = new int[3];
        List<Integer> cheng = new ArrayList<>();
        List<Integer> tempAdd = new ArrayList<>();
        List<Integer> tempDell = new ArrayList<>();
        Map<Integer, UserColl> previousMap = new HashMap<>();
        Map<Integer, UserColl> currentMap = new HashMap<>();
        for (int i = 0; i < previous.size(); i++) {
            previousMap.put(previous.get(i).id, previous.get(i));
        }
        for (int i = 0; i < current.size(); i++) {
            currentMap.put(current.get(i).id, current.get(i));
        }
        for (Integer prevMap : previousMap.keySet()) {
            for (Integer currMap : currentMap.keySet()) {
                if (previousMap.get(prevMap).id == currentMap.get(currMap).id) {
                    if (!previousMap.get(prevMap).name.equals(currentMap.get(currMap).name)) {
                        cheng.add(prevMap);
                        tempAdd.add(currMap);
                    } else {
                        tempAdd.add(currMap);
                    }
                }
            }
        }
        for (Integer currMap : currentMap.keySet()) {
            for (Integer prevMap : previousMap.keySet()) {
                if (currentMap.get(currMap).id == previousMap.get(prevMap).id) {
                    tempDell.add(prevMap);
                }
            }
        }
        for (int i = 0; i < tempAdd.size(); i++) {
            currentMap.remove(tempAdd.get(i));
        }
        for (int i = 0; i < tempDell.size(); i++) {
            previousMap.remove(tempDell.get(i));
        }
        info[0] = currentMap.size();
        info[1] = cheng.size();
        info[2] = previousMap.size();
        return info;
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
}
