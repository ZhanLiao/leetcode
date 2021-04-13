package matriRoute;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 15:50
 * @Version: 1.0
 */
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] ch_word= word.toCharArray();
        for(int i= 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, ch_word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] ch_word, int i, int j, int k){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != ch_word[k]){
            return false;
        }
        if(k == ch_word.length - 1){
            return true;
        }

        board[i][j] = '\0';
        boolean res =  dfs(board, ch_word, i, j+1, k+1) || dfs(board, ch_word, i+1, j, k+1) || dfs(board, ch_word, i-1, j, k+1) || dfs(board, ch_word, i, j-1, k+1);

        board[i][j] = ch_word[k];

        return res;
    }
}
