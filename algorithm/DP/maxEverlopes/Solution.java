package maxEverlopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }
        if(envelopes.length == 1){
            return 1;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            }
        });
        int maxSubLength = 1;
        int[] counts = new int[envelopes.length];
        counts[0] = 1;

        for (int i = 1; i < envelopes.length; i++) {
            int tempMax = 0;
            for(int j = 0; j < i; j++){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]){
                    tempMax = Math.max(tempMax, counts[j]);
                }
            }
            counts[i] = tempMax + 1;
            maxSubLength = Math.max(maxSubLength, counts[i]);
        }
        return maxSubLength;
    }
}
