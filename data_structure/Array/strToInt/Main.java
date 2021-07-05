package strToInt;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/30 17:10
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int ans = strToInt(str);
        System.out.println(ans);
    }

    private static int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length==0){
            return 0;
        }
        int flag = 1;
        int i = 1;
        int res = 0;
        int bun = Integer.MAX_VALUE / 10;
        if (chars[0] == '-'){
            flag = -1;
        }else if (chars[0] != '+'){
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] > '9' || chars[j] < '0'){
                break;
            }
            if (res > bun || (res == bun && chars[j] > '7')){
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + chars[j] - '0';
        }
        return flag * res;
    }
}
