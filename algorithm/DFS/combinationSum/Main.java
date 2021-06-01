package combinationSum;

import jdk.nashorn.internal.ir.CallNode;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/1 17:17
 * @Version: 1.0
 */
public class Main {
    static HashSet<ArrayList<Integer>> listHashSet = new HashSet<>();
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
        dfs(resList, temp, candidates, target, count);

        return resList;
    }

    private static void dfs(List<List<Integer>> resList, ArrayList<Integer> temp, int[] candidates, int target, int count) {

        if (count >= target){
            if (target == count){
                ArrayList<Integer> t = new ArrayList<>(temp);
                if (!listHashSet.contains(t)){
                    resList.add(t);
                }
            }
            return;
        }

        for (int candidate : candidates) {
            if (candidate > target){
                continue;
            }
            temp.add(candidate);
            count += candidate;
            dfs(resList, temp, candidates, target, count);
            count -= candidate;
            temp.remove(temp.size() - 1);
        }
    }
}
