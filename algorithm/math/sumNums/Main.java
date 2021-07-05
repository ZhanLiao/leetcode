package sumNums;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/28 21:31
 * @Version: 1.0
 */
public class Main {
    static int res ;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = sumNums(n);
        System.out.println(ans);
    }

    private static int sumNums(int n) {
        boolean x = n > 1 &&  sumNums(n-1) > 0;
        res += n;
        return res;
    }
}
