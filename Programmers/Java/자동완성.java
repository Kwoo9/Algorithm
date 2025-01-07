// 단어 검색의 경우 Trie구조를 많이 사용


import java.util.*;

class Solution {
    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie();
        
        for(String word : words){
            trie.insert(word);
        }
        
        for(String word : words){
            answer += trie.findAns(word);
        }
        
        return answer;
    }
    
    class Node{
        Map<Character, Node> child = new HashMap();
        int cnt;
    }
    
    class Trie{
        Node root;
        
        Trie(){
            root = new Node();
        }
        
        void insert(String word){
            Node node = this.root;
            
            for(int i=0; i<word.length(); i++){
                node.cnt++;
                node = node.child.computeIfAbsent(word.charAt(i), k -> new Node());
            }
            node.cnt++;
        }
        
        int findAns(String word){
            Node node = this.root;
            int ans = word.length();
            for(int i=0; i<word.length(); i++){
                if(node.cnt==1){
                    ans = i;
                    break;
                }
                node = node.child.get(word.charAt(i));
            }
            return ans;
        }
    }
}