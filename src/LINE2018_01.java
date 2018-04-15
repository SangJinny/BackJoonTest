import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class LINE2018_01 {
    public static void test() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < T; ++i) {
                String word = br.readLine().trim();

                int sizeOfStack = 0;
                StringBuffer result = new StringBuffer("");

                for(int j = 0; j < word.length(); j++) {
                    String charac = word.substring(j, j+1);
                    if(stack.size() == 0) {
                        stack.push(charac);
                    } else {
                        String top = stack.peek();

                        if(top.equals(charac)) {
                            stack.push(charac);

                        } else {
                            sizeOfStack = stack.size();
                            stack.clear();
                            result.append(sizeOfStack);
                            result.append(top);
                            stack.push(charac);
                        }
                    }
                }
                if(stack.size() !=0) {
                    String top = stack.peek();
                    sizeOfStack = stack.size();
                    stack.clear();
                    result.append(sizeOfStack);
                    result.append(top);
                }
                System.out.println(result);
                stack.clear();
            }



        }

    }
}
