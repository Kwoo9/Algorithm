// // 입출력 예시를 통한 계산
// matrix_sizes = [[5,3],[3,10],[10,6]]

// dfs(0,3)
// start : 0, end : 3
// i = 1 -> flag1
// l : 0~1 , r : 1~3

// left
// start : 0, end : 1  - skip -> left = 0

// right
// start : 1, end : 3 - dep 1
// start : 1, end : 2  - skip
// start : 2, end : 3  - skip

// dep 1
// start : 1, i : 2, end : 3
// left : 0, right : 0, temp : 180 (matrix[1][0] * matrix[2][0] * matrix[2][1])
// val : 180 -> right = 180

// flag1 결과 - 270
// start : 0, i : 1, end : 3
// left : 0, right : 180, temp : 90 (matrix[0][0] * matrix[1][0] * matrix[2][1])
// val : 270

// i = 2 -> flag2
// l : 0~2 , r : 2~3
// left
// start : 0, end : 2 - dep2
// start : 0, end : 1   - skip
// start : 1, end : 2   - skip

// dep2
// start : 0, i : 1, end : 2
// left : 0, right : 0, temp : 150 (matrix[0][0] * matrix[1][0] * matrix[1][1])
// val : 150 -> left = 150

// right
// start : 2, end : 3   - skip -> right = 0

// flag2 결과 - 450
// start : 0, i : 2, end : 3
// left : 150, right : 0, temp : 300 (matrix[0][0] * matrix[2][0] * matrix[2][1])
// val : 270

// 답 : 270 < 450 => 270이 결과로 나타남


import java.util.*;

class Solution {
    
    static int dp[][];
    static int matrix[][];
    
    public int solution(int[][] matrix_sizes) {
        matrix = matrix_sizes;
        dp = new int[matrix_sizes.length + 1][matrix_sizes.length + 1];
        
        
        // System.out.println(Arrays.deepToString(dp));
            
        return dfs(0, matrix_sizes.length);
    }
    
    public int dfs(int start, int end) {
        // System.out.println("start : " + start + ", end : " + end);
        if(end-start == 1){
            return 0;
        }
        int val = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int temp = 0;
        for(int i=start+1; i<end; i++){
            if(dp[start][i] == 0){
                dp[start][i] = dfs(start, i);
            }
            
            if(dp[i][end] == 0){
                dp[i][end] = dfs(i, end);
            }
            
            left = dp[start][i];
            right = dp[i][end];
                     
            temp = matrix[start][0] * matrix[i][0] * matrix[end-1][1];
            // System.out.println("start : " + start + ", i : " + i + ", end : " + end);
            // System.out.println("left : " + left + ", right : " + right + ", temp : " + temp);
            
            val = Math.min(val, left+right+temp);         
            // System.out.println("val : "  + val);
        }
        return val;
    }
}