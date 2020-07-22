package map;

import java.util.*;
import java.util.Iterator;

import static java.util.Objects.hash;

public class SimpleMap<K, V> implements Iterable<SimpleMap.Entry> {
    private int carasyti;
    private int size;
    private static final int DEFAULT_CAPASYTI = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private int modeCount;
    private Entry<K, V>[] table;

    public SimpleMap() {
        this.table = new Entry[DEFAULT_CAPASYTI];
        this.carasyti = DEFAULT_CAPASYTI;
    }

    public SimpleMap(int size) {
        this.carasyti = size;
        this.table = new Entry[carasyti];
    }

    public boolean put(K key, V value) {
        grow();
        int h = hash(key);
        if (!(table[h] == null
                || ((key == table[h].key) || table[h].key.hashCode() == key.hashCode()
                && key.equals(table[h].key)))) {
            return false;
        }
        if (table[h] == null) {
            size++;
        }
        table[h] = new Entry<>(key, value, h);
        modeCount++;
        return  true;
    }

    public V remove(K key) {
        int h = hash(key);
        if (table[h] == null || !(key == null || table[h].key.hashCode() == key.hashCode()
                && key.equals(table[h].key))) {
            return null;
        }
        V v = table[h].value;
        table[h] = null;
        modeCount++;
        size--;
        return  v;
    }

    public V get(K key) {
        int h = hash(key);
        if (table[h] == null || !(key == null || table[h].key.hashCode() == key.hashCode()
                && key.equals(table[h].key))) {
            return null;
        }
        return table[h].value;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Entry> iterator() {
        return new Iterator<>() {
            private int index;
            private int excpectModCount = modeCount;


            @Override
            public boolean hasNext() {
                if (excpectModCount != modeCount) {
                    throw new ConcurrentModificationException();
                }
                boolean found = false;
                for (int i = index; i < table.length; i++) {
                    if (table[i] != null) {
                        index = i;
                        found = true;
                        break;
                    }
                }
                return found;
            }

            @Override
            public Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++];
            }
        };
    }
    private int hach(K key) {
        return (key == null) ? 0 : key.hashCode() & (carasyti - 1);
    }

    private void grow() {
        if (((float) size / carasyti) > LOAD_FACTOR) {
            int prevCapasity = carasyti;
            carasyti = carasyti >> 1;
            Entry<K, V>[] newTable = new Entry[carasyti];
            for (int i = 0; i < prevCapasity; i++) {
                if (table[i] != null) {
                    int h = hash(table[i].key);
                    newTable[h] = new Entry<>(table[i].key, table[i].value, h);
                }
            }
            table = newTable;
        }
    }
    public static class Entry<K, V> {
        private K key;
        private V value;
        private int hach;

        public Entry(K key, V value, int hach) {
            this.key = key;
            this.value = value;
            this.hach = hach;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
