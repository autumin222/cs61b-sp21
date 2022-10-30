package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>{
    private Node sentinel;
    private int size;
    private class Node{
        public T item;
        public Node next;
        public Node pre;
        public Node(T i, Node p, Node n){
            item = i;
            pre = p;
            next = n;
        }
    }
    public LinkedListDeque(){
        Node node = new Node(null, null, null);
        node.next = node;
        node.pre = node;
        sentinel = node;
        size = 0;
    }
    public void addFirst(T item){
        Node newNode = new Node(item, sentinel,sentinel.next);
        sentinel.next = newNode;
        sentinel.pre = newNode;
        size++;
    };
    public void addLast(T item){
        Node newNode = new Node(item, sentinel.pre, sentinel);
        sentinel.pre.next = newNode;
        sentinel.pre = newNode;
        size++;
    };
//    public boolean isEmpty(){
//        return size() == 0;
//    };
    public int size(){
        return size;
    };
    public void printDeque(){
        for(Node n = sentinel.next; n != sentinel; n = n.next){
            System.out.print(n.item + " ");
        }
        System.out.println("\n");
    };
    public T removeFirst(){
        if(isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return item;
    };
    public T removeLast(){
        if(isEmpty()) {
            return null;
        }
        T item = sentinel.pre.item;
        sentinel.pre.pre.next = sentinel;
        sentinel.pre = sentinel.pre.pre;
        size--;
        return item;
    };
    public T get(int index){
        Node n = sentinel.next;
        for (int i = 0; i < index; i++){
            n = n.next;
        }
        return n.item;
    };
//    public Iterator<T> iterator(){};
//    public boolean equals(Object o){};
}
