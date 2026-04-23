import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String S : participant){
            map.put(S, map.getOrDefault(S,0) + 1);
        }
        
        for (String S : completion){
            map.put(S, map.get(S) - 1);
        }
        
        for (String S : map.keySet()){
            if (map.get(S) == 1){
                return(S);
            }
        }
        
        return "";
    }
}