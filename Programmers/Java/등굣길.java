// puddles의 열, 행 순서 주의

import java.util.*;

class Solution {
    
    static int gn, gm;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        
        gn = n;
        gm = m;
        map[1][1] = 1;
        
        for(int i=0; i<puddles.length; i++){
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(map[i][j] != -1){
                    if(check(i-1, j) && map[i-1][j] != -1){
                    map[i][j] += map[i-1][j]% 1_000_000_007;
                    }
                
                if(check(i, j-1) && map[i][j-1] != -1){
                    map[i][j] += map[i][j-1]% 1_000_000_007;
                    }
                }
                map[i][j] = map[i][j] % 1_000_000_007;
            }
        }
        // System.out.println(Arrays.deepToString(puddles));
        // System.out.println(Arrays.deepToString(map));
        
        return map[n][m] % 1_000_000_007;
    }
    
    public boolean check(int a, int b){
        if(a > 0 && a <= gn && b > 0 && b<= gm){
            return true;
        }
        return false;
    }
}