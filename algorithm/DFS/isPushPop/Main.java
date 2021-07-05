package isPushPop;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/28 14:26
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int[] push = new int[s.length];
        int[] pop = new int[s.length];
        String[] s1 = scanner.nextLine().split(" ");
        for (int i = 0; i < s.length; i++) {
            push[i] = Integer.valueOf(s[i]);
            pop[i] = Integer.valueOf(s1[i]);
        }

        boolean ans = isPushPop(push, pop);
        System.out.println(ans);
    }

    private static boolean isPushPop(int[] push, int[] pop) {
        Deque<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < push.length; i++) {
            stack.push(push[i]);
            while (!stack.isEmpty() && stack.peek() == pop[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
