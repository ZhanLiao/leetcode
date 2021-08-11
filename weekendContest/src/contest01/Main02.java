package contest01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/13 11:23
 * @Version: 1.0
 */
public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        String[] s1 = scanner.nextLine().split(" ");
        int[] removable = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            removable[i] = Integer.valueOf(s1[i]);
        }
        int k = maximumRemovals(s, p, removable);
        System.out.println(k);
//        System.out.println(isSubStr("abcab", "ca"));

    }

    private static int maximumRemovals(String s, String p, int[] removable) {
        int res = 0;
        //删除s中的指定字符，构建新的字符
        char[] chars = s.toCharArray();
        for (int i = 0; i < removable.length; i++) {
            StringBuffer stringBuffer = new StringBuffer();

            for (int k = 0; k <= i; k++) {

            }
            String newStr = stringBuffer.toString();
            if (isSubStr(newStr, p)){
                res++;
            }else {
                break;
            }

        }

        return res;
    }

    private static boolean isSubStr(String newStr, String p) {
        int j = 0;
        int i = 0;
        for (; i < p.length(); i++) {
            boolean f = false;
            while (j < newStr.length()){
                if (newStr.charAt(j) != p.charAt(i)){
                    j++;
                }else {
                    f = true;
                    break;
                }
            }
            if (f){
               continue;
            }else {
                break;
            }
        }
        if (i == p.length()){
            return true;
        }
        return false;
    }
}
