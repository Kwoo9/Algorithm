import java.util.*;

// n : edges.length 1 ~ 1_000_000
// a, b : a에서 b의 간선 1 ~ 1_000_000
// result : 모든 그래프 수의 합은 2이상, 생성한 정점의 번호, 생성 전 도넛, 생성 전 막대, 생성 전 8자.

// 생성된 정점 : 정점에서 나가는 간선이 2개 이상 들어오는 간선 없음
// 막대 : 마지막 정점에서 나가는 간선 없음
// 도넛 : 모든 정점에 나가는 간선과 들어오는 간선이 하나씩
// 8자 : 도넛 + 들어오고 나가는 간선이 2개씩 있는 한 정점

// 전체 그래프 수 : 생성된 정점에서 나가는 간선의 수
// 막대 그래프 수 : 나가는 간선이 없는 정점의 수
// 8자 그래프 수 : 들어오고 나가는 간선이 2개씩 있는 정점의 수
// 도넛 그래프 수 : 전체 그래프 수 - 막대 - 8자


class Solution {
    public int[] solution(int[][] edges) {
        
        int n = edges.length;
        int maxV = 0;
        for(int i=0; i<n; i++){
            maxV = Math.max(maxV, Math.max(edges[i][0], edges[i][1]));
        }
        int[] in = new int[maxV+1];
        int[] out = new int[maxV+1];
        
        for(int i=0; i<n; i++){
            in[edges[i][1]]++;
            out[edges[i][0]]++;
        }
        int target = 0;
        for(int i=1; i<=maxV; i++){
            if(out[i] > 1 && in[i] == 0){
                target = i;
                break;
            }
        }
        
        int max = out[target];
        in[target] = 0;
        out[target] = 0;
        int count_a = 0;
        int count_b = 0;
        for(int i=1; i<=maxV; i++){
            // 막대 수
            if(in[i] >= 1 && out[i] == 0){
                count_a++;
            }
            // 8자 수
            if(in[i] >= 2 && out[i] == 2){
                count_b++;
            }
        }
        int[] answer = {target, max - count_a - count_b, count_a, count_b};
        return answer;
    }
}