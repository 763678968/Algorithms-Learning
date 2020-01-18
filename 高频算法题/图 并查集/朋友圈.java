class Solution {
    public int findCircleNum(int[][] M) {
        // visited数组表示第i个被遍历过的人
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int person) {
        for (int other = 0; other < M.length; other++) {
            // 找到一个在当前朋友圈中，没有遍历过的人
            if (M[person][other] == 1 && !visited[other]) {
                visited[other] = true;
                // 从这个新找到的人开始，继续深度优先搜索
                dfs(M, visited, other);
            }
        }
    }
}