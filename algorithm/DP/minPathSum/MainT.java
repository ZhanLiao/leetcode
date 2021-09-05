package minPathSum;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/8/30 10:24
 * @Version: 1.0
 */
public class MainT {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        Solution solution = new Solution();
        int i = solution.minPathSum(grid);
        System.out.println(i);
    }
}
