/** If overflow exists, the new result will not equal previous one.
No flags needed. No hard code like 0xf7777777 needed.
*/

class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        
        return result;
    }
}
