import java.util.AbstractMap;
import java.util.*;

public class SkipList<K extends Comparable<? super K>, V> extends AbstractMap<K, V> {

    private static class SkipListNode<K, V> {
        private K key;
        private V value;
        public ArrayList<SkipListNode<K, V> > nextNodes;

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public SkipListNode(K key, V value) {
            this.value = value;
            this.key = key;
            nextNodes = new ArrayList<SkipListNode<K, V> >();
        }

        public int level() {
            return nextNodes.size()-1;
        }

        public String toString() {
            return new StringBuilder().append("[").append(key).append(", ").append(value).append("]").toString();
        }
    }


    private SkipListNode<K,V> head;
    private int maxLevel;
    private int size;
    private Random rnd;

    private static final double PROBABILITY = 0.5;
    private Comparator<K> comp;

    protected SkipList(Comparator<K> c) { comp = c; }


    /** Method for comparing two entries according to key */
    protected int compare(K a, K b) {
        return comp.compare(a, b);
    }

    public SkipList() {
        this(new DefaultComparator<K>());
        rnd = new Random();
        size = 0;
        maxLevel = 0;
        // a SkipListNode with value null marks the beginning
        head = new SkipListNode<K, V>(null, null);
        // null marks the end
        head.nextNodes.add(null);
    }

    public SkipListNode getHead() {
        return head;
    }

    // Adds e to the skiplist.
    // Returns false if already in skiplist, true otherwise.
    public V put(K k, V v) {
        // TODO
        return null;
    }

    @Override
    public V remove(K key) {
        // TODO
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        // TODO
        return null;
    }

    // Returns the skiplist node with greatest value <= e
    private SkipListNode find(K k) {
        return find(k, head, maxLevel);
    }

    // Returns the skiplist node with greatest value <= e
    // Starts at node start and level
    private SkipListNode find(K k, SkipListNode current, int level) {
        // TODO
        return null;
    }

    // Returns the node at a given level with highest value less than e
    private SkipListNode findNext(K k, SkipListNode current, int level) {
        // TODO
        return null;
    }

    public int size() {
        return size;
    }

    @Override
    public V get(K key) {
        // TODO
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int level = 0;
        SkipListNode current = (SkipListNode) head.nextNodes.get(level);

        while(current != null) {
            sb.append(current.toString()).append(", ");
            current = (SkipListNode)current.nextNodes.get(level);
        }
        sb.append(")");
        return sb.toString();
    }

    /******************************************************************************
     * Testing                                                                     *
     ******************************************************************************/

    public static void main(String[] args) {
        SkipList testList = new SkipList<Integer, String>();
        System.out.println(testList);

        testList.put(4, "four");
        System.out.println(testList);
        testList.put(1, "one");
        System.out.println(testList);

//        for(Integer k : testList.keySet()) {
//            System.out.println(k);
//        }
//
//        for(String s : testList.values()) {
//            System.out.println(s);
//        }
    }


}