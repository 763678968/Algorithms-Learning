// 创建最小生成树 -> 村庄的图
class MinTree {
    // 创建图的邻接矩阵
    /**
     *
     * @param graph 图对象
     * @param verxs 图对应的顶点个数
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) { // 顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for (int[] link : graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    // 编写prim算法，得到最小生成树
    /**
     *
     * @param graph
     * @param v
     */
    public void prim(MGraph graph, int v) {
        // visited[]标记节点（顶点）是否被访问过
        // visited[]默认元素的值都是0，表示没有访问过
        int visited[] = new int[graph.verxs];

        // 把当前这个节点标记位已访问
        visited[v] = 1;
        // h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; // 将minWeight初始化成一个大数，后面在遍历的过程中，会被替换
        for (int k = 1; k < graph.verxs; k++) { // 因为有graph.verxs个顶点，所以在普利姆算法结束后，有graph.verxs-1条边
            // 确定每一次生成的子图，和哪个节点的距离最近
            for (int i = 0; i < graph.verxs; i++) { // i节点表示被访问过的节点
                for (int j = 0; j < graph.verxs; j++) { // j节点表示还没有访问过的节点
                    if (visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        // 替换minWeight（寻找已经访问过的节点和未访问过的节点间的权值最小的边）
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到一条最小的边
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值：" + minWeight);
            // 将当前这个节点标记为已经访问
            visited[h2] = 1;
            // minWeight重新设置为最大值10000
            minWeight = 10000;
        }
    }
}

class MGraph {
    int verxs; // 表示图的节点个数
    char[] data; // 存放节点数据
    int[][] weight; // 存放边，即邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}

public class Solution {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        // 邻接矩阵的关系使用二维数组表示，使用10000这个大数，表示两个点不连通
        int[][] weight = new int[][] {
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000}
        };

        // 创建Graph对象
        MGraph graph = new MGraph(verxs);
        // 创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        // 输出
        minTree.showGraph(graph);
        // 测试普利姆算法
        minTree.prim(graph, 1);
    }
}