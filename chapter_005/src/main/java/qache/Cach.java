package qache;

import java.io.IOException;

public interface Cach<K, V> {

    V get(K key) throws IOException;
    void put(K key, V value);
}
