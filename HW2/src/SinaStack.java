import java.util.Scanner;
import java.util.regex.Pattern;

public class SinaStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        sc.nextLine();
        DoublyLinkedList list = new DoublyLinkedList();
        boolean reversed= false;

        while(numbers-- > 0)
        {
            String instruction = sc.nextLine();
            Pattern pattern = Pattern.compile(" ");
            String[] words = pattern.split(instruction);

            if (instruction.contains("front") & !instruction.contains("to")) {
                if (!reversed)
                    list.removeFirst();
                else
                    list.removeLast();
            }
            if (instruction.contains("back") & !instruction.contains("push")) {
                if (reversed)
                    list.removeFirst();
                else
                    list.removeLast();
            }
            if (instruction.contains("reverse")) {
                reversed = !reversed;
                //list.reverse();
            }
            if (instruction.contains("size")) {
                System.out.println(list.getSize());
            }
            if (instruction.contains("to_front")) {
                if (list.getSize() < 50000) {
                    if (!reversed)
                        list.to_front(Integer.parseInt((words[words.length - 1]).trim()));
                    else
                        list.push_back(Integer.parseInt((words[words.length - 1]).trim()));
                }
                else
                    System.out.println("No more space :(");
            }
            if (instruction.contains("push_back")) {
                if (list.getSize() < 50000) {
                    if (reversed)
                        list.to_front(Integer.parseInt((words[words.length - 1]).trim()));
                    else
                        list.push_back(Integer.parseInt((words[words.length - 1]).trim()));
                }
                else
                    System.out.println("No more space :(");
            }
            if (instruction.contains("print"))
                list.print();
        }


    }

}
