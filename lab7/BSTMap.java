import java.util.Iterator;
import java.util.Set;

public class BSTMap <K extends Comparable<K>, V> implements Map61B<K,V> {

    private Node root;

    private class Node {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        private Node(K k, V v) {
            key = k;
            value = v;
            size = 1;
        }
    }


    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root, key);
    }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    private V get(Node x, K key) {
        if (key == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.size;
    }

    @Override
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node x) {
        if (x.left == null && x.right == null) {
            printNode(x);
        } else if (x.right == null) {
            printInOrder(x.left);
            printNode(x);
        } else if (x.left == null) {
            printInOrder(x.right);
            printNode(x);
        } else {
            printInOrder(x.left);
            printInOrder(x.right);
            printNode(x);
        }
    }

    private void printNode(Node x) {
        System.out.println(x.key);
        System.out.println(" " + x.value);
    }
}
