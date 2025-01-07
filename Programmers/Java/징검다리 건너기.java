// 하나하나 건너며 세는 것이 아닌 디딤돌의 수를 이용해 건널 수 있는 최대 값 구하기
// 큰 값을 입력으로 주어지며, 이를 시간 단축해 풀이하는 과정이 필요
// 이분탐색을 적용

import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200_000_000;
        
        
        while(min<=max){
            int mid = (min + max) / 2;
            if(cross(stones, k, mid)){
                min = mid+1;
                answer = Math.max(answer, mid);
            }
            else{
                max = mid - 1;
            }
        }
        
        
        return answer;
    }
    
    public boolean cross(int[] stones, int k, int mid){
        int count = 0;
        for(int stone : stones){
                        
            if(stone < mid){
                count++;
            }
            else{
                count = 0;
            }
            
            if(count >= k){
                return false;
            }
        }
        return true;
    }
}