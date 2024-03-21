// n : 컴퓨터의 수 1~200
// computers : 네트워크 연결 정보
// 0 : 연결 X, 1 : 연결 O
// 네트워크의 수 반환
// bfs와 visit 조합으로 풀어야할듯



import java.util.*;

class Solution {
    static boolean[] visit;
    static int gn;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        gn = n;
        visit = new boolean[n];
        
        visit[0] = true;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        int flag = 0;
        int temp = 0;
        while(flag != -1){
            dq.offer(flag);
            while(!dq.isEmpty()){
                temp = dq.poll();
                for(int i=0; i<n; i++){
                    if(!visit[i] && computers[temp][i] == 1){
                        visit[i] = true;
                        dq.offer(i);
                    }
                }
            }
            answer++;
            flag = check();
        }
        
        
        return answer;
    }
    
    public int check(){
        for(int i=0; i<gn; i++){
            if(!visit[i]){
                return i;
            }
        }
        return -1;
    }
}