public class Solution {
    public int findNumberAppearingOnce(int[] numbers) {
        if (numbers.length <= 0) {
            System.out.println("数组为空！");
            return -1;
        }

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) == null) {
                map.put(numbers[i], 1);
            } else {
                // 获取HashMap中某数字之前出现的次数count
                count = map.get(numbers[i]);
                // 如果该数字再次出现，将count加一，重新赋到map中
                map.put(numbers[i], ++count);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println(key);
                return key;
            }
        }
        System.out.println("数组中不存在只出现一次的数字！");
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] numbers = {-1,1,2,3,4,1,1,3,4,3,1};
//        int[] numbers = {0,0,0,1,4,4,5,5,5,4};
        s.findNumberAppearingOnce(numbers);
    }
}
