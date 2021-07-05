package insertionSort;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/24 11:23
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
        insertionSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                 if (nums[j-1] > nums[j]){
                     int temp = nums[j];
                     nums[j] = nums[j-1];
                     nums[j-1] = temp;
                 }else {
                     break;
                 }
            }
        }
    }
}
