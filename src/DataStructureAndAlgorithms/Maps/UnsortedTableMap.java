package DataStructureAndAlgorithms.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {
    }

    // Returns the index of an entry with equal key, or −1 if none found.
    public int findIndex(K key) {
        int n = table.size();
        for (int j = 0; j < n; j++)
            if (table.get(j).getKey().equals(key))
                return j;
        return -1; // special value denotes that key was not found
    }

    // Returns the number of entries in the map.
    public int size() {
        return table.size();
    }

    // Returns the value associated with the specified key (or else null).
    public V get(K key) {
        int j = findIndex(key);
        if (j == -1) return null;
        return table.get(j).getValue();
    }

    // Associates given value with given key, replacing a previous value (if any)
    public V put(K key, V value) {
        int j = findIndex(key);
        if (j == -1) {
            table.add((new MapEntry<>(key, value))); // add new entry
            return null;
        } else return table.get(j).getValue(); // key already exists, replaced value is returned
    }

    // Removes the entry with the specified key (if any) and returns its value.
    public V remove(K key) {
        int j = findIndex(key);
        int n = size();
        if (j == -1) return null;
        V answer = table.get(j).getValue();
        if (j != n - 1)
            table.set(j, table.get(n - 1)); // relocate last entry to ’hole’ created by removal
        table.remove((n - 1)); // remove last entry of table
        return answer;
    }

    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        private int j = 0;

        public boolean hasNext() {
            return j < table.size();
        }

        public Map.Entry<K, V> next() {
            if (j == table.size()) throw new NoSuchElementException();
            return table.get(j++);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class EntryIterable implements Iterable<Map.Entry<K, V>> {
        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    // Returns an iterable collection of all key-value entries of the map
    public Iterable<Map.Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
