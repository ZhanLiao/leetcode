package letterCombinations;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/27 9:43
 * @Version: 1.0
 */
public class Main {
    static HashMap<Character, String> digitsMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String digits = scanner.nextLine();

        List<String> list = lettersCombinations(digits);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static List<String> lettersCombinations(String digits) {
        List<String> list = new ArrayList<>();
        digitsMap.put('2', "abc");    digitsMap.put('3', "def");
        digitsMap.put('4', "ghi");    digitsMap.put('5', "jkl");
        digitsMap.put('6', "mno");    digitsMap.put('7', "pqrs");
        digitsMap.put('8', "tuv");    digitsMap.put('9', "wxyz");
        int floor = 0;
        StringBuffer stringBuffer = new StringBuffer();
        dfs(list, stringBuffer, floor, digits);
        return list;
    }

    private static void dfs(List<String> list, StringBuffer stringBuffer, int floor, String s) {
        if (stringBuffer.length() == s.length()){
            list.add(new String(stringBuffer));
            return;
        }
        String str = digitsMap.get(s.charAt(floor));
        for (int i = 0; i < str.length(); i++) {
            stringBuffer.append(str.charAt(i));
            dfs(list, stringBuffer, floor+1, s);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
        }
    }
}
