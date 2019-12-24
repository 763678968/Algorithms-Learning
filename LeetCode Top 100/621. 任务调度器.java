class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 统计各个任务的出现频率，找到其中出现频率最高的一个或者多个任务的个数
        // maxCount表示频率并列最高的任务的个数，如：3A 3B，则maxCount = 2
        int[] counter = new int[26];
        // max表示最高任务频率，如：5A 4B 3C，则max = 5
        int max = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (max == counter[task - 'A']) {
                maxCount++;
            }
            else if (max < counter[task - 'A']) {
                max = counter[task - 'A'];
                maxCount = 1;
            }
        }

        /* 按照公式进行计算各个变量 */
        // 计算频率最高的任务之间的空当数,如A ? ? ? A ? ? ? A，3个A中间有个2个空当
        int partCount = max - 1;
        // 计算每个空当中有多少个空格(?)，如果有两种频率最高的任务，如：3A 3B, n = 3，则maxCouont = 2
        // 需要按照A B ? ? A B ? ? A B的规律排列，所以空格数等于3 - (2 - 1) = 2
        int partLength = n - (maxCount - 1);
        // 计算总空格数
        int emptySlots = partCount * partLength;
        // 计算剩余需要分配的非频率最高的任务数
        int availableTasks = tasks.length - max * maxCount;
        // 计算需要分配的待命状态个数
        // 这里需要注意，如果emptySlots为负数，表明partLength为负数，例如：3A 3B 3C 3D 3E, n = 2
        // 此时partLength = 2 - (5 - 1) = -2，这表示分配按照：A B C A B C A B C 这种间隔已经可以满足条件，不需要插入待命状态
        // 所以D E任务可以直接插入到A C之间：A B C D E A B C D E A B C D E
        int idles = Math.max(0, emptySlots - availableTasks);

        return idles + tasks.length;
    }
}
