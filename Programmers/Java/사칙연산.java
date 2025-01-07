import java.util.*;

class Solution {
    public int solution(String arr[]) {
        
        int[] nums = new int[arr.length/2 + 1];
        nums[0] = Integer.parseInt(arr[0]);
        for(int i=1; i<arr.length/2+1; i++){
            int target = i*2;
            
            nums[i] = arr[target-1].equals("+") ? Integer.parseInt(arr[target]) : Integer.parseInt(arr[target]) * -1;
            
        }
        
        // System.out.println(Arrays.toString(nums));
        if(nums.length == 2){
            return nums[0] + nums[1];
        }
        int sum = 0;
        
        int min = nums[nums.length-1];
        int max = nums[nums.length-1];
        int tmx = 0;
        int tmn = 0;
        // System.out.println("max : " + max + ", min : " + min);
        for(int i=nums.length-2; i>=0; i--){
            int target = nums[i];
            
            if(target<0){
                
                tmx = Math.max(target + sum + max, target - sum - min);
                tmn = Math.min(target - sum + min, target - sum - max);
                sum = 0;
                max = tmx;
                min = tmn;
                // System.out.println("max : " + max + ", min : " + min);
            }
            else{
                sum += target;
            }
        }
        max += sum;
        
        // System.out.println("max : " + max + ", min : " + min);
        
        
        return max;
    }
}