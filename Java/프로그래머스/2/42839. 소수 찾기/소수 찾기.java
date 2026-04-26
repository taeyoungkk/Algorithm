import java.util.*;

class Solution {
    static int l;
    static Set<Integer> set;
    static boolean[] visited;
    static char[] C;
    
    public int solution(String numbers) {
        int answer = 0;
        
        l = numbers.length();
        
        C = new char[l];
        
        for (int i = 0; i < l; i++){
            C[i] = numbers.charAt(i);
        }

        set = new HashSet<>();
        visited = new boolean[l];
        
        dfs("");
        
        for (int n : set) {
            if (isPrime(n)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    static void dfs(String s){
        if (!s.equals("")) {
            set.add(Integer.parseInt(s));
        }

        for (int i = 0; i < l; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(s + C[i]);
                visited[i] = false;
            }
        }
    }
    
    static boolean isPrime(int n){  
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++){
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
}