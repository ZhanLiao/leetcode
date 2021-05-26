package pdd;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/25 21:51
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuffer stringBuffer = new StringBuffer();
        if (n <= 9){
            System.out.println(n);
        }else {
            int count = 9;
            while (n > count && count > 0){
                n -= count;
                stringBuffer.append(count);
                count--;
            }
            if (n <= count){
                stringBuffer.append(n);
                stringBuffer.reverse();
                System.out.println(stringBuffer);
            }else {
                System.out.println(-1);
            }
        }
    }
}
