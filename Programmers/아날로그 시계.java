// https://school.programmers.co.kr/questions/64706 참고
// 시작 시간부터 종료 시간까지 울리는 알람의 횟수를 구하는 문제
// 00:00부터 종료 시간까지 울릴 수 있는 횟수 - 00:00부터 시작 시간까지 울릴 수 있는 횟수와 같다.
// 시침은 12시간에 한 바퀴, 분침은 60분에 한 바퀴, 시침은 60초에 한 바퀴
// 12시간 = 12 * 60 * 60 초에 한 바퀴 -> 초침은 12 * 60 바퀴 -> 720 - 시작위치(1) -> 719번
// 시침과 초침의 알람은 43200/719초 마다 한 번씩 작동
// 60분 = 60 * 60 초에 한 바퀴 -> 초침은 60 바퀴 -> 60 - 시작위치(1) -> 59번
// 분침과 초침의 알람은 3600/59초 마다 한 번씩 작동
// 12시 정각, 0시 정각에는 카운트가 2가 올라가야하지만 1만 올라가기에 페널티가 필요
// 마지막으로 현재 시작위치에서 알람이 울린다면 1을 더해주면 총 알람 횟수가 나타난다.
 

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int t2 = toSec(h2, m2, s2);
        int t1 = toSec(h1, m1, s1);
        return count(t2) - count(t1) + checkNow(t1);
    }
    
    public int toSec(int h, int m, int s){
        m += h * 60;
        s += m * 60;
        return s;
    }
    
    public int count(int s){
        int hCount = s * 719/43200;
        int mCount = s * 59/3600;
        int penalty = s >= 43200 ? 2 : 1;
        
        return hCount + mCount - penalty;
    }
    
    public int checkNow(int s){
        if(s * 719 % 43200 == 0 || s * 59 % 3600 == 0){
            return 1;
        }
        return 0;
    }
}