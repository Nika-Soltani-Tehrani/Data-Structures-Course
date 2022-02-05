import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

class MaximumCourses {
    private static final int MAX = 1000;
    private static int[][] memo = new int[MAX][MAX];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String information = scanner.nextLine();
        Pattern pattern = Pattern.compile(" ");
        String[] words = pattern.split(information);
        int numOfCourses = Integer.parseInt((words[0]).trim());
        int numOfStudents = Integer.parseInt((words[1]).trim());
        for (int[] ints : memo) Arrays.fill(ints, -1);
        System.out.println(Tolerance(numOfCourses, numOfStudents));
    }

    public static int Tolerance(int k, int n)
    {

        if (memo[n][k] != -1)
            return memo[n][k];

        if (k == 1 || k == 0)
            return k;

        if (n == 1)
            return k;

        else{
            int min = Integer.MAX_VALUE;
            int x;
            int res;
            for (x = 1; x <= k; x++) {
                res = Math.max(Tolerance(x - 1, n - 1), Tolerance(k - x, n));
                if (res < min)
                    min = res;
            }
            memo[n][k] = min + 1;
            return min + 1;
        }
    }
}
