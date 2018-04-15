import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Country implements Comparable<Country>{

    public int name;
    public int gold;
    public int silver;
    public int bronze;

    @Override
    public int compareTo(Country o2) {

        if(this.gold > o2.gold) {

            return -1;
        } else if (this.gold < o2.gold) {

            return 1;
        } else {

            if(this.silver > o2.silver) {

                return -1;
            } else if (this.silver < o2.silver) {

                return 1;
            } else {

                if(this.bronze > o2.bronze) {

                    return -1;
                } else if (this.bronze < o2.bronze) {

                    return 1;
                } else {

                    return 0;
                }
            }
        }

    }
}

public class BackJoonTest_8979 {

    public void backJoonTest_8979() {

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();

        Country [] arr = new Country[n];
        for (int i = 0; i < n; i++) {

            arr[i] = new Country();
            arr[i].name = scan.nextInt();
            arr[i].gold = scan.nextInt();
            arr[i].silver = scan.nextInt();
            arr[i].bronze = scan.nextInt();
        }

        Arrays.sort(arr, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {

                if(o1.gold > o2.gold) {

                    return -1;
                } else if (o1.gold < o2.gold) {

                    return 1;
                } else {

                    if(o1.silver > o2.silver) {

                        return -1;
                    } else if (o1.silver < o2.silver) {

                        return 1;
                    } else {

                        if(o1.bronze > o2.bronze) {

                            return -1;
                        } else if (o1.bronze < o2.bronze) {

                            return 1;
                        } else {

                            return 0;
                        }
                    }
                }
            }
        });

        // 정렬을 완료했으니 순위를 산출해보자
        int rank = 1;
        for (int i = 0; i < n; i++) {

           if(arr[i].name == target) break;

           // i가 i+1보다 순위가 높음
           if(arr[i].compareTo(arr[i+1]) == -1) {

               rank = i+2; // arr[i+1]의 앞에 i+1개의 높은 국가가 있으므로
           }
        }

        System.out.println(rank);
    }
}
