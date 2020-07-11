package generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int index = indexElement(id);
        if (index == -1) {
            return false;
        }
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = indexElement(id);
        if (index == -1) {
            return false;
        }
        mem.remove(findById(id));
        return true;
    }

    @Override
    public T findById(String id) {
        int index = indexElement(id);
        if (index == -1) {
            return null;
        }
        return mem.get(indexElement(id));
    }

    public int indexElement(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
