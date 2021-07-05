package myPow;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/26 20:15
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = scanner.nextInt();
        int n = scanner.nextInt();
        double ans = myPow(x, n);
        System.out.println(ans);
    }

    private static double myPow(double x, int n) {
        double res = 1.0;
        if (n == 0){
            return res;
        }
        long b = n;
        if (n < 0){
            x = 1/x;
            b = -b;
        }
        while (b > 0){
            if ((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
