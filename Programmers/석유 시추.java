// land.length, n : 땅의 세로길이 <= 500
// land[0].length, m : 땅의 가로길이 <= 500
// land[i][j] 0: 빈 땅, 1 : 석유

// 세로 길이 * 가로 길이 횟수 만큼 석유가 있는지 판단 필요
// 석유가 존재 시 BFS를 통해 연결된 석유를 전부 카운트 하는 기능 필요
// -> 미리 저장해놓고 해당 위치인지 판별만 한다면 단축 가능
// --> 1번 1번 닿는다 -> 1번 석유값, 1번 3번 닿는다 -> 1번 + 3번 석유값
// 각 열에서 얻을 수 있는 최대 석유의 값을 찾음
// 가장 큰 석유의 값을 반환

import java.util.*;

class Solution {
    
    static int[] di = {-1, 0, 0, 1};
    static int[] dj = {0, 1, -1, 0};
    static int n, m;
    static boolean[][] visit;
    static int[][] oil;
    static int[][] lands;
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        oil = new int[n][m];
        visit = new boolean[n][m];
        int oilId = 0;
        lands = land;
        Map<Integer, Integer> oils = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1 && !visit[i][j]){
                    int size = bfs(i, j, oilId);
                    oils.put(oilId, size);
                    oilId++;
                }
            }
        }
        int max = 0;
        int temp = 0;
        for(int j=0; j<m; j++){
            Set<Integer> oilSet = new HashSet<>();
            temp = 0;
            for(int i=0; i<n; i++){
                if(land[i][j]==1){
                    oilSet.add(oil[i][j]);
                }
            }
            for(int oId : oilSet){
                temp += oils.get(oId);
            }
            max = Math.max(max, temp);
        }
        
        return max;
    }
    
    public int bfs(int i, int j, int oilId){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{i, j});
        visit[i][j] = true;
        oil[i][j] = oilId;
        int size = 1;
        
        while(!que.isEmpty()){
            int[] temp = que.poll();
            for(int d=0; d<4; d++){
                int ni = temp[0] + di[d];
                int nj = temp[1] + dj[d];
                
                if(ni >= 0 && ni < n && nj >= 0 && nj < m && lands[ni][nj] ==1 && !visit[ni][nj]){
                    que.offer(new int[]{ni, nj});
                    visit[ni][nj] = true;
                    oil[ni][nj] = oilId;
                    size ++;
                }
            }       
        }
        return size;
    }
}