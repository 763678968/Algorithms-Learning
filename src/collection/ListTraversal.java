package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTraversal {
    public static void main(String[] args) {
        // List集合的遍历
        listTest();
    }

    private static void listTest() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("animation");

        // 使用Iterator遍历
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }

        // 使用传统for循环进行遍历
        for (int i = 0, size = list.size(); i < size; i++) {
            String value = list.get(i);
            System.out.println(value);
        }

        // 使用foreach循环进行遍历
        for (String value : list) {
            System.out.println(value);
        }

    }
}
