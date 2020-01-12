// 二分法
class Solution {
    public static double sqrt(double t, Double precise) {
        double low = 0, high = t;
        double middle, squre;

        if (t < 0) {
            throw new RuntimeException("Negetive number cannot have a sqrt root.");
        }
        // 对于小于1的数字，将high设为1
        if (t < 1) {
            high = 1;
        }

        while (high - low > precise) {
            middle = low + (high - low) / 2;
            squre = middle * middle;
            if (squre > t) {
                high = middle;
            } else {
                low = middle;
            }
        }
        return low + (high - low) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(0.5, 0.00000001));
    }
}


