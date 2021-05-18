package calculation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public int calculate(String s) {
        Deque<Integer> num = new ArrayDeque<>();
        Deque<Character> opt = new ArrayDeque<>();
        num.addLast(0);
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");
        int n = s.length();
        char[] ch = s.toCharArray();

        for(int i = 0; i < n; i++){
            char c = ch[i];
            if(c == '('){
                opt.addLast(c);
            }else if(c == ')'){
                // 计算括号内的
                while(!opt.isEmpty()){
                    char o = opt.peekLast();
                    if(o != '('){
                        cal(num, opt);
                    }else {
                        opt.pollLast();
                        break;
                    }
                }

            }else {
                if(isNum(c)){
                    // 遇到一个数字字符时，将其后面连续的数字字符都合并为上来构成一个整数
                    int u = 0;
                    int j = i;
                    while(j < n && isNum(ch[j])){
                        u = u * 10 + (int)(ch[j++] - '0');
                    }
                    num.addLast(u);
                    i = j - 1;
                }else {
                    // 剩下只能遇到一个操作符
                    while (!opt.isEmpty() && opt.peekLast() != '('){
                        cal(num, opt);
                    }
                    opt.addLast(c);
                }
            }
        }
        while(!opt.isEmpty()){
            cal(num, opt);
        }
        return num.peekLast();
    }


    private boolean isNum(char c){
        return Character.isDigit(c);
    }

    private void cal(Deque<Integer> num, Deque<Character> opt){
        if(num.isEmpty() || num.size() < 2) return;
        if(opt.isEmpty()){
            return;
        }
        int a = num.pollLast();
        int b = num.pollLast();
        num.addLast(opt.pollLast() == '+' ? (b + a) : (b - a));
    }
}
