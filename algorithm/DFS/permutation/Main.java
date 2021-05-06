package permutation;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/29 10:47
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Solution().permute(nums);
        for (int i = 0; i < permute.size(); i++) {
            System.out.println(Arrays.toString(permute.get(i).toArray()));


        }
    }
}
