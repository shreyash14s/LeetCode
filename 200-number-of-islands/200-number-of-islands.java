class Solution {
    private void dfs(char[][] grid, int[][] visited, int i, int j, int c) {
        visited[i][j] = c;
        if (i + 1 < grid.length && visited[i+1][j] == 0 && grid[i+1][j] == '1') {
            dfs(grid, visited, i+1, j, c);
        }
        
        if (i > 0 && visited[i-1][j] == 0 && grid[i-1][j] == '1') {
            dfs(grid, visited, i-1, j, c);
        }
        
        if (j + 1 < grid[0].length && visited[i][j+1] == 0 && grid[i][j+1] == '1') {
            dfs(grid, visited, i, j+1, c);
        }
        
        if (j > 0 && visited[i][j-1] == 0 && grid[i][j-1] == '1') {
            dfs(grid, visited, i, j-1, c);
        }
    }

    public int numIslands(char[][] grid) {
        int connected = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    connected++;
                    dfs(grid, visited, i, j, connected);
                }
            }
        }
        return connected;
    }
}
