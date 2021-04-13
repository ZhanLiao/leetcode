package find2DTarget;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 10:38
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[][] nums  = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        boolean b = solution.findNumberIn2DArray(nums, 9);
        System.out.println(b);
        String str = "We are happy.";
        str = str.replace(' ', '%');
        System.out.println(str);
    }
}
