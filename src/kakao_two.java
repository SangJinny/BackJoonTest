import java.util.ArrayList;

public class kakao_two {

    public int solution(String dartResult) {

        int answer = 0;
        int [] num = new int [3];
        int [] score = new int [3];
        int index = -1;

        for (int i = 0; i < dartResult.length(); i++) {

            String temp = dartResult.substring(i,i+1);
            if("1".equals(temp) && "0".equals(dartResult.substring(i+1, i+2))) {

                i++;
                temp = "10";
            }

            if(isNumber(temp)) {

                index ++;
                num[index] = Integer.valueOf(temp);
            } else if ("S".equals(temp)) {

                num[index] = num[index];
            } else if ("D".equals(temp)) {

                num[index] = num[index] * num[index];
            } else if("T".equals(temp)) {

                num[index] = num[index] * num[index] * num[index];
            } else if("*".equals(temp)) {

                num[index] = num[index] * 2;
                if(index > 0) {

                    num[index-1] = num[index-1] * 2;
                }
            } else if("#".equals(temp)) {

                num[index] = num[index] * -1;
            }
        }

        for (int i = 0; i < num.length; i++) {

            answer += num[i];
        }
        return answer;
    }

    public boolean isNumber (String input) {

        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return false;
        }

        return true;
    }


}
