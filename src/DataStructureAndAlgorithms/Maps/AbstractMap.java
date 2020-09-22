package DataStructureAndAlgorithms.Maps;

import java.util.Map.Entry;
import java.util.Iterator;

public abstract class AbstractMap<K, V> implements Map<K, V> {
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    //---------------- nested MapEntry class ----------------
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = value;
            this.value = value;
            return old;
        }
    }//----------- end of nested MapEntry class -----------

    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public K next() {
            return entries.next().getKey();
        } // return key!

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class keyIterable implements Iterable<K> {
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }
    }

    public Iterable<K> keySet() {
        return new keyIterable();
    }

    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public V next() {
            return entries.next().getValue();
        } // return value!

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class ValueIterable implements Iterable<V> {
        public Iterator<V> iterator() {
            return new ValueIterator();
        }
    }

    public Iterable<V> values() {
        return new ValueIterable();
    }
}
