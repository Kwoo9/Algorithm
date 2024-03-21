// n : 노드의 수 2~20_000
// edge : 간선, 1~50_000
// 1번에서 가장 먼 노드의 수 구하기
// 1번에서부터 이동할 수 있는 모든 노드 찾기
// 간선 가중치 부재로 인해 늦게 나타날수록 먼 것은 확정
// 다익스트라 or dp로 가능할거같은데


import java.util.*;

class Solution {
     
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<Integer>[] map = new List[n+1];
        for(int i=1; i<=n; i++){
            map[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[n+1];
        
        for(int i=0; i<edge.length; i++){
            map[edge[i][0]].add(edge[i][1]);
            map[edge[i][1]].add(edge[i][0]);
        }
        
        // System.out.println(Arrays.deepToString(map));
        
        visit[1] = true;
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        int size = map[1].size();
        
        for(int i=0; i<size; i++){
            dq.offer(map[1].get(i));
            visit[map[1].get(i)] = true;
        }
        
        // System.out.println(Arrays.toString(visit));
        // System.out.println(dq.toString());
        
        int temp = 0;
        while(!dq.isEmpty()){
            answer = dq.size();
            // System.out.println(answer);
            for(int i=0; i < answer; i++){
                temp = dq.poll();
                size = map[temp].size();
                // System.out.println(size);
                for(int j=0; j<size; j++){
                    if(!visit[map[temp].get(j)]){
                        dq.offer(map[temp].get(j));
                        visit[map[temp].get(j)] = true;
                    }
                }
            }
        }

        return answer;
    }
}