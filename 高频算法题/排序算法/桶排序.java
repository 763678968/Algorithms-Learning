public class Solution {
    public static ArrayList<Integer> bucketSort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        // 划分桶的数量
        int bucketCount = (max - min) / bucketSize + 1;
        // 创建桶的集合
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        // 创建结果集
        ArrayList<Integer> resultArr = new ArrayList<>();
        // 创建桶
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将元素放入桶中
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        // 将桶中元素放入结果集中
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) {
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                // 递归调用bucketSort方法
                ArrayList<Integer> temp = bucketSort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 5, 3, 542, 748, 14, 214);
        System.out.println(bucketSort(list, 3).toString());;
    }
}