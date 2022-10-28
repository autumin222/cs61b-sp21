package randomizedtest;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> li1 = new AListNoResizing<>();
        BuggyAList<Integer> li2 = new BuggyAList<>();
        for(int i = 1; i < 3; i++){
            li1.addLast(i);
            li2.addLast(i);
        }
        assertEquals(li1.size(), li2.size());

        assertEquals(li1.removeLast(), li2.removeLast());
        assertEquals(li1.removeLast(), li2.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> test = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                test.addLast(randVal);
//                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int Lsize = L.size();
                int testsize = test.size();
                assertEquals(Lsize, testsize);
//                System.out.println("size: " + size);
            } else if (operationNumber == 2 && L.size() > 0) {
//                System.out.println("getLast(" + L.getLast() + ")");
                assertEquals(L.getLast(), test.getLast());
            } else if (operationNumber == 3 && L.size() > 0){
                L.removeLast();
                test.removeLast();
//                System.out.println("removeLast()");
            }
        }
    }
}
