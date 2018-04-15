import java.io.*;
import java.util.Scanner;

public class HackerRank5 {
    /*
     * Complete the breakingRecords function below.
     */
    static int[] breakingRecords(int[] score) {
        int highest = score[0];
        int lowest = score[0];
        int [] results = new int[2];

        for (int gameScore :
                score) {
            if(highest < gameScore) {
                highest = gameScore;
                results[0]++;
            }
            if(lowest > gameScore) {
                lowest = gameScore;
                results[1]++;
            }
        }
        return results;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.setProperty("OUTPUT_PATH", "result.txt");
        System.setProperty("INPUT_PATH", "input.txt");
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("INPUT_PATH")));
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_PATH")));

        int n = Integer.parseInt(br.readLine().trim());

        int[] score = new int[n];

        String[] scoreItems = br.readLine().split(" ");

        for (int scoreItr = 0; scoreItr < n; scoreItr++) {
            int scoreItem = Integer.parseInt(scoreItems[scoreItr].trim());
            score[scoreItr] = scoreItem;
        }

        int[] result = breakingRecords(score);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write(" ");
            }
        }

        bw.newLine();

        bw.close();
    }
}
