import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BackJoonTest_10820 {

    public static void BackJoonTest_10820() {

        Scanner scan = new Scanner(System.in);

        List<String> input = new ArrayList<>();
        while(scan.hasNextLine()) {
            String tempStr = scan.nextLine();
            input.add(tempStr);
        }

        for(String inputStr : input) {


            int lower = 0;
            int upper = 0;
            int num = 0;
            int space = 0;
            for (int i = 0; i < inputStr.length(); i++) {

                String temp = inputStr.substring(i,i+1);
                if(temp.matches("^[a-z]$")) {
                    lower++;
                } else if(temp.matches("^[A-Z]$")) {
                    upper++;
                } else if(temp.matches("^[0-9]$")) {
                    num++;
                } else if(temp.equals(" ")) {
                    space++;
                }
            }
            System.out.print(lower);
            System.out.print(" ");
            System.out.print(upper);
            System.out.print(" ");
            System.out.print(num);
            System.out.print(" ");
            System.out.println(space);
        }
    }
}
