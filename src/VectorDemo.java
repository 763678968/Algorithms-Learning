import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<Integer>();
        int rdm = 0;
        for (int i = 0; i < 20; i++) {
            rdm = (int)(1 + Math.random()*100);
            vec.add(rdm);
        }
        for (int i : vec)
            System.out.print(i + " ");
    }
}