package searchRange;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description: 查找有序数组中，第一个出现目标值的索引和最后一个出现目标值的索引
 * @Date: 2021/6/2 10:34
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        int[] ans = searchRange(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int left = 0;
        int right = nums.length-1;

        while (left <= right){
            int median = left + (right - left) / 2;
            if (nums[median] == target){
                //找出目标值的第一次出现和最后一次出现
                int i = median;
                int j = median;
                boolean fi = false;
                boolean fj = false;
                while (i >= 0 || j <= nums.length-1){
                    if (i >= 0){
                        if (nums[i] == target){
                            res[0] = i;
                            i--;
                        }else {
                            fi = true;
                        }
                        if (i < 0){
                            fi = true;
                        }
                    }
                    if (j <= nums.length - 1){
                        if (nums[j] == target){
                            res[1] = j;
                            j++;
                        }else {
                            fj = true;
                        }
                        if (j > nums.length - 1){
                            fj = true;
                        }
                    }
                    if (fi && fj){
                        break;
                    }
                }
                break;
            }else if (nums[median] > target){
                right = median - 1;
            }else {
                left = median + 1;
            }
        }
        return res;
    }
}
