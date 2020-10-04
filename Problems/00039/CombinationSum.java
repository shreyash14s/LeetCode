class Solution {
    List<List<Integer>> res;
    ArrayList<Integer> cur = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        rec(candidates, target, 0);
        return res;
    }
    
    public void rec(int[] cand, int target, int st) {
        if (target < 0) return;
        if (target == 0) {
            res.add((List<Integer>) cur.clone());
            return;
        }
        for (int i = st; i < cand.length; i++) {
            cur.add(cand[i]);
            rec(cand, target - cand[i], i);
            cur.remove((int) cur.size()-1);
        }
    }
}
