package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTraversal {

    public static void main(String[] args) {
        // Set集合的遍历
        setTest();
    }

    private static void setTest() {
        Set<String> set = new HashSet<String>();
        set.add("JAVA");
        set.add("C");
        set.add("C++");

        // 重复数据添加失败
        set.add("JAVA");
        set.add("JAVASCRIPT");

        // 使用Iterator遍历Set集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String value = it.next();
            System.out.println(value);
        }

        // 使用foreach循环遍历Set集合
        for (String s : set) {
            System.out.println(s);
        }

    }
}
