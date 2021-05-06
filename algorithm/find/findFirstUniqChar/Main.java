package findFirstUniqChar;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/19 15:13
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        String s = "leetcode";
        char ans = firstUniqChar(s);
        System.out.println(ans);
    }

    private static char firstUniqChar(String s) {
        char ch = ' ';
        HashMap<Character, Integer> characterHashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            characterHashMap.put(s.charAt(i), characterHashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {

            if (characterHashMap.get(s.charAt(i)) == 1){
                ch = s.charAt(i);
                return ch;
            }
        }
        return ch;
    }

}
