package DataStructureAndAlgorithms.Maps;

import java.util.Map.Entry;

public interface Map<K, V> { // key , Value
    int size();

    boolean isEmpty();

    V get(K key);

    V put(K key, V valur);

    Iterable<K> keySet();

    Iterable<V> values();

    Iterable<Entry<K, V>> entrySet();
}
