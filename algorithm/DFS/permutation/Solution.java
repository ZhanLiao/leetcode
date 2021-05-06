package permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/4/29 10:47
 * @Version: 1.0
 */
public class Solution {
    List<List<Integer>> ansList = new ArrayList<List<Integer>>();
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        List<Integer> tempList = new ArrayList<>();
        permuteRe(list, tempList);
        return ansList;

    }

    /**
     *
     * @param list : 选择列表
     * @param tempList : 选择路径
     */
    private void permuteRe(ArrayList<Integer> list, List<Integer> tempList) {
        if(tempList.size() == list.size()){
            ansList.add(new ArrayList<>(tempList));
            return;
        }
        for (Integer l : list) {
            // 排除不合法的选择
            if (tempList.contains(l)){
                continue;
            }
            // 将选择添加到路径列表
            tempList.add(l);
            permuteRe(list, tempList);
            // 回溯，取消选择的路径
            tempList.remove(l);
        }
    }
}
