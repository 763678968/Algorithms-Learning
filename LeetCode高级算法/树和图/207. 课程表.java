class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[][] matrix = new int[numCourses][numCourses]; // i -> j
        int[] indegree = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            int ready = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (matrix[pre][ready] == 0)
                indegree[ready]++; // duplicate case
            matrix[pre][ready] = 1;
        }
        
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] != 0) {
                    if (--indegree[i] == 0)
                        queue.offer(i);
                }
            }
        }
        return count == numCourses;
    }
}
// BFS Topological sort广度优先搜索拓扑排序，很慢

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            graph.add(new ArrayList<>());
        for(int[] n:prerequisites)
        {
            graph.get(n[0]).add(n[1]);
        }
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++)
            if(DFS(i,graph,visited))
                return false;
        return true;
    }
    public boolean DFS(int curr,ArrayList<ArrayList<Integer>> graph,int[] visited)
    {
        //递归结束条件
        if(visited[curr]==1)//这个节点已经被访问
            return true;
        if(visited[curr]==2)//这个节点没有被访问
            return false;
         
        //业务逻辑处理
        visited[curr]=1;//表示正在访问
        for(int id:graph.get(curr))
            if(DFS(id,graph,visited))
                return true;
        visited[curr]=2;//表示已经访问
        return false;
    }
}
// 方法二
