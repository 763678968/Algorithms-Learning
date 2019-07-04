import java.util.*;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<Integer>();
        int rdm = 0;
        for (int i = 0; i < 20; i++) {
            rdm = (int)(1 + Math.random()*100);
            vec.add(rdm);
        }
        print_vector(vec);
    }

    public static void print_vector(Vector<Integer> vec) {
        System.out.print("数组大小：" + vec.size() + ", 数组元素：");
        for (int i : vec)
            System.out.print(i + " ");
    }
}
