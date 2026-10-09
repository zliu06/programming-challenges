class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] interval1, int[] interval2) -> {
            int ret = interval1[0] - interval2[0];
            if (ret != 0) return ret;
            return interval1[1] - interval2[1];
        });
        List<int[]> response = new ArrayList<>();
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (last[1] < interval[0]) {
                response.add(last);
                last = interval;
            }
            else {
                last[0] = Math.min(last[0], interval[0]);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        response.add(last);
        return response.toArray(new int[0][]);
    }
}
