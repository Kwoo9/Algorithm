import java.util.*;

// 첫 시도 : 만들어야하는 보석의 종류를 Hash set을 통해 구하고 left부터 right까지 해당 값을 포함하면 left의 값을 늘리고 포함하지 않으면 right의 값을 늘리면서 list를 갱신
// 정확도는 맞았으나 효율성에서 실패

// 두 번째로는 left right 방식은 유지하되, list가 굳이 필요 없이 해당 범위내의 값으로 hash set을 하나 만들어 갯수를 비교하는 방식
// 효율성이 조금 올라갔다.

// 세 번째로는 check하는 과정에서 매번 HashSet을 만드는 부분에서 시간 초과가 생길것이라 예상하여 해당 메서드를 제거하고 Hash Map을 통해 해당 과정을 해결하려 하였다.

// HashMap에서 항목의 값이 0이더라도 사이즈에 체크가 된다는 점에서 실패하였다.

// 네 번째로는 HashMap 방식을 동일하게 유지하되, map 내부의 gems[left] 의 값이 1을 초과하면 삭제 후 left를 올려주는 방식으로 수정
// 해당 방식을 통해 집계가 0인 보석을 체크하는 문제가 해결되었고, left가 right보다 커서는 안되는 조건조차 모두 해결이 되었다.

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int target = new HashSet<>(Arrays.asList(gems)).size();
        
        int left = 0;
                
        int value = Integer.MAX_VALUE;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int right = 0; right < gems.length; right++){
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            
            while(map.get(gems[left]) > 1){
                map.put(gems[left], map.get(gems[left]) - 1);
                left++;
            }
            
            if(map.size() == target && value > right - left){
                value = right - left;
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
        }
                
        return answer;
    }
}