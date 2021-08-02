public class LinkedListDeque<T> implements Deque<T> {

    private class Node {
        private Node prev;
        private Node next;
        private T item;

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    private Node sentinel;
    private int size;

    /* Constructor for a new LinkedListDeque*/
    public LinkedListDeque() {
        sentinel = new Node(null, (T) new Object(), null);
        //make the deque a circular linkedList
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

//    /*Create a deep copy of linkedList */
//    public LinkedListDeque(LinkedListDeque<T> other) {
//        sentinel = new Node(null, (T) new Object(), null);
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//
//        for(int i = 0; i < other.size();i++){
//            addLast(other.get(i));
//        }
//    }

    /* Add an item in front of the circular list*/
    @Override
    public void addFirst(T item) {
        Node firstNode = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = firstNode;
        sentinel.next = firstNode;
        size++;
    }

    /* Add an item at the end of the circular list*/
    @Override
    public void addLast(T item) {
        Node lastNode = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = lastNode;
        sentinel.prev = lastNode;
        size++;
    }

    /* Return the size of the list excluding sentinel node*/
    @Override
    public int size() {
        return size;
    }

    /*Print the item of each node */
    @Override
    public void printDeque() {
        for (Node i = sentinel.next; i != sentinel; i = i.next) {
            if (i.next == sentinel) {
                System.out.println(i.item);
                break;
            }
            System.out.print(i.item + " ");
        }
    }

    /* Remove the first node and return its item */
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }
        T removedItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return removedItem;
    }

    /* Remove the last node and return its item*/
    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }
        T removedItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return removedItem;
    }

    /*Get the item from given index where 0 is the first, and 1 is the next item and so forth */
    @Override
    public T get(int index) {
        if (size < index) {
            return null;
        }
        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    /* Use recursion to get an item by given index */
    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }

        Node p = sentinel.next;
        return getRecrusive(p, index);
    }

    /* getRecursive helper method */
    private T getRecrusive(Node node, int index) {
        if (index == 0) {
            return node.item;
        } else {
            node = node.next;
            index--;
        }
        return getRecrusive(node, index);
    }
}

