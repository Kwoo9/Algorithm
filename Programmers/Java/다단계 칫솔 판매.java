// Map을 사용하지 않고 작성해보려했으나 타겟을 찾는 과정에서 11~13 시간초과
// 문제 접근 시 모든 합을 구한 후 세금을 내는 방식이 아니라 모든 seller의 수익을 계산할 때 세금을 계산해주어야했다.



import java.util.*;

class Solution {
    
    static Map<String,Integer> values = new HashMap<>();
    static Map<String, String> parent = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++){
            parent.put(enroll[i], referral[i]);
        }
        
        for(int i=0; i<seller.length; i++){
            calVal(seller[i], amount[i]* 100);
        }
        
        // System.out.println(values);
        
        for(int i=0; i<enroll.length; i++){
            answer[i] = values.getOrDefault(enroll[i], 0);
        }
        
        return answer;
    }
    
    public void calVal(String name, int value){
        if(value < 1){
            return;
        }
        int temp = value/10;
        if(parent.get(name).equals("-")){
            values.put(name, value-temp + values.getOrDefault(name, 0));
        }
        else{
            values.put(name, value-temp + values.getOrDefault(name, 0));
            if(temp >0){
                calVal(parent.get(name), temp);
            }
        }
    }    
}

// 아래는 시간초과가 난 코드

// import java.util.*;

// class Solution {
//     static Node[] nodeList;
    
//     public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
//         int[] answer = new int[enroll.length];
        
//         nodeList = new Node[enroll.length];
        
//         for(int i=0; i<enroll.length; i++){
//             nodeList[i] = new Node(enroll[i]);
//         }
        
//         for(int i=0; i<referral.length; i++){
//             if(!referral[i].equals("-")){
//                 for(int j=0; j<enroll.length; j++){
//                     if(nodeList[j].checkName(referral[i])){
//                         nodeList[i].parent = j;
//                         break;
//                     }
//                 }
//             }
//         }
        
//         for(int i=0; i<seller.length; i++){
//             calVal(seller[i], amount[i] * 100);
//         }
        
        
//         for(int i = 0; i<nodeList.length; i++){
//             answer[i] = nodeList[i].val;
//         }
        
//         // System.out.println(Arrays.deepToString(nodeList));
        
//         return answer;
//     }
    
//     public void calVal(String name, int value){
//         int flag = 0;
        
//         if(value < 1){
//             return;
//         }
        
//         for(int i=0; i<nodeList.length; i++){
//             if(nodeList[i].checkName(name)){
//                 flag = i;
//                 break;
//             }
//         }
        
        
//         if(nodeList[flag].parent == -1){
//             nodeList[flag].val += (value - value/10);
//         }
//         else{
//             nodeList[flag].val += (value - value/10);
//             if(value/10 > 0){
//                 calVal(nodeList[nodeList[flag].parent].name, value/10);
//             }            
//         }
        
//     }
    
//     class Node{
//         int val;
//         String name;
//         int parent;
//         Node(String name){
//             this.val = 0;
//             this.name = name;
//             this.parent = -1;
//         }
        
//         public String toString(){
//             return "val : " + this.val;
//         }
        
//         public boolean checkName(String name){
//             return this.name.equals(name) ? true : false;
//         }
//     }
// }
