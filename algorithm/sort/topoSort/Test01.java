package topoSort;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/8/6 10:14
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        // 输入二维数组，索引为0时，表示有1， 2两个走向
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        List<Integer> ans = eventualSafeNodes(graph);
        System.out.println(ans);
    }

    private static List<Integer> eventualSafeNodes(int[][] graph) {
        // 记录节点的出度，刚好和原图相反
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // 记录节点的入度长度
        int[] income = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                list.get(graph[i][j]).add(i);
            }
            income[i] = graph[i].length;
        }

        // 拓扑排序的整个过程
        Queue<Integer> queue = new LinkedList<>();
        // 将入度为0的都添加到队列中
        for (int i = 0; i < income.length; i++) {
            if (income[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (Integer integer : list.get(cur)) {
                income[integer]--;
                if (income[integer] == 0){
                    queue.offer(integer);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < income.length; i++) {
            if (income[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
