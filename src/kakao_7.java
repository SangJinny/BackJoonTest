import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class kakao_7 {

    class KakaoLog {

        private LocalDateTime startDateTime;
        private LocalDateTime endDateTime;


        public LocalDateTime getStartDateTime() {
            return startDateTime;
        }

        public LocalDateTime getEndDateTime() {
            return endDateTime;
        }

        public void setStartDateTime(LocalDateTime startDateTime) {
            this.startDateTime = startDateTime;
        }

        public void setEndDateTime(LocalDateTime endDateTime) {
            this.endDateTime = endDateTime;
        }
    }

    public int solution(String[] lines) {

        int answer = 0;

        for (int i = 0; i < lines.length; i++) {

            String dateTime = lines[i].substring(0,23);
            String period = lines[i].substring(24,27);

            System.out.println(dateTime);
            System.out.println(period);
            KakaoLog log = new KakaoLog();
            log.setEndDateTime(LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.sss")));
            //LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.sss")).minusNanos()
        }
        return answer;
    }
}


