package singleNumbers;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/28 21:41
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(s[i]);
        }
        int[] ans = singleNumbers(nums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] singleNumbers(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)){
                hashSet.remove(num);
            }else {
                hashSet.add(num);
            }
        }
        int[] res = new int[hashSet.size()];

        int i = 0;
        for (Integer integer : hashSet) {
            res[i] =  integer;
            i++;
        }
        return res;
    }
    private static int singleNumbers2(int[] nums) {
        /**
         * 暴力解法
         */
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
        /**
         * 其他解法
         */
    }
}
