import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kakao_hackerRank5 {
    static long findSimilar(long a, long b) {
        // find similar numbers with b
        String numStr = String.valueOf(b);
        long [] cntArr = new long[10];
        for(int i = 0 ; i < numStr.length(); i++) {
            int temp = Integer.valueOf(numStr.substring(i, i+1));
            cntArr[temp]++;
        }
        long divideNum = 1;
        for(long temp : cntArr) {
            if(temp != 0) {
                divideNum = divideNum * factorial(temp);
                System.out.println(temp);
            }
        }

        long result = factorial(numStr.length()) / divideNum;
        return result;
    }

    static long factorial(long n) {
        if(n <= 1) {
            return n;
        } else {
            return factorial(n-1)*n;
        }
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.setProperty("OUTPUT_PATH", "result5.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        long a = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        long b = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        long res = findSimilar(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
