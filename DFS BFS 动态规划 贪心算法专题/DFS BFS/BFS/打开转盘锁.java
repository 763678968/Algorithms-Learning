// LeetCode 752.打开转盘锁
class Solution {
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡数字
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        // 记录已经穷举过的数字，防止走回头路
        Set<String> visited = new HashSet<>();
        // 从起点开始广度优先搜索
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            // 从队列中取出上层节点
            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                // 截止条件
                // 如果死亡数字中包含当前的组合，就跳过
                if (deads.contains(current)) {
                    continue;
                }
                if (current.equals(target)) {
                    return step;
                }

                // 将下一层节点添加到队列中(每个转盘有向上/向下拨两种状态，共计8种情况)
                // 使用visited集合排除掉重复元素
                for (int j = 0; j < 4; j++) {
                    String plus = plusOne(current, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }

                    String minus = minusOne(current, j);
                    if (!visited.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            // 增加步数
            step++;
        }
        // 如果穷举完都找不到目标密码，也就表明无法找到
        return -1;
    }

    // 向上拨动一次
    private String plusOne(String str, int index) {
        char[] chars = str.toCharArray();
        if (chars[index] == '9') {
            chars[index] = '0';
        } else {
            chars[index] += 1;
        }
        return new String(chars);
    }

    // 向下拨动一次
    private String minusOne(String str, int index) {
        char[] chars = str.toCharArray();
        if (chars[index] == '0') {
            chars[index] = '9';
        } else {
            chars[index] -= 1;
        }
        return new String(chars);
    }
}