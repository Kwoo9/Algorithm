// sales : 1번 직원부터 매출
// links : 
// 0 : 팀장, 1 : 팀원
// 자식 노드가 있을 경우, 팀장으로 취급
// 자식 노드를 가진 수 만큼의 팀이 존재
// 각 팀별로 어떤 노드들이 속하는지 확인 후 dfs?
// 노드의 최대 수는 300,000
// 연산을 줄일 수 있는 방법은?
// dp 활용?
// 팀장과 팀원 둘 중 하나는 무조건 포함되어야 한다.
// 팀장을 선택하지 않는 경우, 모든 팀원을 뽑지않는 조건에 팀원 매출 중 최소치를 더해주어야함
// 팀장을 선택하는 경우, 각 팀원을 뽑든 안뽑든 가장 작은 수를 더해주어야 함

import java.util.*;

class Solution {
    
    static Node[] nodeList;
    static int[][] dp;
    static int[] g_sales;
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        nodeList = new Node[sales.length + 1];
        dp = new int[sales.length+1][2];
        g_sales = sales;
        for(int i=0; i<sales.length; i++){
            nodeList[i+1] = new Node(sales[i]);
        }
        
        for(int i=0; i<links.length; i++){
            nodeList[links[i][0]].addChild(links[i][1]);
        }
        
        dfs(1);
        // System.out.println(Arrays.deepToString(dp));
        
        answer = Math.min(dp[1][0], dp[1][1]);
        
        return answer;
    }
    
    public void dfs(int num){
        int size = nodeList[num].child.size();
        // System.out.println("num : " + num + ", size : " + size);
        if(size == 0){
            dp[num][0] = 0;
            dp[num][1] = g_sales[num-1];
            return;
        }
        else{
            int min_diff = Integer.MAX_VALUE;
            int childNum = 0;
            for(int i=0; i<size; i++){
                childNum = nodeList[num].child.get(i);
                dfs(childNum);
                
                if(dp[childNum][0] < dp[childNum][1]){
                    dp[num][0] += dp[childNum][0];
                    dp[num][1] += dp[childNum][0];
                    min_diff = Math.min(min_diff, dp[childNum][1] - dp[childNum][0]);
                }
                else{
                    dp[num][0] += dp[childNum][1];
                    dp[num][1] += dp[childNum][1];
                    min_diff = 0;
                }
            }
            dp[num][0] += min_diff;
            dp[num][1] += nodeList[num].val;
            return;
        }
        
    }
    
    
    class Node{
        List<Integer> child;
        int val;
        
        Node(int val){
            this.val = val;
            this.child = new ArrayList<>();
        }
        
        public void addChild(int ch){
            this.child.add(ch);
        }
    }
}