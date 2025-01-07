// n : 멘토 수      k~20
// k : 상담 유형 수 1~5 
// reqs, 도착 기준 오름차, 도착 중복 없음
// 0 : 도착시간     1~1000
// 1 : 상담 시간    1~100 
// 2 : 상담 유형    1~k

// n의 수를 k개로 최소 1명 이상 배치 후 분배할 수 있는 모든 조합에 대한 결과 찾기
// 개선방안 : 계산한 값을 가지고 있을 방법은?
// 각 상담 유형 별, 상담 인원에 따른 대기시간 표를 미리 계산
// n-k 명 배치 후, 남은 인원으로 최대한 감소시킬 수 있는 조합 찾기.
// -> 인원을 배치했을 때, 이전 배치 경우보다 가장 많이 줄어드는 유형에 배치

import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        int[][] calc = new int[k+1][n-k+2];
        int len = reqs.length;
        
        List<List<Time>> req_list = new ArrayList<>();
        
        for(int i=0; i<=k+1; i++){
            req_list.add(new ArrayList<>());
        }
        
        for(int[] req : reqs){
            req_list.get(req[2]).add(new Time(req[0], req[1]));
        }
        
        for(int i=1; i<=k; i++){
            for(int j=1; j<=n-k+1; j++){
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                
                for(Time t : req_list.get(i)){
                    if(pq.isEmpty() || pq.size() < j){
                        pq.add(t.start + t.val);
                    }
                    else{
                        int temp = pq.poll();

                        if(temp > t.start){
                            calc[i][j] += temp-t.start;
                            pq.add(temp + t.val);
                        }
                        else{
                            pq.add(t.start + t.val);
                        }
                    }
                }
            }            
        }
                
        int[] counts = new int[k+1];
        Arrays.fill(counts, 1);
        counts[0] = -1;
        int remain = n-k;
        int answer = 0;
        if(n==k){
            for(int i=1; i<=k; i++){
                answer += calc[i][1];
            }
        }
        
        else{
            while(remain-- > 0){
                int maxVal = 0;
                int index = 0;

                for(int i=1; i<k+1; i++){
                    int diff = Math.abs(calc[i][counts[i]] - calc[i][counts[i]+1]);
                    if(maxVal < diff){
                        maxVal = diff;
                        index = i;
                    }
                }

                if(maxVal == 0){
                    break;
                }

                counts[index]++;
            }

            for(int i=1; i<=k; i++){
                answer += calc[i][counts[i]];
            }
        }
        return answer;
    }
    
    class Time{
        int start;
        int val;
        
        Time(int start, int val){
            this.start = start;
            this.val = val;
        }
        
    }
}
