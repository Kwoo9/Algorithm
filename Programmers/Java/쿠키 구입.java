import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
        int left = 0;
        int right = 0;
        int lSum = 0;
        int rSum = 0;
        
        for(int i=0; i<cookie.length-1; i++){
            left = i;
            right = i+1;
            lSum = cookie[i];
            rSum = cookie[i+1];
            while(true){
                if(lSum==rSum && answer < lSum){
                    answer = lSum;
                }
                
                else if(lSum <= rSum && left != 0){
                    lSum += cookie[--left];
                }
                
                else if(rSum < lSum && right != cookie.length-1){
                    rSum += cookie[++right];
                }
                else{
                    break;
                }
                
            }
        }
        
        return answer;
    }
}