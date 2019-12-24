class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;
        while (res != 0) {
            res &= (res - 1);
            count++;
        }
        return count;
    }
}

// 使用Integer的内置方法bitCount()
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
