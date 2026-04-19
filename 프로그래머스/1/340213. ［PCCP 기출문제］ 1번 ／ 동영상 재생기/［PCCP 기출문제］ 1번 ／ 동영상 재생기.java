





import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Objects;


class Solution {
   public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        answer = videoTime(video_len, pos, op_start, op_end, commands);

        return answer;
    }

    public String videoTime(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String zero = "00:00";
        DateTimeFormatter form = new DateTimeFormatterBuilder().appendPattern("mm:ss").parseDefaulting(ChronoField.HOUR_OF_DAY, 0).toFormatter();
        LocalTime time = LocalTime.parse(pos, form);
        LocalTime endTime = LocalTime.parse(video_len, form);
        LocalTime opS = LocalTime.parse(op_start, form);
        LocalTime opE = LocalTime.parse(op_end, form);
        LocalTime opening = LocalTime.parse(zero, form);

        for (int i = 0; i < commands.length; i++) {
            if (!time.isBefore(opS) && !time.isAfter(opE)) {
                time = opE;System.out.println("op " + time);
            }

            if (Objects.equals(commands[i], "prev")) {
                if (time.isBefore(opening.plusSeconds(10))) {
                    time = opening;
                } else {
                    time = time.minusSeconds(10);

                }
            } else if (Objects.equals(commands[i], "next")) {
                if (time.isAfter(endTime.minusSeconds(10))) {
                    time = endTime;
                } else {
                    time = time.plusSeconds(10);
                }
            }
        }

        if (!time.isBefore(opS) && !time.isAfter(opE)) {
            time = opE;
        }
        String videoTime = time.format(form);
        return videoTime;
    }
}

