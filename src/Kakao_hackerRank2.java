import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Kakao_hackerRank2 {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String args[]) throws Exception {
        String filename;
        filename = scan.nextLine();
        System.setProperty("INPUT_PATH", filename);
        System.setProperty("OUTPUT_PATH", "bytes_"+filename);
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("INPUT_PATH")));
        String line ="";

        int resultCnt = 0;
        long resultSize = 0;
        while((line = br.readLine()) != null){
            String [] splited = line.split(" ");
            int size = Integer.valueOf(splited[splited.length-1]);
            if(size > 5000) {
                resultSize += size;
                resultCnt++;
            }
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));
        bw.write(String.valueOf(resultCnt));
        bw.newLine();
        bw.write(String.valueOf(resultSize));
        bw.close();
        scan.close();
    }
}
