class Solution {
    String[] st;
    Double[][] mat;
    int[][] vis;
    int stlen;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        st = new String[40];
        stlen = 0;
        HashMap<String, Integer> hs = new HashMap<>();
        for (List<String> eq: equations) {
            if (!hs.containsKey(eq.get(0))) {
                hs.put(eq.get(0), stlen);
                st[stlen++] = eq.get(0);
            }
            if (!hs.containsKey(eq.get(1))) {
                hs.put(eq.get(1), stlen);
                st[stlen++] = eq.get(1);
            }
        }
        
        mat = new Double[40][40];
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            int x = hs.get(eq.get(0)), y = hs.get(eq.get(1));
            mat[x][y] = values[i];
            mat[y][x] = 1.0/values[i];
        }
        
        vis = new int[40][40];
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> eq = queries.get(i);
            if (!hs.containsKey(eq.get(0)) || !hs.containsKey(eq.get(1))) {
                res[i] = -1;
            } else {
                int x = hs.get(eq.get(0)), y = hs.get(eq.get(1));
                vis[x][y] = 1;
                res[i] = recSolve(x, y);
                // System.out.println(res[i] + " " + x + " " + y);
                vis[x][y] = 0;
            }
        }
        return res;
    }
    
    double recSolve(int x, int y) {
        if (mat[x][y] != null) return mat[x][y];
        for (int i = 0; i < stlen; i++) {
            if (i != x && i != y && vis[x][i] == 0 && vis[i][y] == 0) {
                vis[x][y] = 1;
                // System.out.println(x + " " + i + " " + y);
                double d1 = recSolve(x, i);
                double d2 = recSolve(i, y);
                vis[x][y] = 0;
                if (d1 >= 0 && d2 >= 0) {
                    mat[x][y] = d1 * d2;
                    return mat[x][y];
                }
            }
        }
        mat[x][y] = -1.0;
        return -1;
    }
}
