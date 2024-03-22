// operation 1~1_000_000
// I 숫자 : 숫자 삽입
// D 1 : 최댓값 삭제
// D -1 최솟값 삭제
// 최소, 최대 값이 둘 이상 시 하나만 삭제
// 빈 큐에 삭제 연산 주어질 시 무시
// 비어있는 경우 [0,0] 반환
// 값이 존재하는 경우 [최댓값, 최솟값] 반화
// 우선순위 큐를 사용
// 2가지 사용 : 최댓 값 제거용, 최솟 값 제거용
// 용도에 맞게 poll 후, 해당 값을 나머지 큐에서 remove하는 방식



import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[] {0, 0};
        
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        
        System.out.println(Integer.parseInt(operations[0].substring(2)));
        
        int temp = 0;
        for(String op : operations){
            if(op.substring(0,1).equals("I")){
                temp = Integer.parseInt(op.substring(2));
                minpq.offer(temp);
                maxpq.offer(temp);
            }else{
                if(!minpq.isEmpty()){
                    if(op.substring(2).equals("1")){
                        temp = maxpq.poll();
                        minpq.remove(temp);
                    }
                    else{
                        temp = minpq.poll();
                        maxpq.remove(temp);
                    }
                }
            }
        }
        
        if(!minpq.isEmpty()){
            answer[0] = maxpq.poll();
            answer[1] = minpq.poll();
        }
        
        return answer;
    }
}