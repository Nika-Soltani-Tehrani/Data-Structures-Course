import java.util.Scanner;
import java.util.regex.Pattern;


class Heap
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String instruction = sc.nextLine();
        Pattern pattern = Pattern.compile(" ");
        String[] words = pattern.split(instruction);
        int n = Integer.parseInt((words[0]).trim());
        int m = Integer.parseInt((words[1]).trim());
        int[] startTimes = new int[n];
        int[] leaveTimes = new int[n];
        int[] coins = new int[n];
        int[] output = new int[m];
        int k = 0;
        for (int i = 0; i < n; i++)
        {
            instruction = sc.nextLine();
            pattern = Pattern.compile(" ");
            words = pattern.split(instruction);
            startTimes[i] = Integer.parseInt((words[0]).trim());
            leaveTimes[i] = Integer.parseInt((words[1]).trim());
            coins[i] = Integer.parseInt((words[2]).trim());
        }
        int maxCoin = 0;
        for (int i = 0; i < m; i++)
        {
            //System.out.println("i=" + i);
            for (int j = 0; j < n; j++)
            {
                //System.out.println("j=" + j);
                if (i >= startTimes[j] && i <= leaveTimes[j]) {
                    System.out.println(maxCoin);
                    if (coins[j] >= maxCoin) {
                        output[k] = coins[j];
                    }
                }
            }
            k++;
        }
        for (int i = 0; i < m; i++)
            System.out.print(output[i] + " ");
        System.out.println("");
    }
}