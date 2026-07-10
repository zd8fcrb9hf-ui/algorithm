class Solution {
  public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        char S;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' ){
                answer.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) + n > 122 && Character.isLowerCase(s.charAt(i)) ||
                    s.charAt(i) + n > 90 && Character.isUpperCase(s.charAt(i)) ) {
                S = (char) (s.charAt(i) + n - 26);
                answer.append(S);
                System.out.println("A");
            }else{
                S = (char) (s.charAt(i) + n);
                answer.append(S);
                System.out.println("B");
            }
        }

        return answer.toString();
    }
}
