public class kakao_one {

    public String [] kakao_one(int n, int[] arr1, int[] arr2) {

        String[] answer = new String [n];

        String [] chngArr1 = new String [n];
        String [] chngArr2 = new String [n];

        //System.out.println("start");
        for (int i = 0; i < n; i++) {

            int temp1 = arr1[i];
            int temp2 = arr2[i];
            chngArr1[i] = "";
            chngArr2[i] = "";

            while(temp1 > 0) {

                if(temp1 == 1) {
                    chngArr1[i] += String.valueOf(temp1 % 2);
                    break;
                }
                chngArr1[i] += String.valueOf(temp1 % 2);
                temp1 /= 2;
            }

            while(temp2 > 0) {

                if(temp2 == 1) {
                    chngArr2[i] += String.valueOf(temp2 % 2);
                    break;
                }
                chngArr2[i] += String.valueOf(temp2 % 2);
                temp2 /= 2;
            }
        }

        for (int i = 0; i < n; i++) {


            while(true) {

                if(chngArr1[i].length() >= n) {

                    break;
                }

                chngArr1[i] += "0";
            }

            while(true) {

                if(chngArr2[i].length() >= n) {

                    break;
                }

                chngArr2[i] += "0";
            }

            chngArr1[i] = new StringBuffer(chngArr1[i]).reverse().toString();
            chngArr2[i] = new StringBuffer(chngArr2[i]).reverse().toString();


            /*chngArr1[i] = String.format("%0"+n+"d", chngArr1[i]);
            chngArr2[i] = String.format("%0"+n+"d", chngArr2[i]);*/

        }


        /* 이진수 생성 완료 */

        for (int i = 0; i < n; i++) {

            char [] chngArr1Char = chngArr1[i].toCharArray();
            char [] chngArr2Char = chngArr2[i].toCharArray();
            String answerStr = "";
            //System.out.println(chngArr1Char);
            //System.out.println(chngArr2Char);
            for (int j = 0; j < n; j++) {

                if(chngArr1Char[j] == '0' && chngArr2Char[j] == '0') {

                    answerStr += " ";
                } else {
                    answerStr += "#";
                }
            }

            answer[i] = answerStr;
        }

        return answer;
    }
}
