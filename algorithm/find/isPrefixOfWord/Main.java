package isPrefixOfWord;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/7/8 1:34
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = "i love eating burger", searchWord = "burg";
        int ans = isPrefixOfWord(sentence, searchWord);
        System.out.println(ans);
    }

    private static int isPrefixOfWord(String sentence, String searchWord) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < searchWord.length()){
                continue;
            }else {
                if (s[i].substring(0, searchWord.length()).equals(searchWord)){
                    return i+1;
                }
            }
        }
        return -1;
    }
}
