class Solution {
    public void rotateWord(char[] chas) {
        if (chas == null || chas.length == 0) return;
        reverse(chas, 0, chas.length - 1);
        // 为单词左边界、有边界设置初值-1
        int left = -1, right = -1;
        for (int i = 0; i < chas.length; i++) {
            // 查找翻转每个单词的左右边界
            if (chas[i] != ' ') {
                // i为整个字符数组的开头(i == 0)或结尾(i == chas.length - 1),
                // 或者每个单词的开头(i - 1)或结尾(i + 1)时，分别在开头处设置left，结尾处设置right
                left = i == 0 || chas[i - 1] == ' ' ? i : left;
                right = i == chas.length - 1 || chas[i + 1] == ' ' ? i : right;
            }
            // 当left、right都不为初值时（也就是找到了一个完整的单词时），翻转单词
            if (left != -1 && right != -1) {
                reverse(chas, left, right);
                // 翻转之后将left、right重新置为默认值-1
                left = -1;
                right = -1;
            }
        }
    }

    private void reverse(char[] chas, int start, int end) {
        while (start < end) {
            char temp = chas[start];
            chas[start] = chas[end];
            chas[end] = temp;
            start++; end--;
        }
    }
}