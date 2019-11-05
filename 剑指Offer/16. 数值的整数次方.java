// 基础做法
public class Solution {
    public double Power(double base, int exponent) {
        double result = 1;
        if (base == 0) {
            if (exponent >= 0)
                return 0;
            if (exponent < 0)
                throw new RuntimeException("错误，0的指数不能为负数！");
        } else {
            if (exponent > 0) {
                for (int i = 0; i < exponent; i++)
                    result *= base;
            } else if (exponent < 0) {
                for (int i = 0; i < -exponent; i++) {
                    result *= base;
                }
                result = 1.0 / result;
            } else {
                result = 1;
            }
        }
        return result;
    }
}


// 高级做法
public class Solution {
    boolean IsInvalid = false; // 用全局变量标记是否出错
    
    public double Power(double base, int exponent) {
        IsInvalid = false;
        double result; // double类型
        if (exponent > 0) {
            result = powerCore(base, exponent);
        } else if (exponent < 0) {
            if (base == 0) {
                IsInvalid = true; // 0的负数次方不存在
                return 0;
            }
            result = 1 / powerCore(base, -exponent);
        } else {
            return 1; // 这里0的0次方输出为1；
        }
        return result;
    }
    
    // 递归方法实现乘方
    private double powerCore(double base, int exponent) {
        if (exponent == 1)
            return base;
        if (exponent == 0)
            return 1;
        // 使用右移运算符代替除以2
        double result = powerCore(base, exponent >> 1);
        result *= result;
        // 使用位与运算符代替了求余运算符(%)来判断一个数是奇数还是偶数
        if ((exponent & 1) == 1)
            result *= base;
        return result;
    }
}


// 非递归实现乘方，上面的powerCore()方法可以改写如下：
/**
 * 非递归实现乘方
 */
private double powerCore2(double base, int exponent) { 
    double result=1;
    while(exponent!=0) {
        if((exponent&0x1)==1)
            result*=base;
        exponent>>=1; 
        base*=base; //指数右移一位，则底数翻倍
        //举例：10^1101 = 10^0001*10^0100*10^1000
        //即10^1+10^4+10^8
    }
    return result;
}
