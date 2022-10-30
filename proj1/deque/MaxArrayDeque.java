package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque {
    private Comparator cpt;
    public MaxArrayDeque(Comparator<T> c){
        cpt = c;
    }
    public T max(){
        T max = (T)get(0);
        for (int i = 1; i < size(); i++){
            if(cpt.compare(max, get(i)) < 0){
                max = (T)get(i);
            }
        }
        return max;
    }
    public T max(Comparator<T> c){
        T max = (T)get(0);
        for (int i = 1; i < size(); i++){
            if(c.compare(max, (T)get(i)) < 0){
                max = (T)get(i);
            }
        }
        return max;
    }
}
