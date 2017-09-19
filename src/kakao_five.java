import java.util.*;
import java.util.regex.Pattern;

public class kakao_five {

    public int solution(String str1, String str2) {

        int answer = 0;
        int crossCnt = 0;
        int unionCnt = 0;
        int duplicated = 1;
        List<String> strSet1 = splitStr(str1);
        List<String> strSet2 = splitStr(str2);

        Map<String, Integer> strMap1 = new HashMap<String, Integer>();

        for (int i = 0; i < strSet1.size(); i++) {

            for (int j = i+1; j < strSet1.size(); j++) {

                if(strSet1.get(i).equals(strSet1.get(j))) {

                    if(strSet1.contains(strSet1.get(i))) {

                        strMap1.put(strSet1.get(i), strMap1.get(strSet1.get(i)+1));
                    } else {

                        strMap1.put(strSet1.get(i), 2);
                    }

                } else {

                    strMap1.put(strSet1.get(i), 1);
                }
            }
        }

        Map<String, Integer> strMap2 = new HashMap<String, Integer>();

        for (int i = 0; i < strSet2.size(); i++) {

            for (int j = i+1; j < strSet2.size(); j++) {

                if(strSet2.get(i).equals(strSet2.get(j))) {

                    if(strSet2.contains(strSet2.get(i))) {

                        strMap2.put(strSet2.get(i), strMap2.get(strSet2.get(i)+1));
                    } else {

                        strMap2.put(strSet2.get(i), 2);
                    }

                }
                else {

                    strMap2.put(strSet2.get(i), 1);
                }
            }
        }

        Set result1 = strMap1.keySet();
        Iterator it1 = result1.iterator();

        Map<String, String> forUnion = new HashMap<>();
        while(it1.hasNext()) {

            String val1 = String.valueOf(it1.next());
            Set result2 = strMap2.keySet();
            Iterator it2 = result2.iterator();
            while(it2.hasNext()) {

                String val2 = String.valueOf(it2.next());
                if(val1.equals(val2)) {
                    crossCnt += (strMap1.get(val1) < strMap2.get(val2)) ? strMap1.get(val1) : strMap2.get(val2);
                    unionCnt += (strMap1.get(val1) > strMap2.get(val2)) ? strMap1.get(val1) : strMap2.get(val2);
                } else {

                    if(!forUnion.containsKey(val1)) {

                        forUnion.put(val1, val1);
                    }
                    if(!forUnion.containsKey(val2)) {
                        forUnion.put(val2, val2);
                    }
                }
            }
        }

        unionCnt += forUnion.size();
        answer = 65536 * crossCnt / unionCnt;
        /*System.out.println(strSet1.size());
        System.out.println(strSet2.size());
        System.out.println(crossCnt);
        System.out.println(unionCnt);*/

        return answer;
    }

    public List<String> splitStr (String str) {

        String temp = "";
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {

            String one = str.substring(i,i+1);
            if(Pattern.matches("^[a-zA-Z]$", one)) {
                temp += one;
            } else {
                continue;
            }

            if(temp.length() == 2) {

                strList.add(temp.toUpperCase());
                i--;
                temp = "";
            }
        }

        return strList;
    }
}
