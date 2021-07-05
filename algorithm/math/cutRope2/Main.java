package cutRope2;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/26 10:58
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ans = cuttingRope(n);
        System.out.println(ans);
    }

    private static int cuttingRope2(int n){
        if (n <= 3){
            return n - 1;
        }
        long mod = (1000000000 + 7);
        long res = 1;
        while (n > 4){
            res = res * 3 % mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }

    private static int cuttingRope(int n) {
        if (n <= 3){
            return n - 1;
        }
        long mod = (long) (1000000000 + 7);
        int segment = n / 3;
        int remain = n % 3;
        if (remain == 0){
            return myPow(segment, 3, mod);
        }else if (remain == 1){
            return (int) (myPow(segment-1, 3, mod)*4 % mod);
        }else {
            return (int) (myPow(segment, 3, mod) * 2 % mod);
        }
    }

    private static int myPow(long segment, int i, long mod) {
        long res = 1;
        for (int j = 0; j < segment; j++) {
            res = (res * i) % mod;
        }
        return (int) res;
    }
}
