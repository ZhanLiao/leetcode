package quickSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/24 17:00
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
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] nums) {
        int right = nums.length - 1;
        int left = 0;

        quickSortRecursion(right, left, nums);
    }

    private static void quickSortRecursion(int right, int left, int[] nums) {
        if (left >= right){
            return;
        }
        int base = nums[left];  // 挖出来一个位置
        int i = left;
        int j = right;
        while (i < j){
            // 从右到左找出第一个小于基数的值
            while (i < j && base <= nums[j]){
                j--;
            }
            // 把空填上,同时j位置空出来了
            if (i < j){
                nums[i] = nums[j];
                i++;
            }
            // 从由左到右找出第一个大于基数的值
            while (i < j && base > nums[i]){
                i++;
            }
            // 找一个较大值填上j位置的空
            if (i < j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = base;
        System.out.println(Arrays.toString(nums));
        quickSortRecursion(right, i+1, nums);
        quickSortRecursion(i-1, left, nums);
    }
}
