public class LinkedList {

    Node head;
    Node tail;
    int size = 0;

    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void addFirst(int data)
    {
        Node node = new Node(data);
        node.next = head;
        head = node;
        size++;
    }

    public void add(int k)
    {
        //Node temp = head;
        Node lastNode = new Node(k);
        lastNode.next = null;
        size++;
        if (head == null) {
            head = lastNode;
            tail = lastNode;
            return;
        }
        tail.next = lastNode;
        tail = lastNode;
        /*while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = lastNode;*/
    }

    public void removeFirst()
    {
        Node node = head;
        if (head == null) {
            System.out.println("No job :)");
            return;
        }
        System.out.println(node.data);
        head = head.next;
        size--;
    }

    public void removeLast()
    {
        Node pointer = head;
        if (head == null) {
            System.out.println("No job :)");
            return;
        }
        else if (head.next == null) {
            System.out.println(head.data);
            head = null;
            tail = null;
        }
        else {
            while (pointer.next != null) {
                if (pointer.next.next == null) {
                    System.out.println(pointer.next.data);
                    pointer.next = null;
                    break;
                }
                pointer = pointer.next;
            }
        }
        size--;
    }

    public void reverse()
    {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    int getSize ()
    {
        return size;
    }
    public void print() {
        Node node = head;
        if (node == null)
        {
            System.out.println();
            return;
        }
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println(" ");
    }

}
