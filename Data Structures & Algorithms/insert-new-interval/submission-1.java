class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start > newInterval[1]) {
                results.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    results.add(intervals[j]);
                }
                return results.toArray(new int[0][]);
            }
            else if (end < newInterval[0]) {
                results.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(start, newInterval[0]);
                newInterval[1] = Math.max(end, newInterval[1]);
            }
        }
        results.add(newInterval);
        return results.toArray(new int[0][]);
    }
}
