import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arl = new ArrayList<Integer>();
        int rdm = 0;
        for (int i = 0; i < 20; i++) {
            rdm = (int)(1 + Math.random()*100);
            arl.add(rdm);
        }
        print_arraylist(arl);
        arl.add(7);
        print_arraylist(arl);
        arl.add(12, 13);
        print_arraylist(arl);
        // 在该数组的第17个位置插入数组[3, 2, 1]
    }

    private static void print_arraylist(ArrayList<Integer> arl) {
        System.out.print("数组大小：" + arl.size() + ", 数组元素：");
        for (int i : arl)
            System.out.print(i + " ");
        System.out.println();
    }

}
