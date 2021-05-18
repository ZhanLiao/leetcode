package generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/7 10:51
 * @Version: 1.0
 */
public class Main {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) {
        int n = 3;
        List<String> parenthesis = generateParenthesis(n);
        System.out.println(parenthesis.toString());


    }
    public static List<String> generateParenthesis(int n) {
        if(n == 0){
            return res;
        }
        int left = n, right = n;
        StringBuilder temp = new StringBuilder();
        dfs(n, left, right, temp);
        return res;
    }

    /**
     * 1、一个「合法」括号组合的左括号数量一定等于右括号数量，这个很好理解。
     * 2、对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量。
     * @param n
     * @param left 记录左括号
     * @param right 记录右括号
     * @param temp
     */
    private static void dfs(int n, int left, int right, StringBuilder temp) {
        if (left > right){
            return;
        }
        if (left < 0 || right < 0){
            return;
        }
        if (left == 0 && right == 0){
            String str = String.valueOf(temp);
            res.add(str);
        }

        //添加一个左括号
        temp.append('(');
        dfs(n, left - 1, right, temp);
        temp.deleteCharAt(temp.length() - 1);

        //添加一个右括号
        temp.append(')');
        dfs(n, left, right - 1, temp);
        temp.deleteCharAt(temp.length() - 1);

    }
}
