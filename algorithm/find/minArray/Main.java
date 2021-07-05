package minArray;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/1 10:26
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] numbers = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            numbers[i] = Integer.valueOf(s[i]);
        }
        int ans = minArray(numbers);
        System.out.println(ans);
    }

    private static int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length-1;
        while (i < j){
            int mid = i + (j - i) / 2;
            if (numbers[j] > numbers[mid]){
                j = mid;
            }else if (numbers[j] < numbers[mid]){
                i = mid + 1;
            }else {
                j -= 1;
            }
        }
        return numbers[i];
    }

}
