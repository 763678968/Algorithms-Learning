// 1.纯数字字符串转换成数字
class Solution {
    public static int strToInt(String s) {
        return Integer.parseInt(s);

        // 这里也可以用以下写法
        // return Integer.valueOf(s);
        // 两者的区别是，parseInt返回的是int类型，valueOf返回的是Integer类型
        // valueOf的底层调用的就是parseInt，对于现在的jdk版本已经实现自动装箱拆箱
        // 所以二者基本没有区别，推荐使用parseInt，效率更高
    }
}


// 2.非纯数字字符串转换成数字(ASCII)
class Solution {
    public static void strToInt(String s) {
        for (char c : s.toCharArray()) {
            // 这里只能使用valueOf，不能使用parseInt
            // parseInt只能接收String型参数，且必须是表示数字的字符串
            System.out.println(Integer.valueOf(c));
        }
    }

    public static void main(String[] args) {
        String s = "ABC";
        strToInt(s);
    }
}


// 3.字符串转数字的一般情况
class Solution {
    private static boolean isValid = false;

    public static int StrToInt(String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        long res = 0;  //先用long来存储，以防止越界
        boolean minus = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // 判断首位是否为'-'，负数
            if (i == 0 && ch == '-') {
                minus = true;
                // 判断首位是否为'+'，正数
            } else if (i == 0 && ch == '+') {
                minus = false;
            } else {
                // 判断字符串中间是否存在非法字符
                int num = ch - '0';
                if (num < 0 || num > 9) {
                    isValid = false;
                    return 0;
                }
                res = (minus == false) ? res * 10 + num : res * 10 - num;
                isValid = true;  //不放在最后面是为了防止str=‘+’的情况被判断为true
                // 由于前面使用long类型来存储num变量，因此num的范围可以大于0x7FFFFFFF或小于0x80000000
                if ((!minus && res > 0x7FFFFFFF) || (minus && res < 0x80000000)) {
                    isValid = false;
                    return 0;
                }
            }
        }
        return (int) res;
    }
}


// 4.数字转换成字符串
class Solution {
    public static void numToString(int num) {
        // 使用Integer.toString()方法
        String s1 = Integer.toString(num);
        System.out.println(s1);

        // int与String类型相加，强制类型转换为String
        String s2 = num + "";
        System.out.println(s2);

        // String.valueOf()方法
        String s3 = String.valueOf(num);
        System.out.println(s3);
    }

    public static void main(String[] args) {
        numToString(123);
    }
}