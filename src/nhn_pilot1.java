



import com.sun.deploy.util.StringUtils;

import java.util.Collections;
import java.util.Scanner;



public class nhn_pilot1 {

    public static void nhn1 () {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        String [] numList = input.split(" ");


        String [] bigNumStrList = sortNums(numList, true);
        String [] smallNumStrList = sortNums(numList, false);


        String bigNumStr = "";
        String smallNumStr = "";

        for (int i = 0; i < bigNumStrList.length; i++) {
            bigNumStr = bigNumStr + bigNumStrList[i];
        }


        for (String temp :
                smallNumStrList) {
            smallNumStr = smallNumStr+ temp;

        }

        long bigNum = Long.valueOf(bigNumStr);
        long smallNum = Long.valueOf(smallNumStr);
        //System.out.println(bigNum);
        //System.out.println(smallNum);
        System.out.println(bigNum+smallNum);
    }

    public static String [] sortNums (String [] inputList, boolean isBig) {

        String [] numList = inputList;

        if(isBig) {

            for (int i = 0; i < numList.length-1; i++) {

                for (int j = i+1; j < numList.length; j++) {

                    if (Integer.valueOf(numList[i].substring(0, 1))
                            < Integer.valueOf(numList[j].substring(0, 1))) {

                        String temp = numList[i];
                        numList[i] = numList[j];
                        numList[j] = temp;

                    }
                }
            }

            for (int i = 0; i < numList.length-1; i++) {
                for (int j = i+1; j < numList.length; j++) {

                    if (numList[i].length() == 2 || numList[j].length()==2) {

                        String temp1 = numList[i];
                        String temp2 = numList[j];

                        if(temp1.length() == 1) {

                            temp1 += temp1;
                        } else if (temp2.length() == 1) {
                            temp2 += temp2;
                        }


                        if(Integer.valueOf(temp1) < Integer.valueOf(temp2)) {

                            String temp = numList[i];
                            numList[i] = numList[j];
                            numList[j] = temp;
                        }
                    }
                }
            }


        } else {

            for (int i = 0; i < numList.length-1; i++) {

                for (int j = i+1; j < numList.length; j++) {

                    if(Integer.valueOf(numList[i].substring(0,1))
                            > Integer.valueOf(numList[j].substring(0,1))) {

                        String temp = numList[i];
                        numList[i] = numList[j];
                        numList[j] = temp;

                    }
                }
            }

            for (int i = 0; i < numList.length-1; i++) {
                for (int j = i+1; j < numList.length; j++) {
                    if (numList[i].length() == 2 || numList[j].length()==2) {

                        String temp1 = numList[i];
                        String temp2 = numList[j];

                        if(temp1.length() == 1) {

                            temp1 = temp1+temp1;
                        } else if (temp2.length() == 1) {
                            temp2 = temp2+temp2;
                        }

                        if(Integer.valueOf(temp1) > Integer.valueOf(temp2)) {

                            String temp = numList[i];
                            numList[i] = numList[j];
                            numList[j] = temp;
                        }
                    }
                }
            }
        }
        return numList.clone();
    }
}
