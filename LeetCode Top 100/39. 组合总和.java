class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        int sum = 0;
        combinationSumCore(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void combinationSumCore(List<List<Integer>> list, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0)
            list.add(new ArrayList<>(tempList));
        else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                // 数组中的数字可以无限制被选取，所以start = i
                combinationSumCore(list, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
