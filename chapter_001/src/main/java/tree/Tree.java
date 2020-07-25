package tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class Tree<E> implements SimpleTree<E> {
    private final Node<E> root;

    public Tree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rls = false;
        Optional<Node<E>> parentNode = foundBy(parent);
        if (parentNode.isPresent()) {
            Optional<Node<E>> childNode = foundBy(child);
            if (childNode.isEmpty()) {
                parentNode.get().children.add(new Node<E>(child));
                rls = true;
            }
        }
        return rls;
    }

    @Override
    public Optional<Node<E>> foundBy(E value) {
        return foundByPredicate(x -> x.value.equals(value));
    }

    public Optional<Node<E>> foundByPredicate(Predicate<Node<E>> conditions) {
        Optional<Node<E>> rls = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (conditions.test(el)) {
                rls = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rls;
    }
}
