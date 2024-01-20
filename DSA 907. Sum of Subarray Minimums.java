// Date : 20 th Jan 2024
// https://leetcode.com/problems/sum-of-subarray-minimums/description/?envType=daily-question&envId=2024-01-20

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] leftNextSmaller = findLeftNextSmaller(arr, len);
        int[] rightNextSmaller = findRightNextSmaller(arr, len);
        int mod = 1000000007;
        long totalSum = 0;
        for (int i = 0; i < len; i++) {
            long leftDistance = i - leftNextSmaller[i];
            long rightDistance = rightNextSmaller[i] - i;
            long totalWays = leftDistance * rightDistance;
            long currSum = totalWays * arr[i];
            totalSum = (totalSum + currSum) % mod;
        }
        return (int)totalSum;
    }
    private int[] findLeftNextSmaller(int[] arr, int len) {
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                result[i] = -1;
            }
            else {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                result[i] = (!stack.isEmpty()) ? stack.peek() : -1;
            }
            stack.push(i);
        }
        return result;
    }
    private int[] findRightNextSmaller(int[] arr, int len) {
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i] = len;
            }
            else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                result[i] = (!stack.isEmpty()) ? stack.peek() : len;
            }
            stack.push(i);
        }
        return result;
    }
}
