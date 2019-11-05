// 常规做法
public class Solution {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        int[] index = new int[1];
        index[0] = 0; // 用于记录当前字符位置
        // 先判断A
        boolean isNumeric; //用于记录是否满足条件
        isNumeric = isInteger(str, index);
        // 判断B
        if (index[0] < str.length && (str[index[0]] == '.')) {
            index[0]++;
            isNumeric = isUnsignedInteger(str, index) || isNumeric; // .B和A.和A.B形式均可以
        }
        // 判断e后面的A
        if (index[0] < str.length && (str[index[0]] == 'e' || str[index[0]] == 'E')) {
            index[0]++;
            isNumeric = isInteger(str, index) && isNumeric;
        }
        if (isNumeric && index[0] == str.length)
            return true;
        else
            return false;
    }
 
    private boolean isInteger(char[] str, int[] index) { // 用int[]才能传值，int的话需要定义index为全局变量
        if (index[0] < str.length && (str[index[0]] == '+' || str[index[0]] == '-'))
            index[0]++;
        return isUnsignedInteger(str, index);
    }
 
    private boolean isUnsignedInteger(char[] str, int[] index) {
        int start = index[0];
        while (index[0] < str.length && (str[index[0]] - '0' <= 9 && str[index[0]] - '0' >= 0))
            index[0]++;
        if (index[0] > start)
            return true;
        else
            return false;
    }
}


// 正则表达式
public class Solution {
    public boolean isNumeric(char[] str) {
        String string = String.valueOf(str);
        return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
