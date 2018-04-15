
import java.util.Stack;

public class WooWa02 {

    public int WooWa02 (String S) {

        String [] inputStrArr = S.split(" ");
        Stack<Integer> stack = new Stack<>();

        for (String inputStr :
                inputStrArr) {

            if("DUP".equals(inputStr)) {

                if(stack.size() == 0) {

                    return -1;
                }

                int targetNum = stack.pop();
                stack.push(targetNum);
                stack.push(targetNum);

            } else if ("+".equals(inputStr)) {

                if(stack.size() < 2) {

                    return -1;
                }

                int first = stack.pop();
                int second = stack.pop();
                if(first+second > 1048576 -1) {
                    return -1;
                }
                stack.push(first+second);
            } else if ("-".equals(inputStr)) {

                if(stack.size() < 2) {

                    return -1;
                }

                int first = stack.pop();
                int second = stack.pop();
                if(first - second < 0) {

                    return -1;
                }

                stack.push(first - second);
            } else if ("POP".equals(inputStr)) {

                if(stack.size() == 0) {

                    return -1;
                }
                stack.pop();
            } else {
                int value = Integer.valueOf(inputStr);

                if(value < 0 || value > 1048576 - 1) {

                    return -1;
                }
                stack.push(Integer.valueOf(inputStr));
            }
        }




        return stack.pop();
    }
}
