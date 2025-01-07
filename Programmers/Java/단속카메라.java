import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
                
        // System.out.println(Arrays.deepToString(routes));
        
        int target = 0;
        int temp = 0;
        while(target < routes.length){
            temp = routes[target][1];
            
            for(int i=target; i<routes.length; i++){
                if(temp >= routes[i][0]){
                    target++;
                }
                else{
                    answer++;
                    break;
                }
            }
        }
        
        
        return answer + 1;
    }
}