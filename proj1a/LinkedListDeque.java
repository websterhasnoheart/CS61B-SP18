public class LinkedListDeque<T> {
    private class Node{
        private Node prev;
        private Node next;
        private T item;

        public Node(LinkedListDeque<T>.Node prev,T item,LinkedListDeque<T>.Node next){
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null,(T) new Object(),null);
        //make the deque a circular linkedList
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /*Create a deep copy of linkedList */
    public LinkedListDeque(LinkedListDeque<T> other){
        sentinel = new Node(null, (T) new Object(),null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for(int i = 0; i < other.size();i++){
            addLast(other.get(i));
        }
    }

    /* Add an item in front of the circular list*/
    public void addFirst(T item){
        Node firstNode = new Node(sentinel,item,sentinel.next);
        sentinel.next.prev = firstNode;
        sentinel.next = firstNode;
        size++;
    }

    /* Add an item at the end of the circular list*/
    public void addLast(T item){
        Node lastNode = new Node(sentinel.prev,item,sentinel);
        sentinel.prev.next = lastNode;
        sentinel.prev = lastNode;
        size++;
    }

    /* Return true if the list is empty otherwise return false*/
    public boolean isEmpty(){
        return size == 0;
    }
    /* Return the size of the list excluding sentinel node*/
    public int size(){
        return size;
    }

    /*Print the item of each node */
    public void printDeque(){
        for(Node i = sentinel.next; i != sentinel; i = i.next){
            if(i.next == sentinel){
                System.out.println(i.item);
                break;
            }
            System.out.print(i.item + " ");
        }
    }

    /* Remove the first node and return its item */
    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        T removedItem = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return removedItem;
    }

    /* Remove the last node and return its item*/
    public T removeLast(){
        if(this.isEmpty()){
            return null;
        }
        T removedItem = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return removedItem;
    }

    /*Get the item from given index where 0 is the first, and 1 is the next item and so forth */
    public T get(int index){
        if(size < index){
            return null;
        }
        Node node = sentinel.next;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node.item;
    }

    /* Use recursion to get an item by given index */
    public T getRecursive(int index){
        if(index > size){
            return null;
        }

        Node p = sentinel.next;
        return getRecrusive(p,index);
    }

    public T getRecrusive(Node node,int index){
        if(index == 0){
            return node.item;
        }else{
            node = node.next;
            index--;
        }
        return getRecrusive(node,index);
    }



    public static void main(String[] args) {
        LinkedListDeque<Integer> list = new LinkedListDeque<Integer>();
        list.addFirst(1);
        list.addLast(2);
        list.printDeque();

    }



}
