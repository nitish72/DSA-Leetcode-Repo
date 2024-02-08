// Date : 08 Feb 2024
// https://leetcode.com/problems/perfect-squares/submissions/1169747398/?envType=daily-question&envId=2024-02-08

class Solution {
         int memo[];
    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n);
    }
    private int helper(int n) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int curr = 1 + helper(n - i * i);
            min = Math.min(min, curr);
        }
        return memo[n] = min;
        
    }
}
