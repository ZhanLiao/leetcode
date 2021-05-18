package openLock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String[] deads = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println("openLock(deads, target) = " + openLock(deads, target));
    }

    public static int openLock(String[] deadends, String target) {
        // 存储死亡密码和已经试过的密码
        Set<String> invalids = new HashSet<String>();
        for(String s : deadends){
            invalids.add(s);
        }
        Set<String> visits = new HashSet<String>();
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while(!q.isEmpty()){
            int size = q.size();
            //向着周围的扩散
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                System.out.println(cur);
                // 判断当前密码是不是无效的密码，
                if(invalids.contains(cur)){
                    continue;
                }
                if(cur.equals(target)){
                    return res;
                }
                // 将能当前节点的附近点都加入队列中
                for(int j = 0; j < 4; j++){
                    String upString = up(cur, j);
                    String downString = down(cur, j);

                    if(!visits.contains(upString)){
                        q.offer(upString);
                        visits.add(upString);
                    }
                    if (!visits.contains(downString)){
                        q.offer(downString);
                        visits.add(downString);
                    }
                }
            }
            res++;
        }
        //找不到答案
        return -1;
    }

    private static String up(String cur, int j){
        char[] ch = cur.toCharArray();
        if(ch[j] == '9'){
            ch[j] = '0';
        }else {
            ch[j] += 1;
        }
        return new String(ch);
    }
    private static String down(String cur, int j){
        char[] ch = cur.toCharArray();
        if(ch[j] == '0'){
            ch[j] = '9';
        }else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
