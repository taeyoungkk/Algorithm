import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String[] S : clothes){
            map.put(S[1], map.getOrDefault(S[1],0) +1 );
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()){
            int n = entry.getValue();
            answer *= (n+1);
        }
        
        return answer - 1;
    }
}