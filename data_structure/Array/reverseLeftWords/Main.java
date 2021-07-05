package reverseLeftWords;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/2 10:12
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = scanner.nextInt();
        String ans = reversLeftWords(s, n);
        System.out.println(ans);
    }

    private static String reversLeftWords(String s, int n) {
        /*StringBuilder stringBuilder = new StringBuilder(s);
        int i = 0;
        for (; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString().substring(i, s.length()+i);*/
        return  s.substring(n-1, s.length()) + s.substring(0, n);
    }
}
