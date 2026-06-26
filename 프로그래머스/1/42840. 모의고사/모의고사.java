
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] answers) {
       ArrayList<Integer> answer = new ArrayList<>();
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] correct = {correct(first, answers),
                correct(second, answers),
                correct(third, answers)};
        int max = Arrays.stream(correct).max().getAsInt();


        for (int i = 0; i < correct.length; i++) {
            if (correct[i] == max){
                answer.add(i+1);
            }
        }
        int[] answer2 = answer.stream().mapToInt(Integer::intValue).toArray();

        return answer2;
    }
    public int correct(int[] people, int[] answers) {
        int peopleIndex = 0;
        int correct = 0;
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == people[peopleIndex]){
                correct++;

            }
            peopleIndex++;

            if(peopleIndex == people.length){
                peopleIndex = 0;
            }
        }
        return correct;
    }
}
