import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kakao_four {

    public String solution (int n, int t, int m, String[] timetable) {

        String answer = "";
        String firstBusTime = "09:00";
        String lastBusTime = plusAndMinus(true, firstBusTime, (n-1)*t);
        int index = 0;
        boolean isfull = true;

        List<String> timeList = new ArrayList<String>();
        for (String temp: timetable) {

            timeList.add(temp);
        }

        Collections.sort(timeList);
        int lastCrewIndex = 0;
        for (int i = 0; i < timeList.size(); i++) {
            String busTime = plusAndMinus(true, firstBusTime, index*t);

            if((index+1)*m == i+1) {

                index++;
            }

            if(isFaster(busTime, timeList.get(i))) {
                index++;
            }

            if(index == n) {

                lastCrewIndex = i;
                isfull = true;
                break;
            }

            if(n*m > timeList.size()) {

                isfull = false;
            }
        }

        if(isfull) {
        /*lastCrewIndex보다는 앞에 서야함!*/
            for (int i = lastCrewIndex - 1; i > 0; i--) {

                String answerTime = timeList.get(i);
                if (answerTime.equals(timeList.get(i+1))) {
                    continue;

                } else {

                    return answerTime;
                }

            }
        } else {

            for (int i = timeList.size()-1; i > 0; i--) {

                String answerTime = timeList.get(i);
                if(isFaster(answerTime, lastBusTime)) {

                    return lastBusTime;
                } else {
                    return answerTime;
                }
            }
        }

        return answer;
    }
    public boolean isFaster (String time1, String time2) {

        int hour1 = Integer.valueOf(time1.substring(0,2));
        int minute1 = Integer.valueOf(time1.substring(3,5));
        int hour2 = Integer.valueOf(time2.substring(0,2));
        int minute2 = Integer.valueOf(time2.substring(3,5));

        if(hour1 == hour2) {

            if(minute1 < minute2) {
                return true;
            } else {
                return false;
            }
        } else if (hour1 > hour2) {

            return false;
        } else {

            return true;
        }
    }
    public String plusAndMinus (boolean isAdd, String time, int value) {

        String hour = time.substring(0,2);
        String minute = time.substring(3,5);

        if(isAdd) {

            int tempHour = Integer.valueOf(hour);
            int tempMinute = Integer.valueOf(minute) + value;

            while(tempMinute > 59) {

                tempMinute -= 60;
                hour = String.format("%02d", tempHour+1);

            }

            minute = String.format("%02d", tempMinute);

        } else {

            int tempHour = Integer.valueOf(hour);
            int tempMinute = Integer.valueOf(minute) - value;

            while(tempMinute < 0) {

                tempMinute += 60;
                hour = String.format("%02d", tempHour-1);
            }

            minute = String.format("%02d", tempMinute);
        }

        return hour+":"+minute;
    }
}

