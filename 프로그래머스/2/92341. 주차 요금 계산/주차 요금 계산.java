import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        ArrayList<String> numberSub = numberSubstring(records);
        ArrayList<String> newNumber = newNumber(numberSub);
        ArrayList<LocalTime> timeSub = timeSubstring(records);
        ArrayList<String> InOutSub = InOutSubstring(records);
        Map<String, Integer> numberSize = numberSizing(numberSub);
        Map<String, Integer> timing = timing(numberSub, numberSize, timeSub, InOutSub, newNumber);
        answer = resulting(timing, fees, newNumber);

        return answer;
    }

    public ArrayList<String> numberSubstring(String[] records){
        ArrayList<String> number = new ArrayList<>();;

        for (int i = 0; i < records.length; i++) {
            number.add(records[i].substring(6,10));
        }

        return number;
    }

    public ArrayList<LocalTime> timeSubstring(String[] records){
        DateTimeFormatter form = new DateTimeFormatterBuilder().appendPattern("HH:mm").toFormatter();
        ArrayList<LocalTime> time = new ArrayList<>();

        for (int i = 0; i < records.length; i++) {
            time.add(LocalTime.parse(records[i].substring(0,5), form));
        }

        return time;
    }

    public ArrayList<String> InOutSubstring(String[] records){
        ArrayList<String> InOut = new ArrayList<>();;

        for (int i = 0; i < records.length; i++) {
            InOut.add(records[i].substring(11,12));
        }

        return InOut;
    }

    public Map<String, Integer> numberSizing(ArrayList<String> newNumber){
        Map<String, Integer> TimeMap = new HashMap<String, Integer>();


        for (int i = 0; i < newNumber.size(); i++) {
            TimeMap.put(newNumber.get(i), 0);
        }

        return TimeMap;
    }

    public Map<String, Integer> timing (ArrayList<String> number, Map<String, Integer> allTime, ArrayList<LocalTime> time, ArrayList<String> InOutSubstring, ArrayList<String> newNumber){
        Map<String, LocalTime> timeDomy = new HashMap<String, LocalTime>();
        Integer alltime2 = 0;
        for (int i = 0; i < number.size(); i++) {
            if(Objects.equals(InOutSubstring.get(i), "I")){

                timeDomy.put(number.get(i),time.get(i));

            } else {
                alltime2 = allTime.get(number.get(i)) + Math.abs((timeDomy.get(number.get(i)).getHour() * 60 + timeDomy.get(number.get(i)).getMinute()) - (time.get(i).getHour() * 60 + time.get(i).getMinute()) );

                allTime.put(number.get(i),alltime2);
                timeDomy.put(number.get(i), LocalTime.parse("23:59"));
                alltime2 = 0;
            }

        }

        for (int i = 0; i < timeDomy.size(); i++) {
            alltime2 = allTime.get(newNumber.get(i)) + Math.abs((timeDomy.get(newNumber.get(i)).getHour() * 60 + timeDomy.get(newNumber.get(i)).getMinute()) - 1439);
            allTime.put(newNumber.get(i), alltime2);
        }

        Map<String, Integer> allTimeMap = new TreeMap<>(allTime);
        return allTimeMap;
    }

    public ArrayList<String> newNumber(ArrayList<String> number){
        ArrayList<String> newNumber = new ArrayList<>(new LinkedHashSet<>(number));
        Collections.sort(newNumber);

        return newNumber;
    }
    public int[] resulting (Map<String, Integer> alltime, int[] fees, ArrayList<String> newNumber) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < alltime.size(); i++) {
            if(alltime.get(newNumber.get(i)) > fees[0]) {
                Integer overTime = (int) Math.ceil(((double) (alltime.get(newNumber.get(i))-fees[0] )/fees[2]));
                result.add(fees[1] + overTime * fees[3]);
            }else if(alltime.get(newNumber.get(i)) <= fees[0]){
                result.add(fees[1]);
            }
        }

        int[] Result = result.stream().mapToInt(Integer::intValue).toArray();

        return Result;
    }


}
