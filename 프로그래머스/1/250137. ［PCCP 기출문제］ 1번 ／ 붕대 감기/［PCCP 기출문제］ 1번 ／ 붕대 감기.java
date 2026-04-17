class Solution {
  public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = -1;
        answer = healing(bandage, health, attacks);
        return answer;
    }

    public int healing(int[] bandage, int health, int[][] attacks){
        int time = (attacks[attacks.length - 1][0])+1;
        int hp = health;
        int count = 0;
        int attackCount = 0;


        for (int j = 0; j < time ; j++) {
            if (attacks[attackCount][0] == j) {
                hp -= attacks[attackCount][1];
                attackCount++;
                count = 0;
            } else if (hp <= 0) {
                return -1;
            } else {
                hp += bandage[1];
                count++;
                if (count == bandage[0]) {
                    hp += bandage[2];
                    count = 0;
                }
                if(hp>health){
                    hp=health;
                }
            }
            System.out.println(attackCount);
            System.out.println(hp);
        }
        if(hp<=0){
            hp = -1;
        }
        System.out.println(attackCount);
        return hp;
    }
}
