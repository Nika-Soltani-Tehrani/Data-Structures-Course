import java.util.*;

public class RidingTrack{

    private static Scanner scanner = new Scanner(System.in);
    private static Queue<Integer> inputQueue = new LinkedList<>();
    private static Stack<Integer> allay = new Stack<>();
    private static Queue<Integer> output = new LinkedList<>();

    public static void main(String[] args){
        String input = scanner.nextLine();
        String[] parsedInput = input.split("\\s");

        //putting the input into inputQueue
        for(int i = 0; i < parsedInput.length; i++){
            inputQueue.add(Integer.parseInt(parsedInput[i]));
        }

        int num = 1;

        while(!inputQueue.isEmpty() || !allay.empty()){

            if(!inputQueue.isEmpty() && inputQueue.peek() == num){
                output.add(inputQueue.poll());
                num++;
            }
            else if(!allay.isEmpty() && allay.peek() == num){
                output.add(allay.pop());
                num++;
            }
            else if(inputQueue.isEmpty()){
                System.out.print("no");
                return;
            }
            else if(allay.empty()){
                allay.push(inputQueue.poll());
            }
            else{
                if(inputQueue.peek() > allay.peek()){
                    System.out.print("no");
                    return;
                }
                else{
                    allay.push(inputQueue.poll());
                }
            }
        }


        System.out.print("yes");

    }

}