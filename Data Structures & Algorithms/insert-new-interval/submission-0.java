class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> response = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (newInterval[1] < interval[0]) {
                response.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    response.add(intervals[j]);
                }
                return response.toArray(new int[0][]);
            }
            else if (interval[1] < newInterval[0]) {
                response.add(interval);
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }        
        response.add(newInterval);
        return response.toArray(new int[0][]);
    }
}
