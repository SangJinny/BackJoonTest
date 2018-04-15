import java.util.Scanner;

public class HackerRank6 {
    static String solve(int year){
        int [] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year < 1918) {
            if(year%4 == 0) {
                return "12.09."+year;
            } else {
                return "13.09."+year;
            }
        } else if (year > 1918) {
            if(year % 4 == 0) {
                if(year % 400 == 0) {
                    return "12.09."+year;
                } else if (year % 100 == 0) {
                    return "13.09."+year;
                } else {
                    return "12.09."+year;
                }
            } else {
                return "13.09."+year;
            }
        } else {
            return "26.09."+year;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
