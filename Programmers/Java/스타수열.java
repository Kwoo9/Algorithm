import java.util.*;

// 처음 스타수열을 부분수열로 착각하여 헤맨 문제
// 빈도수가 높은 수를 우선적으로 스타수열에 적용해보고 나온 수를 비교하여 해당 값보다 적은 빈도를 가진 수는 패스


class Solution {
    public int solution(int[] a) {
        int answer = 0;
        if(a.length < 2){
            return 0;
        }
        
        int max_count = 0;
        int target = 0;
        int[] counts = new int[a.length + 1];
        
        for(int ab : a){
            counts[ab] ++;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2)->{
            return o2[1]-o1[1];
        });
        
        for(int i=0; i<counts.length; i++){
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = counts[i];
            pq.offer(temp);
        }
        
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            
            if(answer > temp[1]){
                break;
            }
            target = temp[0];
            int temp_answer = 0;
            boolean[] visit = new boolean[counts.length];
            
            for(int i=0; i<a.length; i++){
                if(a[i] == target){
                    if(i>0 && !visit[i-1] && !visit[i] && a[i] != a[i-1]){
                        visit[i] = true;
                        visit[i-1] = true;
                        temp_answer++;
                    }
                    
                    if(i<a.length-1 && !visit[i+1] && !visit[i] && a[i] != a[i+1]){
                        visit[i] = true;
                        visit[i+1] = true;
                        temp_answer++;
                    }
                    
                }
            }
            answer = temp_answer > answer ? temp_answer : answer;
            
            // System.out.println("temp : " + Arrays.toString(temp) + ", target : " + target + ", temp_ans : " + temp_answer);
        }
        
        return answer*2;
    }
}