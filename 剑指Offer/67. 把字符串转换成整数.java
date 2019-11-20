private static boolean isValid = false;
public static int strToInt(String str) {
    if(str == null || str.length()<=0)
        return 0;
    char[] chars = str.toCharArray();
    long num=0;  //先用long来存储，以防止越界
    boolean minus=false;
    for(int i=0; i<chars.length; i++){
        // 判断首位是否为'-'，负数
        if(i==0 && chars[i]=='-'){
            minus=true;
            // 判断首位是否为'+'，正数
        }else if(i==0 && chars[i]=='+'){
            minus=false;
        }else{
            // 判断字符串中间是否存在非法字符
            int a=(int) (chars[i]-'0');
            if(a<0 || a>9){
                isValid=false;
                return 0;
            }
            num= (minus==false) ? num*10+a : num*10-a;
            isValid=true;  //不放在最后面是为了防止str=‘+’的情况被判断为true
            // 由于前面使用long类型来存储num变量，因此num的范围可以大于0x7FFFFFFF或小于0x80000000
            if((!minus && num>0x7FFFFFFF) ||(minus && num<0x80000000)){
                isValid=false;
                return 0;
            }
        }
    }
    return (int)num;
}
