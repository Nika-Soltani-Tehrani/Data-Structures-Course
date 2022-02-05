import java.util.Scanner;
import java.util.Stack;

class Q3
{
    static void pushed_popped_check(int[] pushed, int[] popped, int len)
    {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++)
        {
            stack.push(pushed[i]);
            while (!stack.empty() && j < len && stack.peek() == popped[j])
            {
                stack.pop();
                j++;
            }
        }
        if (j == len)
            System.out.println("true");
        else
            System.out.println("false");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        String[] pushedArray = input.split(" ");
        int[] pushed = new int[pushedArray.length];
        for(int i = 0; i < pushedArray.length; i++) {
            pushed[i] = Integer.parseInt(pushedArray[i]);
        }
        //System.out.println(pushed[0]);
        input = sc.nextLine();
        String[] poppedArray = input.split(" ");
        int[] popped = new int[poppedArray.length];
        for(int i = 0; i < poppedArray.length; i++) {
            popped[i] = Integer.parseInt(poppedArray[i]);
        }
        /*for (int j : popped) {
            System.out.println(j);
        }*/
        pushed_popped_check(pushed, popped, numbers);
    }
}