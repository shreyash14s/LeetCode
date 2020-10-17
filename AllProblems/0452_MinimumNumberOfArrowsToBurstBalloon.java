class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) return 1;
            if (a[1] < b[1]) return -1;
            return 0;
        });
        // Stream.of(points).forEach(x -> System.out.print(x[0] + " "));
        // System.out.println();
        int end = points[0][1], cnt = 0;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > end) {
                cnt++;
                end = points[i][1];
            }
        }
        return cnt + 1;
    }
}