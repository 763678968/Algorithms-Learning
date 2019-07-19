class Solution {
    public int myAtoi(String str) {
        int MAX = 0x7fffffff;
        int MIN = 0x80000000;
        int UP = MAX / 10;
        int DOWN = MIN / 10;
        
        str = str.trim();
        if(str.isEmpty()) return 0;
        int ans = 0;
        int sign = 1;
        char c = str.charAt(0);
        if('+'==c);
        else if('-'==c)sign = -1;
        else if(Character.isDigit(c))ans = c-'0';
        else return 0;
        for(int i=1; i<str.length(); ++i){
            c = str.charAt(i);
            if(!Character.isDigit(c))break;
            int n = c-'0';
            if(ans>UP||(ans==UP&&n>7)){ans=MAX;break;}
            if(ans<DOWN||(ans==DOWN&&n>8)){ans=MIN;break;}
            ans = ans*10 + sign*n;
        }
        
        return ans;
    }
}
