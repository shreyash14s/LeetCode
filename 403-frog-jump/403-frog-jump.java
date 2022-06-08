import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    private ArrayList<HashMap<Integer, Integer>> dp;
    private boolean foo(HashMap<Integer, Integer> validStones, int last, int i, int k) {
        if (i == last) {
            return true;
        }
        if (i > last) {
            return false;
        }
        int idx = validStones.get(i);
        if (k < 0) return false;
        if (dp.get(idx).containsKey(k)) {
            return dp.get(idx).get(k) == 1;
        }
        boolean plus = false;
        if (validStones.containsKey(i + k+1)) {
            plus = foo(validStones, last, i+k+1, k+1);
        }
        boolean zero = false;
        if (k > 0 && !plus && validStones.containsKey(i + k)) {
            zero = foo(validStones, last, i+k, k);
        }
        boolean minu = false;
        if (k > 0 && !plus && !zero && validStones.containsKey(i + k-1)) {
            minu = foo(validStones, last, i + k-1, k-1);
        }
        int val = (plus || zero || minu) ? 1 : 2;
        dp.get(idx).put(k, val);
        return val == 1;
    }

    public boolean canCross(int[] stones) {
        // System.out.println(stones.length);
        dp = new ArrayList<>();
        HashMap<Integer, Integer> validStones = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            validStones.put(stones[i], i);
            dp.add(new HashMap<>());
        }
        return foo(validStones, stones[stones.length-1], 0, 0);
    }
}