// 자연수 n개로 이루어진 집합 n: 1~10_000
// 각 원소의 합이 s가 되는 집합 s : 1~ 100_000_000
// 각 원소의 곱이 최대인 집합
// 곱이 최대인 값을 찾기 위해서는 평균값에 가까운 값들이 많아야 함
// ex) n=2, s=4 -> 2*2가 가장 크듯이
// 그렇다면 모든 값을 평균값을 넣은 후, 남은 값을 뒤에 넣어주면 끝날듯


import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if(n>s){
            return new int[] {-1};
        }
        int[] answer = new int[n];
        
        Arrays.fill(answer, s/n);
        
        int remain = s%n;
        
        for(int i=n-1; remain > 0; i--){
            answer[i] += 1;
            remain--;
        }
        
        return answer;
    }
}