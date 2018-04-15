import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Kakao_hackerRank4 {
    static int programmerStrings(String s) {
        int startIdx = 0;
        int endIdx = 10;
        int resultCnt = 0;
        int correctCnt = 0;
        //System.out.println(s.length());
        while(endIdx <= s.length()) {
            resultCnt = checkProgrammerStrings(s, startIdx, endIdx);


            if(correctCnt == 0 && resultCnt == 10) {
                //System.out.println("first correct "+startIdx+"/"+endIdx);
                startIdx += endIdx+2;
                endIdx = startIdx+10;
                correctCnt++;
            } else if (correctCnt == 0 && resultCnt < 10) {
                //System.out.println("first incorrect "+startIdx+"/"+endIdx);
                endIdx += (10 - resultCnt);
            } else if (correctCnt != 0 && resultCnt == 10) {
                //System.out.println("correct "+startIdx+"/"+endIdx);
                startIdx++;
                correctCnt++;
            } else if (correctCnt != 0 && resultCnt < 10) {
                //System.out.println("incorrect "+startIdx+"/"+endIdx);
                endIdx += (10 - resultCnt);
            } else {
                //System.out.println("resultCnt:"+resultCnt);
            }
        }
        if(correctCnt == 1) {
            correctCnt = 0;
        }
        return correctCnt;
    }

    static int checkProgrammerStrings(String s, int startIdx, int endIdx) {
        int resultCnt = 0;
        boolean [] trace = new boolean[10];

        for(int i = startIdx; i < endIdx; i++) {
            if(!trace[0] && "p".equals(s.substring(i,i+1))) {
                trace[0] = true;
                resultCnt++;
            } else if(!trace[1] && "r".equals(s.substring(i,i+1))) {
                trace[1] = true;
                resultCnt++;
            } else if(!trace[2] && "o".equals(s.substring(i,i+1))) {
                trace[2] = true;
                resultCnt++;
            } else if(!trace[3] && "g".equals(s.substring(i,i+1))) {
                trace[3] = true;
                resultCnt++;
            } else if(!trace[4] && "r".equals(s.substring(i,i+1))) {
                trace[4] = true;
                resultCnt++;
            } else if(!trace[5] && "a".equals(s.substring(i,i+1))) {
                trace[5] = true;
                resultCnt++;
            } else if(!trace[6] && "m".equals(s.substring(i,i+1))) {
                trace[6] = true;
                resultCnt++;
            } else if(!trace[7] && "m".equals(s.substring(i,i+1))) {
                trace[7] = true;
                resultCnt++;
            } else if(!trace[8] && "e".equals(s.substring(i,i+1))) {
                trace[8] = true;
                resultCnt++;
            } else if(!trace[9] && "r".equals(s.substring(i,i+1))) {
                trace[9] = true;
                resultCnt++;
            }
        }
        return resultCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.setProperty("OUTPUT_PATH", "result3.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int res = programmerStrings(s);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
