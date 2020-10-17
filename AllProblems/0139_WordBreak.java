class Solution {
    static boolean[] test;
    static int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        test = new boolean[26];
        dp = new int[s.length()];
        Trie root = new Trie();
        for (String word: wordDict) {
            root.add(word);
        }
        for (int i = 0; i < s.length(); i++) {
            if (!test[s.charAt(i) - 'a']) return false;
        }
        return recFind(root, s, 0);
    }
    
    boolean recFind(Trie root, String s, int st) {
        if (dp[st] != 0) return dp[st] == 1;
        int i = st;
        Trie t = root;
        while (i < s.length() && t.map[s.charAt(i) - 'a'] != null) {
            t = t.map[s.charAt(i) - 'a'];
            i++;
        }
        if (i == s.length() && t.end) {
            dp[st] = 1;
            return true;
        }
        while (i >= st && t != null) {
            if (t.end) {
                if (recFind(root, s, i)) {
                    dp[st] = 1;
                    return true;
                }
            }
            i--;
            t = t.par;
        }
        dp[st] = -1;
        return false;
    }

    static class Trie {
        Trie par = null;
        Trie[] map = new Trie[26];
        boolean end = false;

        void add(String s) {
            Trie t = this;
            for (int i = 0; i < s.length(); i++) {
                if (t.map[s.charAt(i) - 'a'] == null) {
                    t.map[s.charAt(i) - 'a'] = new Trie();
                    t.map[s.charAt(i) - 'a'].par = t;
                }
                t = t.map[s.charAt(i) - 'a'];
                test[s.charAt(i) - 'a'] = true;
            }
            t.end = true;
        }
    }
}
