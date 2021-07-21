package maxAreaOfIsland;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/8 10:06
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int ans = maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    private static int maxAreaOfIsland(int[][] grid) {
        int res = Integer.MIN_VALUE;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(i, j, grid));
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }

    private static int dfs(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 ){
            return 0;
        }
        grid[x][y] = 0;
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 1;
        for (int k = 0; k < direction.length; k++) {
            int nextX = x + direction[k][0];
            int nextY = y + direction[k][1];
            count += dfs(nextX, nextY, grid);
        }
        return count;
    }

}
