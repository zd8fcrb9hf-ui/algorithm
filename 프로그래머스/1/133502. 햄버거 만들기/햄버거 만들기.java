import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        List<Integer> stack = new ArrayList<>();

        for (int item : ingredient) {
            stack.add(item); // 재료를 하나씩 쌓음

            // 재료가 4개 이상 쌓였을 때만 검사
            if (stack.size() >= 4) {
                int size = stack.size();
                // 마지막 4개의 조합이 1-2-3-1인지 확인
                if (stack.get(size - 4) == 1 &&
                    stack.get(size - 3) == 2 &&
                    stack.get(size - 2) == 3 &&
                    stack.get(size - 1) == 1) {
                    
                    answer++;
                    // 햄버거 완성! 뒤에서부터 4개 제거
                    for (int i = 0; i < 4; i++) {
                        stack.remove(stack.size() - 1);
                    }
                }
            }
        }
        return answer;
    }
}