class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] X = {781, 156, 31, 6, 1};
        
        for (int i = 0; i < word.length(); i++){
            int x;
            switch(word.charAt(i)){
                case 'A' :
                    answer += 1;
                    break;
                case 'E' :
                    answer += X[i] + 1;
                    break;
                case 'I' :
                    answer += X[i] * 2 + 1;
                    break;
                case 'O' :
                    answer += X[i] * 3 + 1;
                    break;
                case 'U' :
                    answer += X[i] * 4 + 1;
                    break;
            }
        }
        
        return answer;
    }
}