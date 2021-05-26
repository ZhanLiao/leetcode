package lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/24 11:58
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        int ans = lengthOfLongestSubstring(s);
        System.out.println(ans);
    }

    private static int lengthOfLongestSubstring(String s) {

        int ans = 0;
        int len = s.length();
        HashSet<Character> set = new HashSet<>();   // 记录不重复元素
        int j = 0;  // 右指针
        for (int i = 0; i < len; i++) {
            while (j < len && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }
            ans = Math.max(ans, j - i);
            // 每次左指针右移都需要删除重复节点
            // 不能移动j的时候证明set里面还有重复元素，要删掉
            set.remove(s.charAt(i));
        }
        return ans;
    }

    private static int lengthOfLongestSubstring1(String s) {
        if (s.equals(" ") ){
            return 1;
        }
        if (s.equals("")){
            return 0;
        }
        int len = s.length();
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        ArrayList<Character> list = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;
        while (i <= j && j < len){
            if (list.contains(s.charAt(j))){
                int curPreIndex = 0;
                //出现重复的字符，需要找到重复字符的索引
                for (int k = j-1; k >= i ; k--) {
                    if (s.charAt(k) == s.charAt(j)){
                        curPreIndex = k;
                        break;
                    }
                }
                for (int k = i; k <= curPreIndex; k++) {
                    list.set(k, ' ');
                }
                i = curPreIndex + 1;
            }
            list.add(s.charAt(j));
            maxLen = Math.max(j - i + 1, maxLen);
            j++;
        }
        return maxLen;
    }

}
