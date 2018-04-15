import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HackerRank3 {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String keyword = s.substring(8);
        int hour = Integer.valueOf(s.substring(0,2));
        String hourStr = "";
        if("AM".equals(keyword)) {

            hourStr = String.valueOf(hour);
            if(hour == 12) {
                hourStr = "00";
            }
            return hourStr+s.substring(2,8);
        } else {
            hour += 12;
            hourStr = String.valueOf(hour);
            if(hour == 24) {
                hourStr = "00";
            }
            return hourStr+s.substring(2,8);
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
