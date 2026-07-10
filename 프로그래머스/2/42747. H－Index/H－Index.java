
import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public int solution(int[] citations) {
        int[] sorted = Arrays.stream(citations)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
       
        if (sorted[sorted.length - 1] > sorted.length) {
            return sorted.length;
        }
        for (int i = 0; i < sorted.length; i++) {
            int finalI1 = i;
                if (Arrays.stream(sorted).filter(num -> num >= sorted[finalI1]).count() >= sorted[i] &&
                        Arrays.stream(sorted).filter(num -> num < sorted[finalI1]).count() <= sorted[i]) {
                    return Math.max(i, sorted[i]);
                }
            }
           return 0;
        }

    }