

import java.util.Arrays;
import java.util.Collections;
class Solution {
    public String solution(String s) {
      String[] newS = s.split("");
        Arrays.sort(newS, Collections.reverseOrder());
        String result = String.join("", newS);
        return result;
    }
}