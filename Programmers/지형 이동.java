import java.util.*;

// 공간별로 나누고 각 공간과 사다리가 놓을 때마다 같은 공간으로 취급하는 방식

class Solution {
    static boolean[] visit;
    static int[][] visit_land;
    static int n, size;
    static int[] di = {1, -1, 0, 0};
    static int[] dj = {0, 0, 1, -1};
    static int[] checkList;
    public int solution(int[][] land, int height) {
        int answer = 0;
        n = land.length;
        visit_land = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[2] - o2[2];
        });
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        dq.offer(0);
        size = 1;
        visit_land[0][0] = size;
        int count = 0;
        while(true){
            if(count == n*n){
                break;
            }
            while(!dq.isEmpty()){
                count++;
                int temp = dq.poll();
                int i = temp/301;
                int j = temp%301;
                for(int d=0; d<4; d++){
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    
                    if(check(ni, nj) && Math.abs(land[i][j] - land[ni][nj]) <= height){
                        dq.offer(ni * 301 + nj);
                        visit_land[ni][nj] = size;
                    }
                }
            }
            
            size++;
            int[] temp = find(n);
            dq.offer(temp[0] * 301 + temp[1]);
            visit_land[temp[0]][temp[1]] = size;
        }
        
        visit = new boolean[size];
        visit_land[0][0] = 1;
        // System.out.println(Arrays.deepToString(visit_land));
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i>=0 && i<n && j+1>=0 && j+1<n && visit_land[i][j] != visit_land[i][j+1]){
                    int[] temps = new int[3];
                    temps[0] = visit_land[i][j];
                    temps[1] = visit_land[i][j+1];
                    temps[2] = Math.abs(land[i][j] - land[i][j+1]);
                    pq.offer(temps);
                }
                
                if(i+1>=0 && i+1<n && j>=0 && j<n && visit_land[i][j] != visit_land[i+1][j]){
                    int[] temps = new int[3];
                    temps[0] = visit_land[i][j];
                    temps[1] = visit_land[i+1][j];
                    temps[2] = Math.abs(land[i][j] - land[i+1][j]);
                    pq.offer(temps);
                }
            }
        }
        
        checkList = new int[size-1];
        for(int i=0; i<size-1; i++){
            checkList[i] = i;
        }
        
        while (!pq.isEmpty()) {
            int[] element = pq.poll(); // 우선순위가 가장 높은 요소를 꺼냅니다.
            // System.out.println(Arrays.toString(element)); // 요소를 출력합니다.
            if(checkList[element[0]-1] != checkList[element[1]-1]){
                modify(checkList[element[1]-1] ,checkList[element[0]-1]);
                answer+= element[2];
                // System.out.println("check : " + Arrays.toString(checkList));
            }
        }
        
        
        
        return answer;
    }
    
    public int[] find(int n){
        int[] temp = new int[2];
        for(int i=0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(visit_land[i][j] == 0){
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }
        return temp;
    }
    
    public boolean check(int i, int j){
        if(i>=0 && i<n && j>=0 && j<n && visit_land[i][j] == 0){
            return true;
        }
        return false;
    }
    
    public void modify(int before, int after){
        for(int i=0; i<size-1; i++){
            if(checkList[i] == before){
                checkList[i] = after;
            }
        }
    }
    
}