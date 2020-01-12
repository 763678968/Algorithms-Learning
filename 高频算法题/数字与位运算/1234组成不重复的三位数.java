// 1,2,3,4四个数可以组成多少个无重复数字的三位数
class Solution {
    public static void main(String[] args) {
        //考察多重循环
        int count = 0; //计数器
        for (int i = 1; i <= 4; i++) { //遍历个位的所有数
            for (int j = 1; j <= 4; j++) { //遍历十位的所有数
                for (int k = 1; k <= 4; k++) { //遍历百位的所有数
                    if (k != j && k != i && j != i) { //如果个位，十位，百位上的数都不相等
                        count++; //记录组成的个数
                        System.out.println(k * 100 + j * 10 + i); //打印组成后的三位数
                    }
                }
            }
        }
        System.out.println("组成的三位数有 " + count + " 个");//打印组成的三位数的个数
    }
}
