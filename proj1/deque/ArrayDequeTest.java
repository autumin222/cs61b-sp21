package deque;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertTrue;

public class ArrayDequeTest {
    @Test
    /*Add some items in the ArrayDeque, and show them out
    * checking addFirst(), addLast(), size(), isEmpty()*/
    public void showTest(){
        ArrayDeque<String> lst = new ArrayDeque<>();
        assertTrue(lst.isEmpty());

        lst.addLast("first");
        lst.addLast("second");
        assertEquals(2, lst.size());

        lst.addFirst("third");
        lst.addFirst("forth");
        assertEquals(4, lst.size());

        System.out.println("Printing out deque: ");
        lst.printDeque();
    }

    @Test
    /*Put a pile of numbers in the deque to check the resize() and get()*/
    public void bigDequeTest(){
        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        assertEquals(1000000, lld1.size());

        for (int i = 0; i < 1000000; i++){
            assertEquals(i, (int)lld1.get(i));
        }
    }

    @Test
    /*Check the removeFirst() and removeLast()*/
    public void removeTest(){
        ArrayDeque<Integer> lst = new ArrayDeque<>();
        for (int i = 0; i < 1000; i++){
            lst.addFirst(i);
        }

        for (int i = 999; i >= 0; i--){
            assertEquals(i, (int)lst.removeFirst());
        }
    }
}
