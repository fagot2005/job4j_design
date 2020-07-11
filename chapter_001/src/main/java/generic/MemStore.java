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
        return  mem.set(findById(id), model) ? true : false;
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(findById(id)) ? true : false;
    }

    @Override
    public T findById(String id) {
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                return mem.get(i);
            }
        }
        return null;
    }
}
