import java.util.Arrays;
class Solution {
  public int[] solution(long n) {
    String stringN = new StringBuilder(String.valueOf(n)).reverse().toString();
        System.out.println(stringN);
        String[] splitN =  (stringN.split(""));
        int[] answer = Arrays.stream(splitN)
                .mapToInt(Integer::parseInt)
                .toArray();


        return answer;
    }
}