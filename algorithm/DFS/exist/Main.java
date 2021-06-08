package exist;

import java.util.Scanner;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/7 9:53
 * @Version: 1.0
 */
public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        String word = scanner.nextLine();
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = s[j].charAt(0);
            }
        }
        scanner.close();
        boolean ans = exist(board, word);
        if (ans){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }

    private static boolean exist(char[][] board, String word) {
        // 找到单词的第一个字符所在位置
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word.charAt(0) == board[i][j]){
                    int[] curIndex = new int[]{i, j};
                    int[][] flag = new int[n][m];
                    int index = 0;
                    if (dfs(curIndex, board, index, word, flag)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(int[] curIndex, char[][] board, int index, String word, int[][] flag) {
        if (word.charAt(index) != board[curIndex[0]][curIndex[1]]){
            return false;
        }else if (index == word.length()-1){
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int[] nextIndex = next(curIndex, i);
            if (!checkLegal(nextIndex[0], nextIndex[1], flag, board)){
                continue;
            }
            flag[curIndex[0]][curIndex[1]] = -1;
            if (word.charAt(index) == board[curIndex[0]][curIndex[1]]){
                if (dfs(nextIndex, board, index+1, word, flag)){
                    return true;
                }
            }
            flag[curIndex[0]][curIndex[1]] = 0;
        }
        return false;
    }

    private static boolean checkLegal(int i, int j, int[][] flag, char[][] board) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || flag[i][j] == -1){
            return false;
        }else {
            return true;
        }
    }

    private static int[] next(int[] curIndex, int i) {
        int[] res = new int[2];
        switch (i){
            case 0 :
                res = new int[]{curIndex[0]-1, curIndex[1]};
                break;
            case 1 :
                res = new int[]{curIndex[0]+1, curIndex[1]};
                break;
            case 2 :
                res = new int[]{curIndex[0], curIndex[1]-1};
                break;
            case 3 :
                res = new int[]{curIndex[0], curIndex[1]+1};
            default:
                break;
        }
        return res;
    }
}
