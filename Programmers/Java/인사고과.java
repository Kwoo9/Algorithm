import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int[] origianl = scores[0];
        int sum = scores[0][0] + scores[0][1];
        int max = 0;
        
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }            
            return o2[0] - o1[0];
        });
        
        for(int[] score : scores){
            if(max <= score[1]){
                max = score[1];
                if(score[0] + score[1] > sum){
                    answer++;
                }
            }
            else{
                if(score.equals(origianl)){
                    return -1;
                }
            }
        }
        
        return answer;
    }
}