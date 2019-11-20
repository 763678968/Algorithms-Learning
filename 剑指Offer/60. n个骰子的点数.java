// 递归版本
public class Solution {
    public void getNSumCount(int n) {
        double total = Math.pow(6, n);
        for (int i = n; i <= 6*n; i++) {
            System.out.println(getNSumCountCore(n, i) / total);
        }
    }

    public int getNSumCountCore(int n, int sum) {
        if (n<1 || sum<n || sum>6*n)
            return 0;
        if (n == 1)
            return 1;

        int resCount = 0;
        resCount = getNSumCountCore(n-1, sum-1) + getNSumCountCore(n-1, sum-2) +
                getNSumCountCore(n-1, sum-3) + getNSumCountCore(n-1, sum-4) +
                getNSumCountCore(n-1, sum-5) + getNSumCountCore(n-1, sum-6);
        return resCount;
    }

    // 测试代码
    public static void main(String[] args) {
        Solution s = new Solution();
        s.getNSumCount(2);
    }
}


// 迭代版本
public static void printProbability2(int number) {
    if(number<=0)
        return;  //错误
    int[][] probabilities = new int[2][number*maxValue+1];
    //[2]代表用两个数组交替保存，[number*maxValue+1]是指点数为所在下标时，该点数出现的总次数。
    //probabilities[*][0]是没用的，只是为了让下标对应点数
    for(int i=0;i<2;i++) {
        for(int j=0;j<number*maxValue;j++) {
            probabilities[i][j]=0;
        }
    }

    for(int i=1;i<=6;i++)
        probabilities[0][i]=1;  //第一个骰子出现的情况

    int flag=0;
    for(int curNumber=2;curNumber<=number;curNumber++) {   //当前是第几个骰子
        for(int i=0;i<curNumber;i++)
            probabilities[1-flag][i]=0;  //前面的数据清零

        for(int i=curNumber;i<=curNumber*maxValue;i++) {
            for(int j=1;j<=6 && j<=i ;j++) {
                probabilities[1-flag][i]+=probabilities[flag][i-j];
            }
        }
        flag=1-flag;

    }

    int totalP = (int) Math.pow(maxValue, number);  //所有情况总共出现的次数
    for( int i=number;i<= number*6;i++) {
        double ratio = (double)probabilities[flag][i]/totalP;
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(8);//设置保留几位小数
        System.out.println("点数和为"+(i+number)+"的概率为:"+format.format(ratio));
    }
}
