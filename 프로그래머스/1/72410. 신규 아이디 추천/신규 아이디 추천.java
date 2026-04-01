class Solution {
       public static String solution(String new_id) {
        String answer = "";
        String first = Lowercase(new_id);
        String second = Punct(first);
        String third = period(second);
        String Fourth = lenght(third);
        String Fifth = shortage(Fourth);
        answer = Fifth;
        return answer;
    }

    public static String Lowercase(String new_id) {
        String first = new_id.toLowerCase();
      
        return first;

    }

    public static String Punct(String first) {
        String second = first.replaceAll("[^a-zA-Z0-9_\\-.]", "");
        second = second.replaceAll("\\.+", ".");
      
        return second;
    }

    public static String period (String second) {
        String target = ".";
        String third = second;
        if(third.startsWith(target)) {
            third = third.substring(target.length());
        } 
        if(third.endsWith(target)){
            third = third.substring(0, third.length() - 1);
        }
      
        return third;
    }

    public static String lenght (String third) {
        String Fourth = third;
        String target = ".";

        if(third.isEmpty()){
            Fourth = "a";
        } else if (third.length() >15) {
            Fourth = third.substring(0, 15);
            if (Fourth.endsWith(target)){
                Fourth = Fourth.substring(0, Fourth.length() - 1);
            }
        }
      
        return Fourth;
    }

    public static String shortage (String Fourth) {
        StringBuilder Fifth = new StringBuilder(Fourth);

        while (Fifth.length() < 3) {
            String last = Fourth.substring(Fourth.length() -1);
            Fifth.append(last);
        }
       
        return Fifth.toString();

    }
}