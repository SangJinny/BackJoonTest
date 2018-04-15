import java.util.Scanner;

public class BackJoonTest_2577 {
    public static void BackJoonTest_2577() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        char[] multiflyResult = String.valueOf(a*b*c).toCharArray();
        int [] arr = {0,0,0,0,0,0,0,0,0,0};

        for(int i = 0 ; i < multiflyResult.length; i++) {
            arr[Integer.valueOf(String.valueOf(multiflyResult[i]))]++;
        }

        for (int result :
                arr) {
            System.out.println(result);
        }
        
    }
}
