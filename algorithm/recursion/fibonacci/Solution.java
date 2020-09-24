package fibonacci;

public class Solution {
    public int fib(int N) {
//         解法1：递归树，有很多重复计算
//         if (N == 0){
//             return 0;
//         }
//         if (N == 1){
//             return 1;
//         }
//         return fib(N - 1) + fib(N - 2);

        // 解法2： 将已经计算的结果存在一个数组里面。消耗空间。
        if (N <= 1){
            return N;
        }else{
            int[] temp = new int[N+1];
            temp[0] = 0;
            temp[1] = 1;
            for (int i = 2; i <= N; i++) {
                temp[i] = temp[i - 1] + temp[i - 2];
            }
            return temp[N];
        }
    }
}
