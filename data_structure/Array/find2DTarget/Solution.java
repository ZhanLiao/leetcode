package find2DTarget;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 10:39
 * @Version: 1.0
 */
public class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int r = matrix.length;
        int c = matrix.length;
        int row = 0;
        int col = c - 1;

        while(row < r && col < c){
            if(target == matrix[row][col]){
                return true;
            }else if (matrix[row][col] > target){
                col -= 1;
            }else {
                row += 1;
            }
        }
        return false;
    }
}
