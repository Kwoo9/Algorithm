// user_id : 1~8개, 1~8길이 유저아이디
// banned_id : 1~user_id개, 1~8길이 제재 아이디
// 제재 아이디하나에 유저아이디 하나씩
// 유저아이디가 여러개 들어가는 경우는 없음
// 제재아이디 길이와 일치하는 목록들과 비교
// 제재아이디당 가능한 유저아이디 목록을 미리 만들기
// 목록을 만든 후, dfs하며 hashset으로 중복 제거
// hashset size 반환


import java.util.*;

class Solution {
    static boolean[] visit;
    static List<Integer>[] list;
    static HashSet<String> set;
    public int solution(String[] user_id, String[] banned_id) {
        set = new HashSet<String>();
        visit = new boolean[user_id.length];
        list = new List[banned_id.length];
        String temp = "";
            
        for(int i=0; i<banned_id.length; i++){
            list[i] = new ArrayList<Integer>();
            temp = banned_id[i];
            for(int j=0; j<user_id.length; j++){
                if(check(user_id[j], temp) && possible(user_id[j], temp)){
                    list[i].add(j);
                }
            }
        }
        dfs(0, banned_id.length, "");
        // System.out.println(Arrays.deepToString(list));
        
        return set.size();
    }
    
    public void dfs(int depth, int max, String target){
        if(depth == max){
            String[] targets = target.split("");
            Arrays.sort(targets);
            String test = "";
            for(String a : targets){
                test += a;
            }
            // System.out.println(test);
            set.add(test);
            return;
        }
        
        for(int i=0; i<list[depth].size(); i++){
            if(!visit[list[depth].get(i)]){
                visit[list[depth].get(i)] = true;
                String next = target + list[depth].get(i);
                dfs(depth+1, max, next);
                visit[list[depth].get(i)] = false;
            }
        }
    }
    
    
    public boolean check(String userId, String banId){
        if(userId.length() == banId.length()) return true;   
        return false;
    }
    
    public boolean possible(String userId, String banId){
        int len = userId.length();
        int count = 0;
        for(int i=0; i<len; i++){
            if(banId.charAt(i) == '*'){
                count++;
            }else{
                if(banId.charAt(i) == userId.charAt(i)){
                    count++;
                }
            }
        }
        if(count == len){
            return true;
        }
        
        return false;
    }
}