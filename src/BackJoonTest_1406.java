import java.util.Scanner;

public class BackJoonTest_1406 {

    public static void BackJoonTest_1406 () {

        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int num = Integer.valueOf(scan.nextLine());

        String [] cmds = new String[num];

        StringBuilder answer = new StringBuilder();

        answer.append(input);

        for (int i = 0; i < num; i++) {
            cmds[i] = scan.nextLine();
        }

        int cursor = answer.length();

        for (String cmd :
                cmds) {

            if("L".equals(cmd)) {

                if(cursor != 0) {

                    cursor--;
                }
            } else if ("D".equals(cmd)) {

                if(cursor != answer.length()) {

                    cursor++;
                }
            } else if ("B".equals(cmd)) {

                answer.delete(cursor-1, cursor);
                cursor--;
            } else if (cmd.startsWith("P")){

                String newChar = cmd.substring(2,3);
                answer.insert(cursor, newChar);
                cursor++;
            }
        }

        System.out.println(answer);
    }
}
