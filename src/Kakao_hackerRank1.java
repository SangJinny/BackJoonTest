import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kakao_hackerRank1 {
    static String decode(String encoded) {
        StringBuffer inputStr = new StringBuffer(encoded);
        StringBuffer resultStr = new StringBuffer("");
        inputStr.reverse();
        int cnt = 0;
        while(cnt < inputStr.length()) {
            int digits = Integer.valueOf(inputStr.substring(cnt,cnt+2));

            if(digits < 32) {
                digits = Integer.valueOf(inputStr.substring(cnt,cnt+3));
                cnt+=3;
            } else {
                cnt += 2;
            }
            char convert = (char)digits;
            resultStr.append(convert);
        }
        return resultStr.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.setProperty("OUTPUT_PATH", "result.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        String encoded = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        String res = decode(encoded);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

