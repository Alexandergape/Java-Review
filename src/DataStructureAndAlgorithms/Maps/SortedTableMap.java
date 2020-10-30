// package DataStructureAndAlgorithms.Maps;

// import java.util.ArrayList;
// import java.util.Comparator;

// public class SortedTableMap<K, V> extends AbstractSortedMap<K, V> {
//    //        @Override
// //        Object get(Object o){
// //
// //        }
//    private ArrayList<AbstractMap.MapEntry<K, V>> table = new ArrayList<>();

//    public SortedTableMap() {
//        super();
//    }

//    public SortedTableMap(Comparator<K> comp) {
//        super(comp);
//    }

//    // Returns the smallest index for range table[low..high] inclusive storing an entry
//    //with a key greater than or equal to k (or else index high+1, by convention). ∗/
//    private int findIndex(K key, int low, int high) {
//        if (high < low) return high + 1; // no entry qualifies
//        int mid = (low + high) / 2;
//        int comp = compare(key, table.get(mid));
//        if (comp == 0)
//            return mid; // found exact match
//        else if (comp < 0)
//            return findIndex(key, low, mid - 1); // answer is left of mid (or possibly mid)
//        else
//            return findIndex(key, mid + 1, high); // answer is right of mid
//    }

//    //Version of findIndex that searches the entire table ∗/
//    private int findIndex(K key) {
//        return findIndex(key, 0, table.size() - 1);
//    }

//    //Returns the number of entries in the map. ∗/
//    public int size() {
//        return table.size();
//    }

//    //Returns the value associated with the specified key (or else null). ∗/
//    @Override
//    public V get(K key) {
//        int j = findIndex(key);
//        if (j == size() || compare(key, table.get(j)) != 0) return null; // no match
//        return table.get(j).getValue();
//    }

//    // Associates the given value with the given key, returning any overridden value.∗/
//    public V put(K key, V value) {
//        int j = findIndex(key);
//        if (j < size() && compare(key, table.get(j)) == 0) // match exists
//            return table.get(j).setValue(value);
//        table.add(j, new MapEntry<K, V>(key, value)); // otherwise new
//        return null;
//    }

//    //Removes the entry having key k (if any) and returns its associated value. ∗/
//    public V remove(K key) {
//        int j = findIndex(key);
//        if (j == size() || compare(key, table.get(j)) != 0) return null; // no match
//        return table.remove(j).getValue();
//    }
// }
