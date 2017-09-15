import java.util.Scanner;

public class BackJoonTest_10844 {

    public void backJoonTest_10844 () {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();

        int [] d = new int [input+1];
        d[1] = 9;

        if(input == 2) {

            d[2] = 17;
        }
        else if(input > 2) {
            d[2] = 17;
            for (int i = 3; i < input+1; i++) {

                d[i] = 0;
                for (int j = 1; j < i; j++) {
                    d[i] += d[j];
                }
                d[i] += i+1;
            }
        }

        System.out.println(d[input]);

    }
}
