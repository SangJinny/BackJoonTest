import java.util.LinkedList;

public class kakao_thr {

    static LinkedList<String> cache;
    static int size;
    public int solution (int cacheSize, String[] cities) {

        int answer = 0;
        size = cacheSize;
        cache = new LinkedList<String>();


        for (int i = 0; i < cities.length; i++) {

            answer += searchCache(cities[i].toUpperCase());
        }
        return answer;
    }

    public int searchCache (String input) {

        for (String key: cache) {



            if(key.equals(input)) {

                cache.remove(input);
                cache.addFirst(input);
                return 1;
            }
        }

        addCache(input);
        return 5;
    }

    public void addCache (String input) {

        if(size > 0) {
            if (cache.size() < size) {

                cache.addFirst(input);

                return;
            } else {
                cache.removeLast();
                cache.addFirst(input);
                return;
            }
        }
    }
}









