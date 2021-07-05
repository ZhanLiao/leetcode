package merge;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/24 21:08
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
        mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] temp = new int[nums.length];
        mergeSortRec(nums, left, right, temp);
    }

    private static void mergeSortRec(int[] nums, int left, int right, int[] temp) {

        if (right <= left){
            return;
        }
        int middle = left + (right - left)/2;
        mergeSortRec(nums, middle+1, right, temp);
        mergeSortRec(nums, left, middle, temp);
        mergeArray(nums, left, middle, right, temp);
    }

    /**
     * 合并两个数组
     * @param nums
     * @param left
     * @param middle
     * @param right
     * @param temp
     */
    private static void mergeArray(int[] nums, int left, int middle, int right, int[] temp) {
        int i = left, m = middle, j = middle + 1, n = right, k = 0;
        while (i <= m && j <= n){
            if (nums[i] < nums[j]){
                temp[k++] = nums[i++];
            }else {
                temp[k++] = nums[j++];
            }
        }
        while (i <= m){
            temp[k++] = nums[i++];
        }
        while (j <= n){
            temp[k++] = nums[j++];
        }

        for (int l = 0; l < k; l++) {
            nums[left + l] = temp[l];
        }
    }
}
