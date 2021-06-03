package nextPermutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/27 10:39
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void nextPermutation(int[] nums) {
        int minIndex = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            //找较小数，尽可能靠右
            if (nums[i+1] > nums[i]){
                for (int j = nums.length - 1; j >= i; j--) {
                    //找较大数，尽可能小
                    if (nums[j] > nums[i]){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        minIndex = i+1;
                        break;
                    }
                }
                break;
            }
        }
        // 交换
        int right = nums.length-1;
        while (minIndex < right){
            int temp = nums[minIndex];
            nums[minIndex] = nums[right];
            nums[right] = temp;
            right--;
            minIndex++;
        }
    }

}
