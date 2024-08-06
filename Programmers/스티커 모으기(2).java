// 값을 저장해가며 더함? dp
// 무조건 차례가 될 때마다 떼어야하는 게 아님
// 원하는 값만 골라 가장 큰 값을 만들어야함

import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int len = sticker.length;
        if (len == 1){
            return sticker[0];
        }
        
        int[] dp = new int[len];
        
        dp[0] = sticker[0];
        dp[1] = dp[0];
        
        for(int i=2; i<len-1; i++){
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        
        answer = dp[len-2];
        
        dp[0] = 0;
        dp[1] = sticker[1];
        
        for(int i=2; i<len; i++){
            dp[i] = Math.max(dp[i-2] + sticker[i], dp[i-1]);
        }
        
        answer = Math.max(answer, dp[len-1]);

        return answer;
    }
}