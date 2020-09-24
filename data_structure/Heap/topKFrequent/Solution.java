package topKFrequent;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 8, 2, 3, 5, 3, 4, 2, 1, 8, 3};
        System.out.println(Arrays.toString(topKFrequent(nums, 3)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            /*if (!integerHashMap.containsKey(nums[i])){
                integerHashMap.put(nums[i], 1);
            }else {
                Integer count = (Integer) integerHashMap.get(nums[i]);
                integerHashMap.put(nums[i], count+1);
            }*/
            // map.getOrDefault() 查找map中元素，如果不存在返回默认值。
            integerHashMap.put(nums[i], integerHashMap.getOrDefault(nums[i], 0) + 1);

        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        for (Integer ih : integerHashMap.keySet()) {
            if (minHeap.size() != k){
                minHeap.offer(integerHashMap.get(ih));
            }else if (minHeap.peek() < integerHashMap.get(ih)){
                minHeap.poll();
                minHeap.offer(integerHashMap.get(ih));
            }

        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer mh : minHeap){
            for (Integer ih : integerHashMap.keySet()){
                if (integerHashMap.get(ih) == mh){
                    temp.add(ih);
                    integerHashMap.remove(ih);
                    break;
                }
            }
        }

        int[] ret = new int[k];
        for (int i = 0; i < temp.size(); i++) {
            ret[i] = temp.get(i);
        }
        return ret;
    }
}
