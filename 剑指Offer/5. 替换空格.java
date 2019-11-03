public class Solution {
    public String replaceSpace(StringBuffer str) {
        int spacenum = 0; // spacenum为计算空格数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                spacenum++;
        }
        int p1 = str.length() - 1; // p1指针位于替换前的字符串末尾
        int newlength = str.length() + spacenum * 2; // 计算替换后的字符串长度
        int p2 = newlength - 1; // p2指针位于替换后的字符串末尾
        str.setLength(newlength); // 使str的长度扩大到转换成%20之后的长度，防止下标越界
        while (p1 >= 0 && (p1 != p2)) {
            if (str.charAt(p1) == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, str.charAt(p1));
            }
            p1--;
        }
        return str.toString();
    }
}

// 一行代码实现
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	return str.toString().replaceAll(" ", "%20"); 
    }
}
