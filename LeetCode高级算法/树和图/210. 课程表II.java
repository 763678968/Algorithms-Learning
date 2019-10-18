class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int indegree[] = new int[numCourses], order[] = new int[numCourses], index = 0;
        for (int i = 0; i < prerequisites.length; i++) // Indegree - how many preprequisites are needed.
            indegree[prerequisites[i][0]]++;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) {
                // Add the course to the order because it has no prerequisites.
                order[index++] = i;
                queue.offer(i);
            }
        
        // How many courses don't need prerequisites.
        while (!queue.isEmpty()) {
            int prerequisite = queue.poll(); // Already finished this prerequisite course.
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == prerequisite) {
                    indegree[prerequisites[i][0]]--;
                    if (indegree[prerequisites[i][0]] == 0) {
                        // If indegree is zero, then add the course to the order.
                        order[index++] = prerequisites[i][0];
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return (index == numCourses) ? order : new int[0];
    }
}
// 方法一，较慢

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] nexts = new List[numCourses];
        int indegrees[] = new int[numCourses], t, pos = 0, res[] = new int[numCourses];
        for (int[] pre : prerequisites) {
            indegrees[pre[0]]++;
            t = pre[1];
            if (nexts[t] == null)
                nexts[t] = new ArrayList<>();
            nexts[t].add(pre[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0)
                queue.add(i);
        }
        // delete node -- reduce their indegree
        while (!queue.isEmpty()) {
            t = queue.removeFirst();
            res[pos++] = t;
            if (nexts[t] != null) {
                for (int i : nexts[t]) {
                    indegrees[i]--;
                    if (indegrees[i] == 0)
                        queue.add(i);
                }
            }
        }
        if (pos < numCourses)
            return new int[0];
        return res;
    }
}
// 方法二，较快，queue.removeFirst()方法
