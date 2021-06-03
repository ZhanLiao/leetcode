package groupAnagrams;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/3 16:29
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        List<List<String>> ans = groupAnagrams(strs);
        for (List<String> an : ans) {
            System.out.println(Arrays.toString(an.toArray()));
        }
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        String[] newStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
//            System.out.println(ch);
            newStrs[i] = String.valueOf(ch);
        }
        List<List<String>> res = new ArrayList<>();
        int[] flag = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (flag[i] == 1){
                continue;
            }
            ArrayList<String> list = new ArrayList<>();
            list.add(strs[i]);
            flag[i] = 1;
            for (int j = 0; j < strs.length; j++) {
                if (flag[j] == 1){
                    continue;
                }
                if (newStrs[i].equals(newStrs[j])){
                    list.add(strs[j]);
                    flag[j] = 1;
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    private static List<List<String>> groupAnagrams2(String[] strs) {
        String[] newStrs = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
//            System.out.println(ch);
            newStrs[i] = String.valueOf(ch);
        }
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> stringArrayListHashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (stringArrayListHashMap.containsKey(newStrs[i])){
                stringArrayListHashMap.get(newStrs[i]).add(strs[i]);
            }else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                stringArrayListHashMap.put(newStrs[i], list);
            }
        }
        for (ArrayList<String> value : stringArrayListHashMap.values()) {
            res.add(value);
        }
        return res;
    }
}
