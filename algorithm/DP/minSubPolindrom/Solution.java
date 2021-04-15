package minSubPolindrom;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/14 11:20
 * @Version: 1.0
 */
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        int len = 0;
        if (s == null || s.length() < 1) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            len = Math.max(len1, len2);
            if(len >  end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int i, int j) {
        while(i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            --i;
            ++j;
        }
        return j - i - 1;

    }
}
