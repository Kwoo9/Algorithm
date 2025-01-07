// 참고 : https://school.programmers.co.kr/questions/43693
// 문제를 푸는 아이디어가 중요했던 문제
// 한 숫자를 기준으로 양쪽이 본인보다 작으면 지울 수 없다.
// 양 끝쪽은 비교할 숫자가 하나뿐이다.
// 양 끝쪽에서 하나의 값씩 비교해서 최소값 갱신 & 답 추가 하는 방식

import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        if(a.length == 1){
            return 1;
        }
        answer = 2;
        int l = a[0];
        int r = a[a.length-1];
        
        for(int i=1; i<a.length-1; i++){
            if(a[i] < l){
                l = a[i];
                answer++;
            }
            
            if(a[a.length-1-i] < r){
                r = a[a.length-1-i];
                answer++;
            }
            
            if(l==r){
                answer--;
                break;
            }
        }
        
        return answer;
    }
}