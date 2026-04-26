import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {   
        int l = genres.length;
        
        Map<String, Integer> p = new HashMap<>();
        Map<String, Map<Integer, Integer>> x = new HashMap<>();
        
        for (int i = 0; i < l; i++){
            p.put(genres[i], p.getOrDefault(genres[i], 0) + plays[i]);
            
            Map<Integer, Integer> map = x.getOrDefault(genres[i], new HashMap<>());
            map.put(i, plays[i]);
            x.put(genres[i], map);
        }
        
        List<Integer> A = new ArrayList<>();
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(p.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        
        for (Map.Entry<String, Integer> e: list){
            String genre = e.getKey();
            Map<Integer, Integer> map = x.get(genre);
            
            List<Map.Entry<Integer, Integer>> list1 = new ArrayList<>(map.entrySet());
            list1.sort((a, b) -> b.getValue() - a.getValue());
            
            for (int i = 0; i < Math.min(2, list1.size()); i++){
                A.add(list1.get(i).getKey());
            }
        }
        
        int[] answer = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            answer[i] = A.get(i);
        } 
        
        return answer;
    }
}