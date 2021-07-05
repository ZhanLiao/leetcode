package add;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/2 10:36
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int ans = add(a, b);
    }

    public static int add(int a, int b) {
        while(b != 0){
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}
