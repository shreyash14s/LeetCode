class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        // Stream.of(intervals).forEach(x -> System.out.print("(" + x[0] + " - " + x[1] + "), "));
        // System.out.println();
        int cnt = 1, max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (max < intervals[i][1] && intervals[i][0] != intervals[i-1][0]) {
                // System.out.println(intervals[i][0] + " " + intervals[i][1]);
                cnt++;
            }
            max = Math.max(max, intervals[i][1]);
        }
        return cnt;
    }
}
