package bstmap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private class BST{
        public K key;
        public V value;
        public BST left;
        public BST right;
        public BST(K k, V v){
            key = k;
            value = v;
        }
    }
    private BST bst;
    private int size;

    @Override
    public void clear() {
        size = 0;
        bst = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (bst == null){
            return false;
        }
        return find(bst, key) != null;
    }

    @Override
    public V get(K key) {
        BST result = find(bst, key);
        if (result != null)
            return result.value;
        else
            return null;
    }

    public BST find(BST T, K k){
        if (T == null)
            return null;
        if (k.equals(T.key))
            return T;
        else if (k.compareTo(T.key) < 0)
            return find(T.left, k);
        else
            return find(T.right, k);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {
        size++;
        bst = put(bst, key, value);
    }
    public BST put(BST T, K k, V v){
        if (T == null){
            return new BST(k, v);
        }
        else if (k.compareTo(T.key) < 0){
            T.left = put(T.left, k, v);
        }
        else if (k.compareTo(T.key) > 0){
            T.right = put(T.right, k, v);
        }
        return T;
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
}