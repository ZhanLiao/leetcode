package topKFrequentStr;

import com.sun.xml.internal.ws.util.QNameMap;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/5/20 9:16
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        int k = scanner.nextInt();
        List<String> ans = new ArrayList<>();
        ans = topKFrequent(words, k);
        System.out.println(ans);
    }

    private static List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> wordsFrequentMap = new HashMap<>();
        for (String word : words) {
            wordsFrequentMap.put(word, wordsFrequentMap.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() > o2.getValue()){
                    return 1;
                }if (o1.getValue() == o2.getValue()){
                    return o2.getKey().compareTo(o1.getKey());
                }else {
                    return -1;
                }
            }
        });
        int flag = 0;
        for (String string : wordsFrequentMap.keySet()) {
            if (flag >= k){
                break;
            }
            HashMap<String, Integer> stringIntegerHashMap = new HashMap<String, Integer>();
            stringIntegerHashMap.put(string, Integer.MIN_VALUE);
            Map.Entry<String, Integer> entry = stringIntegerHashMap.entrySet().iterator().next();
            for (Map.Entry<String, Integer> stringIntegerEntry : stringIntegerHashMap.entrySet()) {
                entry = stringIntegerEntry;
            }
            minHeap.add(entry);
            flag++;
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : wordsFrequentMap.entrySet()) {
            if (stringIntegerEntry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.add(stringIntegerEntry);
            }else if (stringIntegerEntry.getValue() == minHeap.peek().getValue()){
                if (stringIntegerEntry.getKey().compareTo(minHeap.peek().getKey()) < 0){
                    minHeap.poll();
                    minHeap.add(stringIntegerEntry);
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(0, minHeap.poll().getKey());
        }
        /*Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                if (wordsFrequentMap.get(o1) == wordsFrequentMap.get(o2)){
                    return o1.compareTo(o2);
                }else {
                    return -1;
                }
            }
        });*/
        return list;
    }
}
