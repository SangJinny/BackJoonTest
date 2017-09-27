import java.util.*;

public class NHNTEST_2 {

    public static void nhntest_2() {

        Scanner scan = new Scanner(System.in);
        String command = scan.next();
        String secretKey = scan.next();
        int lotateNum = scan.nextInt();
        String inputWrd = scan.next();

        char [] secretKeyArr = secretKey.toCharArray();
        char [] inputWrdArr =inputWrd.toCharArray();
        char [] bfrLotateArr = new char [secretKey.length()];

        if("encrypt".equals(command)) {
            for (int i = 0; i < secretKeyArr.length; i++) {

                bfrLotateArr[i] = (char) ((inputWrdArr[i] - 97 + secretKeyArr[i] - 97) % 26 + 97);
            }

            List<Character> lotateArr = new LinkedList<>();
            for (char temp :
                    bfrLotateArr) {
                lotateArr.add(temp);
            }

            int abs = Math.abs(lotateNum);

            for (int i = 0; i < abs; i++) {

                if(lotateNum > 0) {

                    char temp = lotateArr.get(0);
                    lotateArr.remove(0);
                    lotateArr.add(temp);
                } else if (lotateNum < 0) {

                    Collections.reverse(lotateArr);
                    char temp = lotateArr.get(0);
                    lotateArr.remove(0);
                    lotateArr.add(temp);
                    Collections.reverse(lotateArr);
                }
            }

            for (char temp :
                    lotateArr) {
                System.out.print(temp);
            }
            System.out.println();

        } else if ("decrypt".equals(command)) {

            List<Character>lotateArr = new LinkedList<>();
            for (char temp: inputWrdArr) {
                lotateArr.add(temp);
            }

            int abs = Math.abs(lotateNum);

            for (int i = 0; i < abs; i++) {

                if(lotateNum < 0) {

                    char temp = lotateArr.get(0);
                    lotateArr.remove(0);
                    lotateArr.add(temp);
                } else if (lotateNum > 0) {

                    Collections.reverse(lotateArr);
                    char temp = lotateArr.get(0);
                    lotateArr.remove(0);
                    lotateArr.add(temp);
                    Collections.reverse(lotateArr);
                }
            }

            for (int i = 0; i < inputWrdArr.length; i++) {

                inputWrdArr[i] = lotateArr.get(i);
            }

            for (int i = 0; i < secretKeyArr.length; i++) {

                if((secretKeyArr[i] - 97 - inputWrdArr[i] - 97) > 0) {
                    bfrLotateArr[i] = (char) ((secretKeyArr[i] - 97 - inputWrdArr[i] - 97) % 26 + 97);
                } else {
                    bfrLotateArr[i] = (char) ((secretKeyArr[i] - 97 - inputWrdArr[i] - 97) % 26 + 122);
                }
            }

            for (char temp :
                    bfrLotateArr) {
                System.out.print(temp);
            }
            System.out.println();

        }




    }
}







