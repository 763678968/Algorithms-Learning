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


// 3.数字转换成字符串
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