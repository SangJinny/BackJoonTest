import java.util.Scanner;

public class BackJoonTest_11052 {

    public void backJoonTest_11052 () {

        Scanner scan = new Scanner(System.in);
        int totalNum = scan.nextInt();

        int [] price = new int [totalNum+1];
        int [] benefit = new int [totalNum+1];
        for (int i = 1; i <= totalNum; i++) {

            price[i] = scan.nextInt();
            benefit[i] = price[i];
        }

        for (int i = 2; i <= totalNum; i++) {

            for (int j = 1; j < i; j++) {

                if(benefit[i] < price[j]+benefit[i-j]) {

                    benefit[i] = price[j]+benefit[i-j];
                }
            }
        }

        System.out.println(benefit[totalNum]);
    }
}
