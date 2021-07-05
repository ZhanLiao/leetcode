package cutRope2;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/13 16:58
 * @Version: 1.0
 */
public class Solution {
    public int cuttingRope(int n) {

        if(n <= 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int[] product = new int[n+1];
        product[0] = 0;
        product[1] = 1;
        product[2] = 2;
        product[3] = 3; // 这里为什么是三

        int max;
        for(int i = 4; i <= n; i++){
            max = 0;
            for(int j = 1; j <= i/2; j++){
                int tempProduct = product[j] * product[i - j];
                if(max < tempProduct){
                    max = tempProduct;
                }
            }
            product[i] = max;
        }
        max = product[n];

        return max;
    }
}
