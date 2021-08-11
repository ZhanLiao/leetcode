package topoSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/8/6 10:58
 * @Version: 1.0
 */
public class Test02 {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}}; // 完成0之前必须完成1
        // 判断是否能完成所有的课程
        boolean ans = canFinish(numCourses, prerequisites);
        System.out.println(ans);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites){
        //节点的入度
        int[] incomes = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            incomes[prerequisites[i][1]]++;
        }
        // 节点的出度
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (incomes[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (Integer integer : list.get(cur)) {
                incomes[integer]--;
                if (incomes[integer] == 0){
                    queue.add(integer);
                }
            }
        }
        for (int i = 0; i < incomes.length; i++) {
            if (incomes[i] != 0){
                return false;
            }
        }
        return true;
    }
}
