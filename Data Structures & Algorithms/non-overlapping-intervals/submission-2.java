class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] left, int[] right)-> Integer.compare(left[0],right[0]));
        int[] group = intervals[0];
        int removed = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] >= group[1]) {
                group = current;
            } else {
                group[1] = Math.min(group[1], current[1]);
                removed++;
            }
        }
        return removed;
    }
}
