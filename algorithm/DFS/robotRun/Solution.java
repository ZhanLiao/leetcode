package robotRun;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 16:02
 * @Version: 1.0
 */
public class Solution {
    int m, n;
    int[][] flag;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.flag = new int[m][n];
        int res = 0;
        res = dfs(0, 0, m, n, k);
        return res;
    }
    private int dfs(int i, int j, int m, int n, int k){
        if(!chackLegal(i, j, m, n, k)){
            return 0;
        }
        flag[i][j] = -1;
        return 1 + dfs(i+1, j, m, n, k) + dfs(i, j+1, m, n, k) + dfs(i-1, j, m, n, k) + dfs(i, j-1, m, n, k);
    }

    private boolean chackLegal(int i, int j, int m, int n, int k){
        if(i >= 0 && i < m && j >= 0 && j < n && getDigitSum(i) + getDigitSum(j) <= k &&  flag[i][j] != -1){
            return true;
        }
        return false;
    }

    private int getDigitSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
