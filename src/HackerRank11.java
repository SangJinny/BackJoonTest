import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HackerRank11 {
    /*
     * Complete the absolutePermutation function below.
     */
    static int[] absolutePermutation(int n, int k) {

        int [] p = new int [n+1];
        boolean [] isUsed = new boolean[n+1];

        for(int i = 1 ; i <= n; i++) {
            if (i-k > 0 && !isUsed[i-k]) {
                p[i] = i-k;
                isUsed[i-k] = true;
            } else if(i+k <= n && !isUsed[i+k]) {
                p[i] = i+k;
                isUsed[i+k] = true;
            } else {
                return new int [0];
            }
        }
        return p;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int t = scanner.nextInt();
        for(int i = 0 ; i < t; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int [] result = absolutePermutation(n,k);
            for(int j = 1 ; j < result.length; j++) {
                System.out.print(result[j]+" ");
            }
            if(result.length == 0) {
                System.out.print(-1);
            }
            System.out.println("");
        }
    }
}
