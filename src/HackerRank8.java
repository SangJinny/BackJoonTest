import java.util.Scanner;

public class HackerRank8 {
    static String[] bomberMan(int n, String[] grid) {
        String [] boomGrid = null;
        String [] plantGrid = null;

        plantGrid = checkBoomTime(grid);
        plantGrid = plantBomb(plantGrid);

        boomGrid = boom(plantGrid);

        if(n%2 == 0) {
            return beforeReturn(plantGrid);
        } else if (n%4 == 1) {
            return beforeReturn(grid);
        } else {
            return beforeReturn(boomGrid);
        }
        /*while(time++ < n) {
            if(time%2 == 0) {
                grid = checkBoomTime(grid);
                grid = plantBomb(grid);
            } else {
                grid = boom(grid);
            }
        }
        return beforeReturn(grid);*/
    }
    public static String [] checkBoomTime(String [] grid) {
        String[] resultGrid = new String[grid.length];

        for(int i = 0 ; i < grid.length ; i++) {
            resultGrid[i] = grid[i].replace("O","X");
        }
        return resultGrid;
    }
    public static String [] plantBomb(String [] grid) {
        String[] resultGrid = new String[grid.length];

        for(int i = 0 ; i < grid.length ; i++) {
            resultGrid[i] = grid[i].replace(".","O");
        }
        return resultGrid;
    }

    public static String [] boom(String [] grid) {
        char [][] tempGrid = new char[grid.length][grid[0].length()];
        for(int i = 0; i < grid.length; i++) {
            tempGrid[i] = grid[i].toCharArray();
        }
        for(int i = 0; i < tempGrid.length; i++) {
            for(int j = 0 ; j < tempGrid[i].length; j++) {
                if(tempGrid[i][j] == 'X') {
                    if (boomState(tempGrid, i - 1, j)) {
                        tempGrid[i-1][j] = '.';
                    }
                    if (boomState(tempGrid, i + 1, j)) {
                        tempGrid[i+1][j] = '.';
                    }
                    if (boomState(tempGrid, i, j-1)) {
                        tempGrid[i][j-1] = '.';
                    }
                    if (boomState(tempGrid, i, j+1)) {
                        tempGrid[i][j+1] = '.';
                    }
                    tempGrid[i][j] = '.';
                }
            }
        }
        String [] resultGrid = new String[grid.length];
        for(int i = 0 ; i < grid.length ; i++) {
            resultGrid[i] = new String(tempGrid[i]);
        }
        return resultGrid;
    }
    public static boolean boomState(char[][] tempGrid, int i, int j) {
        if(i < 0 || i >= tempGrid.length) {
            return false;
        }

        if(j < 0 || j >= tempGrid[0].length) {
            return false;
        }

        if(tempGrid[i][j] != 'X') {
            return true;
        } else {
            return false;
        }
    }
    public static String [] beforeReturn (String [] grid) {
        String[] resultGrid = new String[grid.length];

        for(int i = 0 ; i < grid.length ; i++) {
            resultGrid[i] = grid[i].replace("X","O");
        }
        return resultGrid;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int c = in.nextInt();
        int n = in.nextInt();
        String[] grid = new String[r];
        for(int grid_i = 0; grid_i < r; grid_i++){
            grid[grid_i] = in.next();
        }
        String[] result = bomberMan(n, grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
