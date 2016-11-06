import java.io.IOException;
import java.util.Scanner;

/**
 * Created by mikdev on 10/28/16.
 */
public class _2SideStack {
    int[] Array;
    int Max;
    int TopFromFirst;
    int TopFromEnd;

    public _2SideStack(Scanner input) {
        this(input.nextInt());
    }

    public _2SideStack(int max) {
        Max = max;
        TopFromFirst = -1;
        TopFromEnd = max;
        Array = new int[Max];
    }

    public boolean push(int item) {
        if (TopFromFirst <= TopFromEnd) {
            if (TopFromFirst == Max - 1) return false;

            TopFromFirst++;
            Array[TopFromFirst] = item;
            return true;
        }
        throw new RuntimeException();
    }

    public int pop() {
        if (TopFromFirst <= TopFromEnd) {
            if (TopFromFirst == -1)
                throw new RuntimeException();

            TopFromFirst--;
            return Array[TopFromFirst + 1];
        }
        throw new RuntimeException();
    }

    public boolean pushFromEnd(int item) {
        if (TopFromFirst <= TopFromEnd) {
            if (TopFromFirst == Max) return false;

            TopFromEnd--;
            Array[TopFromEnd] = item;
            return true;
        }
        throw new RuntimeException();
    }

    public int popFromEnd() {
        if (TopFromFirst <= TopFromEnd) {
            if (TopFromEnd == 0)
                throw new RuntimeException();

            TopFromEnd++;
            return Array[TopFromEnd - 1];
        }
        throw new RuntimeException();
    }

    public void print() {
        for (int i = 0; i < Array.length; i++) {
            System.out.println(Array[i]);
        }
    }
}