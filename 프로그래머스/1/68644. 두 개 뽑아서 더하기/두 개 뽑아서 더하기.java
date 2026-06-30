

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] numbers) {
      int[] answer = {};
        List<Integer> plus = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if(i!=j){
                    plus.add(numbers[i] + numbers[j]);
                }else {
                    continue;
                }
            }
        }
        answer = plus.stream().distinct().mapToInt(i -> i).toArray();
        Arrays.sort(answer);
        return answer;
    }
}