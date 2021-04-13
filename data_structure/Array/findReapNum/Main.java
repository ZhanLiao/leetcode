package findReapNum;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 10:26
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        int[] nums = {2, 3, 4, 2, 3, 4};
        int res = solution.findRepeatNum(nums);
        System.out.println(res);
    }
}
