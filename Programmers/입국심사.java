import java.util.*;

// 이분탐색 문제
// 이분탐색만 활용할 줄 안다면 생각보다 간단한 문제
// 나올 수 있는 모든 시간값을 범위로 두고 모든 인원이 심사 가능한 값 중 가장 작은 값을 찾는 방식
// 첫 right의 값을 저장할 때 int의 값으로 저장하여 값의 범위를 초과하였다 추측
// 이부분만 조심하면 문제 없을듯


class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long count = 0;
        long left = 0;
        long mid = 0;
        long right = times[times.length - 1] * (long) n;
        Arrays.sort(times);
        while(left <= right){
            mid = (left+right)/2;
            count = 0;
            for(int time : times){
                count += mid/time;
            }
            if(count < n){
                left = mid + 1;
            }
            else{
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}