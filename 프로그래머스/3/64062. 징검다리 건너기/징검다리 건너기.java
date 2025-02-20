class Solution {
    public int solution(int[] stones, int k) {
        int maxFriends = 0;
        int left = 1;
        int right = 200000000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (canCross(stones, k, mid)) {
                left = mid + 1;
                maxFriends = Math.max(maxFriends, mid);
            } else {
                right = mid - 1;
            }
        }
        
        return maxFriends;
    }
    
    private boolean canCross(int[] stones, int k, int friends) {
        int consecutiveZeros = 0;
        
        for (int stone : stones) {
            if (stone - friends < 0) {
                consecutiveZeros++;
            } else {
                consecutiveZeros = 0;
            }
            
            if (consecutiveZeros == k) {
                return false;
            }
        }
        
        return true;
    }
}
