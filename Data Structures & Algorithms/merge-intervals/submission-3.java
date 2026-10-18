class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] one, int[] other) -> {
            return Integer.compare(one[0], other[0]);
        });

        List<int[]> result = new ArrayList<>();
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > last[1]) {
                result.add(last);
                last = intervals[i];
            } else {
                last[0] = Math.min(intervals[i][0],last[0]);
                last[1] = Math.max(intervals[i][1],last[1]);
            }
        }
        result.add(last);
        return result.toArray(new int[0][]);
    }
}
