import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int l = nums.length/2;
        Set<Integer> set = new HashSet<>();
        
        for (int n : nums){
            set.add(n);
        }
        
        return Math.min(set.size(),l);
    }
}