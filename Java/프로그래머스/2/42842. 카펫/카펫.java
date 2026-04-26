class Solution {
    public int[] solution(int brown, int yellow) {
        int x = brown/2 + 1;
        int y = 1;
          
        while (x * y != brown + yellow){
            x--;
            y++;
        }    
            
        int[] answer = {x, y};

        return answer;
    }
}