import java.util.Scanner;

public class BackJoonTest_11655 {

    public static void BackJoonTest_11655 () {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        char [] inputArr = input.toCharArray();
        char [] lower = new char [26];
        char [] upper = new char [26];

        for (int i = 0; i < 26; i++) {
            lower[i] = (char)('a'+i);
            upper[i] = (char)('A'+i);
        }

        for (int i = 0 ; i < inputArr.length ; i++) {

            if(inputArr[i] >= 65 && inputArr[i] <= 65+26) {

                int cursor = inputArr[i]-65;
                cursor = ((cursor+13)%26);
                inputArr[i] = upper[cursor];
            } else if (inputArr[i] >= 97 && inputArr[i] <= 97+26) {

                int cursor = inputArr[i]-97;
                cursor = ((cursor+13)%26);
                inputArr[i] = lower[cursor];
            }
        }

        for (char temp :
                inputArr) {
            System.out.print(temp);
        }
    }
}
