import java.util.Scanner;
import java.util.regex.Pattern;

public class SinaStackUpload {

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
class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void to_front(int value) {
        Node node = new Node(value);
        if(size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    // insert value at the back of the linked list
    public void push_back(int value) {
        Node node = new Node(value);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    // removes the item at front of the linked list and return
    public void removeFirst() {
        if (size == 0) {
            System.out.println("No job :)");
            return;
        }
        int item = head.data;
        Node next = head.next;
        if (next != null) {
            next.prev = null;
        }
        head = next;
        size--;
        System.out.println(item);
    }

    // remove the item at the end of the list and return
    public void removeLast() {
        if (size == 0) {
            System.out.println("No job :)");
            return;
        }
        int item = tail.data;
        Node prev = tail.prev;
        if (prev != null) {
            prev.next = null;
        }
        tail.prev = null;
        tail = prev;
        size--;
        System.out.println(item);
    }

    // check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // print all the items
    public void print() {
        if (isEmpty()) {
            System.out.println("Nothing to display");
        } else {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }

    // print all the items
    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Nothing to display");
        } else {
            Node curr = tail;
            while (curr != null) {
                System.out.print(curr.data + " ");
                curr = curr.prev;
            }
            System.out.println();
        }
    }

    public int getSize()
    {
        return size;
    }

}