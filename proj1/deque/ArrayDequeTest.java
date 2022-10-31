package deque;

import edu.princeton.cs.algs4.StdRandom;
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

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        int N = 1000000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 6);
            if (operationNumber == 0) {
                int randVal = StdRandom.uniform(0, 100);
                arrayDeque.addFirst(randVal);
            } else if (operationNumber == 1) {
                int randVal = StdRandom.uniform(0, 100);
                arrayDeque.addLast(randVal);
            } else if (arrayDeque.size() == 0) {
                assertTrue(arrayDeque.isEmpty());
            } else if (operationNumber == 2) {
                assertTrue(arrayDeque.size() > 0);
            } else if (operationNumber == 3) {
                arrayDeque.removeFirst();
            } else if (operationNumber == 4) {
                arrayDeque.removeLast();
            } else if (operationNumber == 5) {
                int randIndex = StdRandom.uniform(0, arrayDeque.size());
                arrayDeque.get(randIndex);
            }
        }
    }
}
