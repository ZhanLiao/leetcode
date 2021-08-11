package camelMatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ZhanLiao
 * @Description: 还没写好
 * @Date: 2021/7/14 10:41
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> ans = camelMatch(queries, pattern);
        for (Boolean an : ans) {
            System.out.println(an);
        }
    }

    private static List<Boolean> camelMatch(String[] queries, String pattern) {
        ArrayList<Boolean> res = new ArrayList<>();
        for (String query : queries) {
            int i = 0;
            int j = 0;
            int c = 0;
            boolean flag = false;
            while (i < query.length()){
                if (query.charAt(i) >= 'A' && query.charAt(i) <= 'Z'){
                    if (j < pattern.length()){
                        if(query.charAt(i) != pattern.charAt(j)){
                            res.add(false);
                            flag = true;
                            break;
                        }else {
                            j++;
                        }
                    }
                    c++;
                }
                i++;
            }
            if (!flag){
                if (c++ == j){
                    res.add(true);
                }else {
                    res.add(false);
                }
            }
        }
        return res;
    }
}
