class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    // open：左括号个数 close：右括号个数
    public void backtrack(List<String> list, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            list.add(str);
            return;
        }

        if (open < n) {
            backtrack(list, str+"(", open+1, close, n);
        }
        if (close < open) {
            backtrack(list, str+")", open, close+1, n);
        }
    }
}
