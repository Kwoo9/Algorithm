import java.util.*;

// 줄이고 줄이고 줄여서 통과
// 첫 시도는 각 집마다 전집의 경우를 고려하여 2차원 dp로 0의 경우는 해당집을 털지 않는 경우로 전 집을 터는 경우와 안터는 경우 중 큰 값을 넣고, 1의 경우는 전집을 털지않고 현재 집을 터는 경우의 값을 저장하는 방식으로 진행
// 해당 방식은 모든 집들이 동그랗게 배치되어있다는 가정을 지키지 못해서 실패

// 두번째 시도는 첫 번째집부터 마지막-1집까지로 계산하는 경우와, 두 번째집부터 마지막 집까지 계산하는 경우로 나타난 값 중 가장 큰 값을 반환하는 방식을 시도하였다.
// 해당 방식을 통해 정답은 맞았으나 효율성 부분에서 모두 실패하였다.

// 세번째 시도는 dp를 1차원으로 축소하고, 전집이 아닌 전전집 + 현재집과 전집의 값을 비교하여 저장하는 방식으로 수정하였고 
// 0~last-1, 1~last의 두 가지 경우를 생각하는 것은 동일하다.
// 해당 방식을 통해 답을 맞출 수 있었다.

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int dp[] = new int[money.length];
        int dp2[] = new int[money.length];
        
//      맨 앞집 고려
        dp[0] = money[0];
        dp[1] = money[1] > money[0] ? money[1] : money[0];
        
//      맨 뒷집 고려
        dp2[0] = 0;
        dp2[1] = money[1];
        
        for(int i=2; i<money.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + money[i]);
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + money[i]);
        }
        
        // System.out.println("dp : " + Arrays.deepToString(dp) + ", dp2 : " + Arrays.deepToString(dp2));
        
        answer = Math.max(dp[money.length-2], dp2[money.length-1]);
        
        return answer;
    }
}