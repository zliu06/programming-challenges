class Solution {
    public int climbStairs(int n) {
        int current = 1; // n-1
        int next = 1; // n
        for (int i = n-2; i>=0; i--) {
            int tmp = current;
            current = current + next;
            next = tmp;
        }
        return current;
    }
}
