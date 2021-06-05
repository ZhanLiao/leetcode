package merge;

import java.util.*;

/**
 * @Author: ZhanLiao
 * @Description:
 * @Date: 2021/6/4 20:59
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = scanner.nextInt();
            intervals[i][1] = scanner.nextInt();
        }
        int[][] ans = merge(intervals);
        for (int[] an : ans) {
            System.out.println(Arrays.toString(an));
        }
    }

    private static int[][] merge(int[][] intervals) {
        ArrayList<int[]> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            intervalList.add(interval);
        }
        Collections.sort(intervalList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] < o1[0]){
                    return 1;
                }else if (o2[0] > o1[0]){
                    return -1;
                }
                return 0;
            }
        });
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int star = intervalList.get(i)[0];
            int end = intervalList.get(i)[1];

            //找出end在哪个区间上
            int count = 0;
            for (int j = i+1; j < intervals.length; j++) {
                if (end < intervalList.get(j)[0]){
                    //找不到
                    break;
                }else {
                    if (end < intervalList.get(j)[1]){
                        //找到了
                        end = intervalList.get(j)[1];
                    }
                    count++;
                }
            }
            list.add(new int[]{star, end});
            i += count;
        }

        int[][] res = new int[list.size()][2];
        int i = 0;
        for (int[] ints : list) {
            res[i] = ints;
            i++;
        }
        return res;
    }
}
