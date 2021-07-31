public class ArrayDeque<T> {
    private T[] items;
    private final int INIT_CAPACITY  = 8;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque(){
        items = (T[]) new Object[INIT_CAPACITY];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /* get the last index */
    public int minusOne(int index){
        return Math.floorMod(index-1,items.length);
    }

    /* get the next index */
    public int plusOne(int index){
        return Math.floorMod(index+1, items.length);
    }

    public int plusOne(int index, int length) {
        return Math.floorMod(index+1, length);
    }

    public void addFirst(T item){
        resize();
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    public T getFirst(){
        return items[plusOne(nextFirst)];
    }

    public T removeFirst(){
        resize();
        T removedItem = getFirst();
        nextFirst = plusOne(nextFirst);
        items[nextFirst] = null;
        size--;
        return removedItem;
    }

    public void addLast(T item){
        resize();
        items[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
    }

    public T getLast(){
        return items[minusOne(nextLast)];
    }

    public T removeLast(){
        resize();
        T removedItem = getLast();
        nextLast = minusOne(nextLast);
        items[nextLast] = null;
        size--;
        return removedItem;
    }

    public void printDeque(){
        for(int index = plusOne(nextFirst);index != nextLast;index = plusOne(index)){
            System.out.print(items[index] + " ");
        }
        System.out.println();
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            return null;
        }
        index = Math.floorMod(plusOne(nextFirst) + index,items.length);
        return items[index];
    }

    /* Designing resize() method */
    private void resize(){
        if(size == items.length){
            expand();
        }
        if(size< (items.length)*0.25 && items.length > 8){
            reduce();
        }
    }

    private void expand(){
        resizeHelper(INIT_CAPACITY*2);
    }

    private void reduce(){
        resizeHelper(INIT_CAPACITY/2);
    }

    private void resizeHelper(int capacity){
        T[] tempArr = items;
        int begin = plusOne(nextFirst);
        int end = minusOne(nextLast);
        items = (T[]) new Object[capacity];
        nextFirst = 0;
        nextLast = 1;
        for(int i = begin; i != end; i = plusOne(i,tempArr.length)){
            items[nextLast] = tempArr[i];
            nextLast = plusOne(nextLast);
        }
        items[nextLast] = tempArr[end];
        nextLast = plusOne(nextLast);
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> array = new ArrayDeque<>();
//        array.addFirst(1);
//        array.addFirst(2);
//        array.addFirst(3);
//        array.addFirst(4);
//        array.addLast(99);
//        array.addLast(98);
//        array.addLast(97);
//        array.addLast(96);
//        array.addLast(95);
//        array.addLast(94);
//        array.removeFirst();
//        array.removeFirst();
//        array.removeFirst();
//        array.removeFirst();
//        array.removeFirst();
//        array.removeLast();
//        array.removeLast();
//        array.removeLast();
//        array.removeLast();
//    }


}
