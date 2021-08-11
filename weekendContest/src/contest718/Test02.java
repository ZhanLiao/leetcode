package contest718;

/**
 * @Author: ZhanLiao
 * @Description:新增的最少台阶数
 * 输入：rungs = [1,3,5,10], dist = 2
 * 输出：2
 * 解释：
 * 现在无法到达最后一阶。
 * 在高度为 7 和 8 的位置增设新的台阶，以爬上梯子。
 * 梯子在高度为 [1,3,5,7,8,10] 的位置上有台阶。
 * @Date: 2021/7/18 10:49
 * @Version: 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        int[] rungs = {3};   //3,4,6,7; 3
        int dist = 1;   // 2; 1

        int ans = addRungs(rungs, dist);
        System.out.println(ans);

    }

    private static int addRungs(int[] rungs, int dist) {
        int res = 0;
        int first = 0;
        int second = rungs[0];
        int i = 1;
        while (true) {
            int val = second - first;
            if (val > dist){
                if (val % dist == 0){
                    res += (val / dist - 1);
                }else {
                    res += (val / dist);
                }
            }
            if (i > rungs.length-1){
                break;
            }
            first = second;
            second = rungs[i];
            i++;
        }
        return res;
    }
}
