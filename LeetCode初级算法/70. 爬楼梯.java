/** Here are the steps to get the solution incrementally.

Base cases:
if n <= 0, then the number of ways should be zero.
if n == 1, then there is only way to climb the stair.
if n == 2, then there are two ways to climb the stairs. One solution is one step by another; the other one is two steps at one time.

The key intuition to solve the problem is that given a number of stairs n, if we know the number ways to get to the points [n-1] and [n-2] respectively, denoted as n1 and n2 , then the total ways to get to the point [n] is n1 + n2. Because from the [n-1] point, we can take one single step to reach [n]. And from the [n-2] point, we could take two steps to get there.

The solutions calculated by the above approach are complete and non-redundant. The two solution sets (n1 and n2) cover all the possible cases on how the final step is taken. And there would be NO overlapping among the final solutions constructed from these two solution sets, because they differ in the final step.

Now given the above intuition, one can construct an array where each node stores the solution for each number n. Or if we look at it closer, it is clear that this is basically a fibonacci number, with the starting numbers as 1 and 2, instead of 1 and 1.
*/

class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int one_step_before = 2;
        int two_steps_before = 1;
        int all_ways = 0;
        
        for (int i=2; i<n; i++) {
            all_ways = one_step_before + two_steps_before;
            two_steps_before = one_step_before;
            one_step_before = all_ways;
        }
        return all_ways;
    }
}

class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (n--> 0)
            a = (b += a) - a;
        return a;
    }
}
// 简化版，类似的题目还有91.解码方法 62.不同路径 509.斐波那契数
