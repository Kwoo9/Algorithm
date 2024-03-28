// 야근 피로도 : 야근 시작 시점에서 남은 일의 작업량을 제곱해서 더한 값
// 한시간에 작업량 1 처리 가능
// N시간동안 작업
// 작업량에서 총 N의 값을 제거하여 야근 피로도를 최소로 만들어라
// 가장 큰 수에서 1씩 제거하는 방식
// works.length : 1~20000
// works[i] <= 50000
// n <= 1000000


import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works){
            pq.offer(work);
        }
        int temp = 0;
        for(int i=0; i<n; i++){
            if(pq.isEmpty()){
                break;
            }
            temp = pq.poll();
            if(temp-1 > 0){
                pq.offer(temp - 1);
            }
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}