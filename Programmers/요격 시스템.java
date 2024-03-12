import java.util.*;

// targets : 1~500,000
// s : 미사일 시작점
// e : 미사일 끝점
// 0 <= s < e <= 100,000,000
// 모두 요격할 수 있는 요격미사일의 최소 수

// 요격 미사일의 최소 수 -> 요격 미사일 별 최대로 요격해야함
// 모든 미사일이 요격될 수 있도록, 최대한 한번에 많이 요격할 수 있도록

// 풀이 방식
// 1. 미사일 끝점을 기준으로 정렬
// 2. 현재 확인하는 타겟의 시작점을 현재 엔드값과 비교
// 3. 비교 결과에 따라 갱신
// 3-1 : 현재 타겟의 시작점이 엔드 값보다 작거나 같은 경우 다음 타겟으로 이동
// 3-2 : 현재 타겟의 시작점이 엔드 값보다 큰 경우 엔드값을 현재 타겟의 끝점으로 변경 후 필요 요격 미사일의 수를 하나 늘림.

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1,o2) -> o1[1] - o2[1]);
        int end = 0, s = 0, e = 0;
        
        for(int i=0; i<targets.length; i++){
            s = targets[i][0];
            e = targets[i][1];
            
            if(s >= end){
                end = e;
                answer++;
            }
        }
        return answer;
    }
}