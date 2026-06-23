import java.util.Arrays;
class Solution {
     public String solution(String s) {
       String[] spilt_S = s.split(" ");

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < spilt_S.length ; i++) {
            for (int j = 0; j <spilt_S[i].length() ; j++) {
                if (j % 2 == 0) {
                    answer.append(Character.toUpperCase(spilt_S[i].charAt(j)));
                }
                if (j % 2 != 0) {
                    answer.append(Character.toLowerCase(spilt_S[i].charAt(j)));
                }
            }
            if(i<spilt_S.length-1){
            answer.append(" ");
            }
        }
        answer.append(" ".repeat(Math.max(0, s.length() - answer.length())));
        return answer.toString();
    }
}