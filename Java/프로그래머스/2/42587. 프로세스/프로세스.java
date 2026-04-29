import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        int[] sorted = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sorted);
        int idx = sorted.length - 1;
        
        Queue<Integer> Qp = new ArrayDeque<>();
        Queue<Integer> Ql = new ArrayDeque<>();
        
        for (int i = 0; i < priorities.length; i++){
            Qp.offer(priorities[i]);
            Ql.offer(i);
        }
        
        int max = sorted[idx];
        
        while (!Qp.isEmpty()){
            int p = Qp.poll();
            int l = Ql.poll(); 
            if (p == max){
                answer++;
                if (l == location){
                    return answer;
                }
                max = sorted[--idx];
            } else {
                Qp.offer(p);
                Ql.offer(l);
            }
        }
        
        return answer;
    }
}