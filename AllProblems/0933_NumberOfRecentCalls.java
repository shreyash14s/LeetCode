class RecentCounter {
    int[] arr = new int[10_000];
    int len = 0;
    public RecentCounter() {
        len = 0;
    }
    
    public int ping(int t) {
        arr[len++] = t;
        int st = Arrays.binarySearch(arr, 0, len, t-3000);
        if (st < 0) st = - (st + 1);
        // IntStream.of(arr).forEach(x -> System.out.print(x + " "));
        // System.out.println();
        // System.out.println(st);
        return len - st;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */