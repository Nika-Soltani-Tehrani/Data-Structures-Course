import java.util.ArrayList;
import java.util.Scanner;

public class SerialMurderer {

    public static void main(String[] args)
    {
        int curIndex = 0;
        int movements = 0;
        Scanner scanner = new Scanner(System.in);
        int numOfCities = scanner.nextInt();
        scanner.nextLine();
        int[] indexArray = new int[numOfCities];
        ArrayList<String> cityNames = new ArrayList<>();
        for (int i = 0; i < numOfCities; i++)
        {
            cityNames.add(scanner.nextLine());
        }
        int numOfInstructions = scanner.nextInt();
        scanner.nextLine();
        ArrayList<String> instructions = new ArrayList<>();
        for (int i = 0; i < numOfInstructions; i++)
        {
            instructions.add(scanner.nextLine());
        }
        for (int i = 0; i < numOfCities; i++)
            indexArray[i] = numOfInstructions;

        while (curIndex < numOfInstructions - 1){
            for (int i = 0; i < numOfCities; i++) {
                for (int j = curIndex; j < numOfInstructions; j++) {
                    if (instructions.get(j).equals(cityNames.get(i))) {
                        indexArray[i] = j;
                        break;
                    }
                }
            }
            curIndex = indexArray[0];
            for (int j : indexArray) {
                if (j > curIndex)
                    curIndex = j;
            }
//            System.out.println(curIndex + "PPPPPPPP");
            movements++;
        }
        System.out.println(movements-1);
    }
}
//3
//        Hamedan
//        Bandar Abbas
//        Tehran
//        6
//        Bandar Abbas
//        Hamedan
//        Hamedan
//        Tehran
//        Tehran
//        Bandar Abbas