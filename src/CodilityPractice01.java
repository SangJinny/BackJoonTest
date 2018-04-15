import java.util.Scanner;

public class CodilityPractice01 {

    public static void CodilityPractice01 () {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        StringBuilder binaryNum = new StringBuilder("");

        while(n/2 != 0) {

            binaryNum.append(n%2);
            n = n/2;
        }
        binaryNum.append(n);
        System.out.println(binaryNum.reverse().toString());

        int size = binaryNum.length();
        boolean isStarted = false;
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < size; i++) {

            if (isStarted && "1".equals(binaryNum.substring(i,i+1))) {

                isStarted = false;
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 0;
            }

            if("1".equals(binaryNum.substring(i,i+1)) && !isStarted) {

                isStarted = true;
                currentLength = 0;
            } else if (isStarted && "0".equals(binaryNum.substring(i,i+1))) {

                currentLength++;
            }
        }

        System.out.println(maxLength);
    }
}
