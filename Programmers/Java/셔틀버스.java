// 9시부터 n회 t분
// 시간을 비교할 수 있도록 분단위로 변환 및 복구
// 타임테이블을 분단위로 변환한 뒤 우선순위 큐를 통해 우선순위
// 차량에 탑승 가능한 인원을 다 넣은 후
// 마지막 차량에 탈 수 있다면 해당 운행 시각 반환
// 탈 수 없다면 마지막 차량 마지막 인원 시간 - 1분 후 시:분 으로 변환하여 반환

import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String time : timetable){
            pq.offer(timeToMin(time));
        }
        
        int start = timeToMin("09:00");
        int now = start;
        int count = 0;
        int last = start;
        for(int i=0; i<n; i++){
            count = 0;
            while(!pq.isEmpty()){
                now = pq.peek();
                if(now <= start && count<m){
                    last = pq.poll();
                    count++;
                }else{
                    break;
                }
            }
            start += t;
        }
        // System.out.println(last);
        // System.out.println(minToTime(last-1));
        // System.out.println("count : " + count + ", m : " + m);
        answer = count < m ? minToTime(start - t) : minToTime(last - 1);
        
        return answer;
    }
    
    public int timeToMin(String time){
        int trans = Integer.parseInt(time.substring(0,2)) * 60 
            + Integer.parseInt(time.substring(3,5));
        
        return trans;
    }
    
    public String minToTime(int time){
        return String.format("%02d", time/60) + ":" + String.format("%02d", time%60);
    }
}