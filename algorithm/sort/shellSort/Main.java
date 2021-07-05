package shellSort;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/24 12:23
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
        shellSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }

    private static void shellSort(int[] nums) {
        int interval = nums.length/2;
        while (true){
            for (int i = 0; i < interval; i++) {
                //每个子序列进行插入排序
                for (int j = i + interval; j < nums.length; j += interval) {
                    for (int k = j; k > 0; k -= interval) {
                        if (nums[k-1] > nums[k]){
                            int temp = nums[k-1];
                            nums[k-1] = nums[k];
                            nums[k] = temp;
                        }else {
                            break;
                        }
                    }
                }
            }
            interval /= 2;
            if (interval == 0){
                break;
            }
        }

    }
}
