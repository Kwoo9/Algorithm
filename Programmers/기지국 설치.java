// 기존 설치된 기지국 외 몇 개를 설치해야하는지 반환
// 각 사이마다 비어있는 공간들을 한 기지국으로 커버할 수 있는 범위를 고려해서 계산
// 그 값들을 다 합치면 답이 될 것 같은데

import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int len = stations.length;
        int[] space = new int[len+1];

        if(len == 0){
            answer = n / (w * 2 + 1);
            if(n%w > 0){
                answer++;
            }
            return answer;
        }
        else if(len == 1){
            space[0] = stations[0] - w - 1;
            space[1] = n - stations[0] - w;
        }
        else{
            space[0] = stations[0] - w - 1;
            for(int i=1; i<len; i++){
                space[i] = stations[i] - stations[i-1] - (2 * w) - 1;
            }
            space[len] = n-stations[len-1] - w;
        }
        
        for(int temp : space){
            if(temp>0){
                if((temp / (w * 2 + 1)) == 0){
                    answer++;
                    // System.out.println("1 : " + answer);
                }
                else{
                    answer += (temp / (w * 2 + 1));
                    // System.out.println("2 : " + answer);
                    if(temp % (w * 2 + 1) > 0){
                        answer++;
                        // System.out.println("3 : " + answer);
                    }
                }
            }
        }
        
        // System.out.println(Arrays.toString(space));

        return answer;
    }
}