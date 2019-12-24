class Solution {
    public int[][] reconstructQueue(int[][] people) {
        /**
         * 首先选出最高的人
         * 然后插入第二高的人，只需要按照k值，插入相应位置
         * 重复操作，直到将所有人全部插入到列表中
         */
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] != o2[0]) ? -(o1[0] - o2[0]) : o1[1] - o2[1];
            }
        });
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
