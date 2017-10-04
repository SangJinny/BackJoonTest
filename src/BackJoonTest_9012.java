import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class BackJoonTest_9012 {

    /* 자료구조 스택 Stack */
    public static void BackJoonTest_9012 () {

        Scanner scan = new Scanner(System.in);
        int n = Integer.valueOf(scan.nextLine());
        String [] inputs = new String [n];

        for (int i = 0; i < n; i++) {

            inputs[i] = scan.nextLine();
        }

        for (String testCase :
                inputs) {
            boolean isVPS = true;
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < testCase.length(); i++) {
                //System.out.println(testCase.length());
                String testChar = testCase.substring(i,i+1);
                if("(".equals(testChar)) {

                    stack.push(testChar);
                } else if (")".equals(testChar)) {

                    if(stack.empty()) {
                        isVPS = false;
                        break;
                    } else if (!"(".equals(stack.pop())) {

                        isVPS = false;
                        break;
                    }
                }
            }

            if(!stack.empty()) {
                isVPS = false;
            }

            System.out.println(isVPS ? "YES" : "NO");
        }
    }
}
