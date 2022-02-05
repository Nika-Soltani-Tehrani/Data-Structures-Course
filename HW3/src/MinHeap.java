/*import java.util.Scanner;
import java.util.regex.Pattern;

class MinHeapNode
{
    int element;
    int i;
    int j;
    public MinHeapNode(int element, int i, int j)
    {
        this.element = element;
        this.i = i;
        this.j = j;
    }
}
class MinHeap
{
    MinHeapNode[] heapArr;
    int heap_size;
    public MinHeap(MinHeapNode[] a, int size)
    {
        heap_size = size;
        heapArr = a;
        int i = (heap_size - 1)/2;
        while (i >= 0)
        {
            MinHeapify(i);
            i--;
        }
    }

    void MinHeapify(int i)
    {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < heap_size && heapArr[l].element < heapArr[i].element)
            smallest = l;
        if (r < heap_size && heapArr[r].element < heapArr[smallest].element)
            smallest = r;
        if (smallest != i)
        {
            swap(heapArr, i, smallest);
            MinHeapify(smallest);
        }
    }

    int left(int i)
    {
        return (2*i + 1);
    }
    int right(int i)
    {
        return (2*i + 2);
    }

    MinHeapNode getMin()
    {
        if(heap_size <= 0)
        {
            System.out.println("Heap underflow");
            return null;
        }
        return heapArr[0];
    }

    void replaceMin(MinHeapNode root) {
        heapArr[0] = root;
        MinHeapify(0);
    }

    void swap(MinHeapNode[] arr, int i, int j) {
        MinHeapNode temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void mergeKSortedArrays(int[][] arr, int k)
    {
        MinHeapNode[] hArr = new MinHeapNode[k];
        int resultSize = 0;
        for(int i = 0; i < arr.length; i++)
        {
            MinHeapNode node = new MinHeapNode(arr[i][0],i,1);
            hArr[i] = node;
            resultSize += arr[i].length;
        }
        MinHeap mh = new MinHeap(hArr, k);
        int[] result = new int[resultSize];
        for(int i = 0; i < resultSize; i++)
        {
            MinHeapNode root = mh.getMin();
            result[i] = root.element;

            if(root.j < arr[root.i].length)
                root.element = arr[root.i][root.j++];
            else
                root.element = Integer.MAX_VALUE;

            mh.replaceMin(root);
        }
        for(int i : result)
            System.out.print(i + " ");
        System.out.println();

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        int[][] arr = new int[lines][];
        sc.nextLine();
        int k = 0;
        for (int i = 0; i < lines; i++)
        {
            String instruction = sc.nextLine();
            Pattern pattern = Pattern.compile(" ");
            String[] words = pattern.split(instruction);
            int[] bookNumbers = new int[words.length];
            for (int j = 0; j < words.length; j++)
                bookNumbers[j] = Integer.parseInt((words[j]).trim());
            arr[k++] = bookNumbers;
        }

        mergeKSortedArrays(arr,arr.length);
    }
}*/