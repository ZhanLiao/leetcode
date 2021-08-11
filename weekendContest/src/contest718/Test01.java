package contest718;

/**
 * @Author: ZhanLiao
 * @Description: 判断能打出来的字母
 * @Date: 2021/7/18 10:34
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";
        int ans = canBeTypedWords(text, brokenLetters);
        System.out.println(ans);
    }

    private static int canBeTypedWords(String text, String brokenLetters) {
        String[] strings = text.split(" ");
        int res = 0;
        for (int i = 0; i < strings.length; i++) {
            boolean flag = false;
            for (int j = 0; j < brokenLetters.length(); j++) {
                if (strings[i].contains(String.valueOf(brokenLetters.charAt(j)))){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                res++;
            }
        }
        return res;
    }
}
