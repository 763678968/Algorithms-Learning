import java.util.*;

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < num.length; i++) {
            begin = i - size + 1;
            if (q.isEmpty())
                q.add(i);
            // 判断当前最大值是否已经从窗口中滑出
            else if (begin > q.peekFirst())
                q.pollFirst();

            // 将双端队列中的队尾元素与当前元素进行比较
            // 如果队尾元素小于当前元素，则删除队尾元素
            while ((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            // 再将当前元素插入队尾
            q.add(i);
            if (begin >= 0)
                // 队列的第一个位置保存当前窗口的最大值
                res.add(num[q.peekFirst()]);
        }
        return res;
    }
}
