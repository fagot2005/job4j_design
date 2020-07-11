package generic;

public class UserStore implements Store<User> {

    private final Store<User> store = new MemStore<>();

    @Override
    public void add(User model) {
        store.add(model);
   }

    @Override
    public boolean replace(String id, User model) {
        return false;
    }

    @Override
    public boolean delete(String id) {

        return false;
    }

    @Override
    public User findById(String id) {
        for (int i = 0; i < store.; i++) {

        }
        return null;
    }
}
