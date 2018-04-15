import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HackerRank2 {
    //Between Two Sets.
    static int getTotalX(int[] a, int[] b) {

        // b 배열의 GCD를 구한다.
        int gcd = b[0];
        for(int i = 0 ; i < b.length-1; i++) {
            gcd = gcd(gcd, b[i+1]);
        }

        // a 배열의 LCM을 구한다.
        int lcm = a[0];
        for(int i = 0 ; i < a.length-1; i++) {
            lcm = lcm(lcm, a[i+1]);
            if(lcm > gcd) return 0;
        }

        int answer = 0;
        int x; int y;
        x = lcm;
        y = gcd;

        while(x != 0 && x <= y) {
            if(y%x == 0 && lcm%x == 0)  answer++;
            x++;
        }
        return answer;
    }

    private static int gcd(int a, int b) {
        while(b!=0) {
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scan.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[] a = new int[n];

        String[] aItems = scan.nextLine().split(" ");

        for (int aItr = 0; aItr < n; aItr++) {
            int aItem = Integer.parseInt(aItems[aItr].trim());
            a[aItr] = aItem;
        }

        int[] b = new int[m];

        String[] bItems = scan.nextLine().split(" ");

        for (int bItr = 0; bItr < m; bItr++) {
            int bItem = Integer.parseInt(bItems[bItr].trim());
            b[bItr] = bItem;
        }

        int total = getTotalX(a, b);

        bw.write(String.valueOf(total));
        bw.newLine();

        bw.close();
    }
}
