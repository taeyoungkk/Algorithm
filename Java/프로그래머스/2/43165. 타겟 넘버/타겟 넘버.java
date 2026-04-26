class Solution {
    static int l, answer;
    
    public int solution(int[] numbers, int target) {
        l = numbers.length;
        answer = 0;
        
        dfs(0, 0, numbers, target);
        
        return answer;
    }
    
    static void dfs(int n, int sum, int[] numbers, int target){
        if (n == l){
            if (sum == target){
                answer += 1;
            }
            return;
        }
        
        dfs(n + 1, sum + numbers[n], numbers, target);
        dfs(n + 1, sum - numbers[n], numbers, target);
    }
}