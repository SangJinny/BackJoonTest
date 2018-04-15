import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Shop {

    int x;
    int y;
    String name;
    int coupon;
    int distance;

    public Shop(int x, int y, String name, int coupon, int distance) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.coupon = coupon;
        this.distance = distance;
    }
}
public class LINE2018_02 {
    public static void test() throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
            int userX = Integer.parseInt(tokens.nextToken());
            int userY = Integer.parseInt(tokens.nextToken());
            int shopCount = Integer.parseInt(tokens.nextToken());

            ArrayList<Shop> shopList = new ArrayList<>();
            for (int i = 0; i < shopCount; i++) {
                tokens = new StringTokenizer(br.readLine().trim());
                int shopX = Integer.parseInt(tokens.nextToken());
                int shopY = Integer.parseInt(tokens.nextToken());
                String name = tokens.nextToken();
                int coupon = Integer.parseInt(tokens.nextToken());
                shopList.add(new Shop(shopX, shopY, name, coupon, calDistance(userX, userY, shopX, shopY)));

            }

            Collections.sort(shopList, new Comparator<Shop>() {
                @Override
                public int compare(Shop o1, Shop o2) {
                    if(o1.distance < o2.distance) {
                        return -1;
                    } else if (o1.distance > o2.distance) {
                        return 1;
                    } else {
                        if(o1.coupon > o2.coupon) {
                            return -1;
                        } else if(o1.coupon < o2.coupon){
                            return 1;
                        } else {
                            return o1.name.compareTo(o2.name);
                        }
                    }

                }
            });

            for (Shop temp :
                    shopList) {
                System.out.print(temp.x);
                System.out.print(" ");
                System.out.print(temp.y);
                System.out.print(" ");
                System.out.print(temp.name);
                System.out.print(" ");
                System.out.println(temp.coupon);
            }
        }
    }

    public static int calDistance(int userX, int userY, int ShopX, int ShopY) {
        int X = userX - ShopX;
        int Y = userY - ShopY;

        int result = (int)Math.sqrt((X*X) + (Y*Y));
        System.out.println(result/100*100);
        return result/100*100;
    }
}
