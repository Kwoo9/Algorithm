import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        
        int count = 0;
        
        for(int i =0; i<A.length; i++){
            a.offer(A[i]);
            b.offer(B[i]);
        }
        
        boolean aFlag = true;
        boolean bFlag = true;
        int aTemp = 0;
        int bTemp = 0;
        while(!a.isEmpty() && !b.isEmpty()){
            if(aFlag){
                aFlag = false;
                aTemp = a.poll();
            }
            
            if(bFlag){
                bFlag = false;
                bTemp = b.poll();
            }
            
            if(aTemp < bTemp){
                aFlag = true;
                bFlag = true;
                count++;
            }
            else{
                aFlag = true;
            }
            
            // System.out.println(count);
        }
        
        
        return count;
    }
}