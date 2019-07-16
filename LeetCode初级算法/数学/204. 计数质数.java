class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}

class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; j*i < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        int count = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) count++;
        }
        return count;
    }
}
// 简化版，只需要验证n的平方根即可
