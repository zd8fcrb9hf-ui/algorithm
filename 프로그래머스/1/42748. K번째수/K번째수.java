import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            answer[i] = number(array,commands[i]);
        }
        return answer;
    }

    public int number(int[] array, int[] commands){
        int[] split = Arrays.copyOfRange(array,commands[0]-1, commands[1]);

        Arrays.sort(split);
        int number = split[commands[2]-1];

        return number;
    }
}
