import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int len = sequence.length;
        int[] pulse = new int[len];
        int temp = 1;
        for(int i=0; i< len; i++){
            pulse[i] = temp * sequence[i];
            temp = temp * (-1);
        }
        
        long max = 0;
        long min = 0;
        long temp1 = 0;
        for(int i=0; i<len; i++){
            temp1 += pulse[i];
            max = Math.max(max, temp1);
            min = Math.min(min, temp1);
        }
        return Math.abs(max - min);
    }
}