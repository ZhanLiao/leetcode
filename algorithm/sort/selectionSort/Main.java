package selectionSort;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/24 10:45
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
        selectionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            // 找最小值的索引
            int index = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[index] > nums[j]){
                    index = j;
                }
            }
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }
}
