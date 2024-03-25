import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
//      *의 갯수 s
//      s = log_3 n = log(n) / log(3)
        int s = (int) (Math.log(n) / Math.log(3));
        
        if(s < 1){
            return 0;
        }
//      마지막은 무조건 ++로 끝난다.
//      *는 s의 2배의 갯수를 가진다.
//      star*2 <= plus
        return dfs(n-2, s, s*2-2, 2, 0);
    }
// n : 현재 음 높이 남은 값, star : * 갯수, plus : + 갯수
// d_plus : 제거한 + 갯수, d_star : 제거한 * 갯수
    public int dfs(int n, int star, int plus, int d_plus, int d_star){
        int a = 0;
        int b = 0;
        
//      star*2 <= plus
        if(d_star * 2 > d_plus){
            return 0;
        }
        
//      3보다 작은 경우, * 연산 불가
        if(n<3){
            return 0;
        }
//      남은 값이 3이고, star 하나만 남을 경우 1을 반환
        else if(n==3 && star == 1 && plus==0){
            return 1;
        }
        
//      + 남은 수가 0이 넘으면 +를 하나 빼고 다음으로 넘어가는 조건
        if(plus>0){
            a = dfs(n-1, star, plus-1, d_plus+1, d_star);
        }
//      현재 값을 3으로 나눌 수 있고, *의 갯수가 남아있는 경우
        if(n%3==0 && star>0){
            b = dfs(n/3, star-1, plus, d_plus, d_star+1);
        }
        
        return a+b;
        
    }
}