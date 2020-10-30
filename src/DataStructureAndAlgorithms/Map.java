package DataStructureAndAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Map<K, V> {
    static class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        public HashNode() {
        }

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<HashNode<K, V>> bucket = new ArrayList<>();
    int numBuckets = 10;
    int size;

    public Map() {
        for (int i = 0; i < numBuckets; i++) {
            bucket.add(null);
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getBucketIndex(K key) {
        int hashCod = key.hashCode();
        return hashCod % numBuckets;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(index);
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(index);
        if (head == null) {
            return null;
        }
        if (head.key.equals(key)) {
            V val = head.value;
            head = head.next;
            bucket.set(index, head);
            size--;
            return val;
        } else {
            HashNode<K, V> prev = null;
            while (head != null) {

                if (head.key.equals(key)) {
                    prev.next = head.next;
                    size--;
                    return head.value;
                }
                prev = head;
                head = head.next;
            }
            size--;
            return null;
        }
    }

    public void add(K key, V value) {

        int index = getBucketIndex(key);
        // System.out.println(index);
        HashNode<K, V> head = bucket.get(index);
        HashNode<K, V> toAdd = new HashNode<>();
        toAdd.key = key;
        toAdd.value = value;
        if (head == null) {
            bucket.set(index, toAdd);
            size++;

        } else {
            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    size++;
                    break;
                }
                head = head.next;
            }
            if (head == null) {
                head = bucket.get(index);
                toAdd.next = head;
                bucket.set(index, toAdd);
                size++;
            }
        }
        if ((1.0 * size) / numBuckets > 0.7) {
            // do something
            ArrayList<HashNode<K, V>> tmp = bucket;
            bucket = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            for (int i = 0; i < numBuckets; i++) {
                bucket.add(null);
            }
            for (HashNode<K, V> headNode : tmp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new Map<>();
        map.add("this", 1);
        System.out.println(map.remove("this"));
        // System.out.println(map.remove("this"));

        var MAP = new Map<Integer, String>();
        for (int i = 0; i <= 'Z'; i++)
            MAP.add(65+i, "A"+i);

        // MAP.add((int) 'A', "AA");

        for (HashNode<Integer, String> HN : MAP.bucket)
            if (HN != null)
                System.out.println(HN.key + "\t" + HN.value);

        // System.out.println(MAP.get((int)'A').toString());
        MAP.get((int) 'A');
        // for (int i = 'A'; i < 'Z'; i++)
        // System.out.println(MAP.get(i).charValue());

        System.out.println();
        // var hashMap = new HashMap<Integer, Character>();
        // for (int i = 'A'; i <= 'Z'; i++)
        // hashMap.put(i, (char) i);

        // hashMap.put((int) 'A', 'Z');
        // System.out.println(hashMap.get((int) 'A'));

        // System.out.println("HASHTABLE::");
        // var HT= new Hashtable<Integer, Character>();

        // // HT.put(1, 'A');

        // for (int i = 'A'; i <= 'Z'; i++)
        // HT.put(i, (char)i);

        // for (Character character : HT.values()) {
        // System.out.println(character);
        // }

        // for(int i = 'A'; i <= 'Z'; i++)
        // System.out.println(hashMap.get(i));
    }
}
