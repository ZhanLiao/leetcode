package combinationSum;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/1 17:17
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] candidates = new int[n];
        for (int i = 0; i < n; i++) {
            candidates[i] = scanner.nextInt();
        }

        List<List<Integer>> list = combinationSum(candidates, target);
        for (List<Integer> integers : list) {
            System.out.println(Arrays.toString(integers.toArray()));
        }

    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resList = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        dfs(0, resList, temp, candidates, target, count);

        return resList;
    }

    private static void dfs(int star, List<List<Integer>> resList, ArrayList<Integer> temp, int[] candidates, int target, int count) {

        if (count >= target){
            if (target == count){
                ArrayList<Integer> t = new ArrayList<>(temp);
                resList.add(t);
            }
            return;
        }

        for (int i = star; i < candidates.length; i++) {
            if (candidates[i] > target){
                continue;
            }
            temp.add(candidates[i]);
            count += candidates[i];
            dfs(i, resList, temp, candidates, target, count);
            count -= candidates[i];
            temp.remove(temp.size() - 1);
        }
    }
}
