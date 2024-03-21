// begin, target : 길이 3~10
// words : 3~50개
// begin -> words ~~~ -> target
// 가능하다면 변환 횟수 반환
// 불가능하다면 0 반환 -> 변환 단계를 거쳐서 변경 불가 or words 내부에 미포함
// 변환 시 현재 단어에서 알파벳 하나 변경 가능
// dfs를 통해 변환 가능 단어로 변환
// dfs를 사용해도 충분한 적은 데이터
// depth를 늘려가는 방식으로, 변환 성공 시 depth 반환

import java.util.*;

class Solution {
    
    static boolean[] visited;
    static String[] gwords;
    static int len, words_count, answer;
    
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        words_count = words.length;
        len = begin.length();
        visited = new boolean[words_count];
        gwords = words;
        
        dfs(1, begin, target);
        
        
        return answer;
    }
    
    public void dfs(int depth, String now, String target){
        if(depth >= words_count){
            return;
        }
        
        if(answer != 0){
            return;
        }
        
        for(int i=0; i<words_count; i++){
            if(canTrans(now, gwords[i]) && !visited[i]){
                if(gwords[i].equals(target)){
                    answer = depth;
                    return;
                }
                visited[i] = true;
                dfs(depth+1, gwords[i], target);
                visited[i] = false;
            }
        }
    }
    
    public boolean canTrans(String begin, String target){
        int count = 0;
        for(int i=0; i<len; i++){
            if(begin.charAt(i) != target.charAt(i)){
                count++;
                if(count > 1){
                    return false;
                }
            }
        }
        if(count == 1){
            return true;
        }
        return false;
    }
}