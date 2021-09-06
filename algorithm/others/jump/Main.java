package jump;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * 2 3 1 1 4
 * 2
 * @Date: 2021/9/6 11:25
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int ans = jump(nums);
        System.out.println(ans);
    }

    private static int jump(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = 1;
        int nextIndex = 0;
        for (int i = 0; i < nums.length;) {
            int mostRight = i + nums[i];
            if (mostRight >= nums.length-1){
                break;
            }
            for (int j = i+1; j <= i + nums[i]; j++) {
                if (mostRight < nums[j] + j){
                    mostRight = nums[j] + j;
                    nextIndex = j;
                }
            }
            i = nextIndex;
            res++;
        }
        return res;
    }
}
