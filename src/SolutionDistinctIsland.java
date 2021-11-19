/**
 * 1. Using relative postion to first dot or root dot describe an island dot
 * 2. Using Set to eliminate duplicates
 * 3. DFS is cleaner than BFS
 */
public class SolutionDistinctIsland {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    int n, m = 0;
    Set<String> islandSet = new HashSet<>();
    int[] deltaX = {0, 1, -1, 0};
    int[] deltaY = {1, 0, 0, -1};
    String currentIsland = "";
    boolean[][] visited = null;
    int rootX, rootY = 0;

    public int numberofDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        if(grid[0] == null || grid[0].length ==0) return 0;

        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    currentIsland = "";
                    visited[i][j] = true;
                    rootX = i;
                    rootY = j;
                    dfs(i, j, grid);
                    islandSet.add(currentIsland);
                }
            }
        }
        return islandSet.size();
    }

    private void dfs(int x, int y, boolean[][] grid) {
        visited[x][y] = true;
        currentIsland += (x - rootX) + "" + (y - rootY);

        for(int direction = 0; direction < 4; direction++) {
            int newX = x + deltaX[direction];
            int newY = y + deltaY[direction];

            if(!isValid(newX, newY, visited)) continue;
            dfs(newX, newY, grid);
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited) {
        if(x < 0 || x >=n || y < 0 || y >= m) return false;
        if(visited[x][y] || grid[x][y] == 0) return false;
        return true;
    }
}
