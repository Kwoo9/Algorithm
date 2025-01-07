import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        // System.out.println(Arrays.toString(dp));
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<=n; j++){
                dp[j] += dp[j-money[i]] % 1_000_000_007;                
                // System.out.println(Arrays.toString(dp));
            }
        }
        return dp[n];
    }
}