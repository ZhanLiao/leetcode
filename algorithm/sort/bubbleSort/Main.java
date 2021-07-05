package bubbleSort;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/24 10:16
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
        bubbleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            boolean exChange = false;
            for (int j = 1; j <= i; j++) {
                if (nums[j-1] > nums[j]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    exChange = true;
                }
            }
            if (!exChange){
                break;
            }
        }

    }
}
