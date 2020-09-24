package wordDivide;

import java.util.HashSet;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] divisible = new boolean[s.length() + 1];
        divisible[0] = true;
        HashSet<String> strings = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (divisible[j] && strings.contains(s.substring(j, i))){
                    divisible[i] = true;
                    break;
                }
            }
        }
        return divisible[s.length()];
    }
}
