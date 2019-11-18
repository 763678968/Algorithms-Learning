import java.util.ArrayList;
public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 0)
            return 0;
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < index) {// 循环的条件
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (m2 == min) i2++;
            if (m3 == min) i3++;
            if (m5 == min) i5++;
        }
        return list.get(list.size() - 1);
    }
}
