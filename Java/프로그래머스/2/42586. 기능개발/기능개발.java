import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> Qp = new ArrayDeque<>();
        Queue<Integer> Qs = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++){
            Qp.offer(progresses[i]);
            Qs.offer(speeds[i]);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        while (!Qp.isEmpty()){
            int l = Qp.size();
            for (int i = 0; i < l; i++){
                int p = Qp.poll();
                int s = Qs.poll();
                Qp.offer(p+s);
                Qs.offer(s);
            }
            int cnt = 0;
            while(!Qp.isEmpty() && Qp.peek() >= 100){
                Qp.poll();
                Qs.poll();
                cnt++;
            }
            if (cnt != 0){
                answer.add(cnt);
            }
        }
        
        int[] ans = new int[answer.size()];
        
        int idx = 0;
        for (int n : answer){
            ans[idx++] = n;
        }
        
        return ans;
    }
}