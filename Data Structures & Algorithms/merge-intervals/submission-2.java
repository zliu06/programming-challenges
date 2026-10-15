class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] left, int[] right) -> {
            return left[0]-right[0];
        });
        List<int[]> result = new ArrayList<>();
        int[] last = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (last[1]<current[0]) {
                result.add(last);
                last=current;
            }
            else {
                last[0]=Math.min(last[0],current[0]);
                last[1]=Math.max(last[1],current[1]);
            }
        }
        result.add(last);
        return result.toArray(new int[0][]);
    }
}
