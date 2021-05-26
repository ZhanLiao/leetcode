package pdd;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/25 22:11
 * @Version: 1.0
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        scanner.close();

        char[] ch1 = new char[n];
        char[] ch2 = new char[n];
        for (int i = 0; i < n; i++) {
            ch1[i] = str1.charAt(i);
            ch2[i] = str2.charAt(i);
        }
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ch1[i] != ch2[i]){
                ans += Math.abs(ch1[i] - ch2[i]);
            }
        }
        System.out.println(ans);


    }
}
