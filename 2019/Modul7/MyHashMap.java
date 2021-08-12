package Modul7;

import java.util.*;

public class MyHashMap<K extends Comparable, V extends Comparable> implements MyMap<K, V> {
    /**
     * Hash table is an array with each cell that is a linked list
     */
    private ArrayList<LinkedList<Entry<K, V>>> table;

    /**
     * Specify a load factor used in the hash table
     */
    private double loadFactorThreshold = DEFAULT_MAX_LOAD_FACTOR;

    /**
     * Current hash table capacity. Capacity is a power of 2
     */
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    /**
     * The number of entries in the map
     */
    private int size = 0;

    /**
     * Construct a map with the default capacity and load factor
     */
    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    /**
     * Construct a map with the specified initial capacity and default load factor
     */
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    /**
     * Construct a map with the specified initial capacity and load factor
     */
    public MyHashMap(int initialCapacity, double loadFactorThreshold) {
        capacity = initialCapacity > MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY : trimToPowerOf2(initialCapacity);
        this.loadFactorThreshold = loadFactorThreshold;
        table = new ArrayList<>(Collections.nCopies(capacity, null));
    }


    /**
     * Add an entry (key, value) into the map
     */
    @Override
    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("Input cannot be Null!");
        }
        // Rehash the table if there is too big of an load
        if (size >= capacity * loadFactorThreshold) {
            rehash();
        }

        // Get index for key by hashing
        int index = hash(key.hashCode());

        // Create a linked list for the bucket if it is not created
        if (table.get(index) == null) {
            table.set(index, new LinkedList<>());
        }

        // Add an entry (key, value) to hashTable[index]
        table.get(index).add(new Entry<>(key, value));
        size++;

        return value;
    }

    /**
     * Remove the entries for the specified key
     */
    @Override
    public void remove(K key) {
        if (key == null) {
            throw new NullPointerException("Input cannot be Null!");
        }
        LinkedList<Entry<K, V>> list = table.get(hash(key.hashCode()));

        if (list == null) {
            return;
        }
        var iterator = list.iterator();
        while (iterator.hasNext()) {
            if (key.equals(iterator.next().getKey())) {
                iterator.remove();
                size--;
            } else return;
        }
    }


    /**
     * Return the first value that matches the specified key
     */
    @Override
    public V get(K key) {
        LinkedList<Entry<K, V>> list = table.get(hash(key.hashCode()));
        if (key == null) {
            throw new NullPointerException("Key cannot be Null!");
        }

        if (list == null) {
            return null;
        }

        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Return a set of entries in the map
     */
    @Override
    public Set<Entry<K, V>> entries() {
        Set<Entry<K, V>> set = new HashSet<>();

        for (LinkedList<Entry<K, V>> list : table) {
            if (list != null) {
                set.addAll(list);
            }
        }

        return set;
    }

    /**
     * Return a set consisting of the values in this map
     */
    @Override
    public Set<V> values() {
        Set<V> set = new HashSet<>();

        for (Entry<K, V> entry : entries()) {
            set.add(entry.getValue());
        }

        return set;
    }

    /**
     * Return a set consisting of the keys in this map
     */
    @Override
    public Set<K> keys() {
        Set<K> set = new HashSet<>();

        for (Entry<K, V> entry : entries()) {
            set.add(entry.getKey());
        }

        return set;
    }

    /**
     * Return the number of mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Remove all of the entries from this map
     */
    @Override
    public void clear() {
        capacity = DEFAULT_INITIAL_CAPACITY;
        table = new ArrayList<>(Collections.nCopies(capacity, null));
        size = 0;
    }

    /**
     * Return true if this map contains the value
     */
    @Override
    public boolean containsValue(V value) {
        for (Entry<K, V> entry : entries()) {
            if (entry.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Set<V> getAll(K key) {
        if (key == null) {
            throw new NullPointerException("Input cannot be Null!");
        }
        LinkedList<Entry<K, V>> list = table.get(hash(key.hashCode()));
        Set<V> set = new HashSet<>();

        if (list == null) {
            return set;
        }

        for (Entry<K, V> entry : list) {
            if (entry.getKey().equals(key)) {
                set.add(entry.getValue());
            }
        }

        return set;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Entry<K, V> entry : entries()) {
            builder.append(entry);
        }

        return builder.toString();
    }

    /**
     * Hash function
     */
    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    /**
     * Ensure the hashing is evenly distributed
     */
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Return a power of 2 for goalCapacity
     */
    private int trimToPowerOf2(int goalCapacity) {
        int capacity = 1;
        while (capacity < goalCapacity) {
            capacity <<= 1;
        }

        return capacity;
    }

    /**
     * Rehash the map
     */
    private void rehash() {
        if (capacity == MAXIMUM_CAPACITY) {
            throw new RuntimeException("Exceeding maximum capacity");
        }

        capacity <<= 1; // Double capacity

        Set<Entry<K, V>> set = entries(); // Get entries
        table = new ArrayList<>(Collections.nCopies(capacity, null)); // Create a new hash table
        size = 0; // Clear size

        for (Entry<K, V> entry : set) {
            put(entry.getKey(), entry.getValue()); // Store to new table
        }
    }
}

