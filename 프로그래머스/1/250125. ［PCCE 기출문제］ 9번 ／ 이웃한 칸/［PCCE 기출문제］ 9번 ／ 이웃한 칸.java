import java.util.Objects;

class Solution {
   public int solution(String[][] board, int h, int w) {
        int answer = 0;
        answer = colorCount(board, h, w);
        return answer;
    }
    public int colorCount (String[][] board, int h, int w){
        String E = "";
        String W = "";
        String S = "";
        String N = "";
        int count = 0;

        String color = board[h][w];

        if(w + 1 < board[h].length ){
            E = board[h][w + 1];
            if (Objects.equals(E, color)){
                count+=1;
            }
        }
        if(w-1 >= 0){
            W = board[h][w - 1];
            if (Objects.equals(W, color)){
                count+=1;
            }
        }
        if(h+1 < board.length ){
            S = board[h + 1][w];
            if (Objects.equals(S, color)){
                count+=1;
            }
        }
        if(h-1 >= 0 ){
            N = board[h - 1][w];
            if (Objects.equals(N, color)){
                count+=1;
            }
        }
       return count;
    }
}