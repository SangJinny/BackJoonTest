import java.util.Scanner;

public class BackJoonTest_1924 {

    public static void BackJoonTest_1924 () {

        Scanner scan = new Scanner(System.in);
        int [] monthValues = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int inputMonth = scan.nextInt();
        int inputDay = scan.nextInt();

        int monthToDay = 0;
        for (int i = 0; i < inputMonth-1; i++) {
            monthToDay += monthValues[i];
        }

        int numOfDays = monthToDay + inputDay -1; // 시작이 1월 "1일" 이니까.
        String result = "";
        switch(numOfDays%7) {
            case 0:
                result = "MON";
                break;
            case 1:
                result = "TUE";
                break;
            case 2:
                result = "WED";
                break;
            case 3:
                result = "THU";
                break;
            case 4:
                result = "FRI";
                break;
            case 5:
                result = "SAT";
                break;
            case 6:
                result = "SUN";
                break;

        }


        System.out.println(result);
    }
}
