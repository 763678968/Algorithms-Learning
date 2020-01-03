// 蓄水池抽样算法
class reservoirSampling {
    // 从N个元素中等概率地选出K个
    public static int[] sampling(int K, int N) {
        if (N < 1 || K < 1 || N < K) {
            return null;
        }
        // 初始化所有数据
        int[] dataStream = new int[N];
        for (int i = 0; i < N; i++) {
            dataStream[i] = i;
        }

        int[] reservoir = new int[K];
        for (int i = 0; i < K; i++) {
            // 前K个数据直接放进数组中
            reservoir[i] = dataStream[i];
        }

        Random rand = new Random();
        // 第K + 1个元素开始进行概率采样
        for (int i = K; i < N; i++) {
            // 等概率的返回下标为[0, i]中的
            int index = rand.nextInt(i + 1);
            if (index < K) {
                // 用dataStream[i]替换掉reservoir[index]，index是等概率选中的
                reservoir[index] = dataStream[i];
            }
        }
        return reservoir;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sampling(20, 10000)));
    }
}