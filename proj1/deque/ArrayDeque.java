package deque;


public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int nextFirst, nextLast;
    private int size;

    /*Get an generic array*/

    public ArrayDeque(){
         items = getItems(8);
         nextFirst = 4;
         nextLast = 5;
         size = 0;
    }
    public void addFirst(T item){
        if (size == items.length){
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size++;
    }
    public void addLast(T item){
        if (size == items.length){
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1 ) % items.length;
        size++;
    }

//    public boolean isEmpty(){
//        return size == 0;
//    }
    public int size(){
        return size;
    }
    public void printDeque(){
        for (int i = 0; i < size; i++){
            T item = get(i);
            System.out.print(item + " ");
        }
        System.out.print("\n");
    }
    public T removeFirst(){
        T item = get(0);
        if (size < items.length / 4){
            resize(items.length / 4);
        }
        items[first()] = null;
        nextFirst = first();
        size--;
        return item;
    }
    public T removeLast(){
        T item = get(size - 1);
        if (size < items.length / 4){
            resize(items.length / 4);
        }
        items[last()] = null;
        nextLast = last();
        size--;
        return item;
    }
    public T get(int index){
        return items[(first() + index) % items.length];
    }
//    public Iterator<T> iterator(){}
//    public boolean equals(Object o){}
    private int first(){
        return (nextFirst + 1) % items.length;
    }

    private int last(){
        return (nextLast - 1 + items.length) % items.length;
    }

    private T[] getItems(int capacity){
        return (T[])new Object[capacity];
    }

    /*Resize the array*/
    private void resize (int capacity){
        T[] newItems = getItems(capacity);
        for (int i = 0; i < size; i++){
            newItems[i] = get(i);
        }
        nextFirst = capacity - 1;
        nextLast = size;
        items = newItems;
    }
}
