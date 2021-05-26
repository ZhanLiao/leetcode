package threeSum;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/25 11:45
 * @Version: 1.0
 */
public class Main {
    public static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
//        List<List<Integer>> lists = threeSum(nums);
        List<List<Integer>> lists = new Solution().threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('9');
        stringBuffer.append('9');
        stringBuffer.append('1');
        stringBuffer.reverse();
        System.out.println(Integer.valueOf(String.valueOf(stringBuffer)));


    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        dfs(0, temp, 0, nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean f = false;
        for (List<Integer> an : ans) {
            int a = an.get(0);
            int b = an.get(1);
            int c = an.get(2);
            if (a == 0 && b == 0 && c == 0){
                f = true;
                continue;
            }
            boolean flag = true;
            for (int i = 0; i < res.size(); i++) {
                List<Integer> t = res.get(i);

                if (t.contains(a) && t.contains(b) && t.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                res.add(an);
            }

        }
        if (f){
            List<Integer> z = new ArrayList<>();
            z.add(0);
            z.add(0);
            z.add(0);
            res.add(z);
        }
        return res;
    }

    private static void dfs(int index, List<Integer> temp, int sum, int[] nums){
        if (temp.size() == 3){
            if (sum == 0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // 可选择范围
        for (int j = index; j < nums.length; j++) {
            // 决策
            temp.add(nums[j]);
            sum += nums[j];
            // 下一层
            dfs(j+1, temp, sum, nums);
            // 恢复决策
            temp.remove(temp.size()-1);
            sum -= nums[j];
        }
    }
}
