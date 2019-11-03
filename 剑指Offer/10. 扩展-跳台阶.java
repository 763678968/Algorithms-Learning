public class Solution {
    public int JumpFloor(int target) {
        if (target <= 0)
            throw new RuntimeException("错误，台阶数应从1开始！");
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        
        int preNum = 1;
        int sufNum = 2;
        int result = 0;
        for (int i =3; i <= target; i++) {
            result = preNum + sufNum;
            
            preNum = sufNum;
            sufNum = result;
        }
        return result;
    }
}
