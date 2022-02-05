import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

class Finders{
    private static int maxPathValue;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int nodes = scanner.nextInt();
        scanner.nextLine();
        int numOfEdges = nodes - 1;
        int[][] edges = new int[numOfEdges][];
        int k = 0;
        for (int i = 0; i < numOfEdges; i++)
        {
            String instruction = scanner.nextLine();
            Pattern pattern = Pattern.compile(" ");
            String[] words = pattern.split(instruction);
            int[] edge = new int[words.length];
            for (int j = 0; j < words.length; j++)
                edge[j] = Integer.parseInt((words[j]).trim());
            edges[k++] = edge;
        }

        ArrayList<Integer>[]g = new ArrayList[numOfEdges + 2];
        for(int i = 0; i < g.length; i++)
            g[i] = new ArrayList<>();

        for (int[] edge : edges) {
            g[edge[0]].add(edge[1]);
            g[edge[1]].add(edge[0]);
        }

        System.out.println(maxProductOfTwoPaths(g, numOfEdges));
    }

    public static int DFS(ArrayList<Integer>[] g, int u, int v)
    {
        int max1 = 0;
        int max2 = 0;
        int total = 0;
        for(int i = 0; i < g[u].size(); i++)
        {
            if (g[u].get(i) == v)
                continue;
            total = Math.max(total, DFS(g, g[u].get(i), u));
            if (maxPathValue > max1)
            {
                max2 = max1;
                max1 = maxPathValue;
            }
            else
                max2 = Math.max(max2, maxPathValue);
        }
        total = Math.max(total, max1 + max2);
        maxPathValue = max1 + 1;
        return total;
    }

    public static int maxProductOfTwoPaths(ArrayList<Integer>[] g, int N)
    {
        int res = 0;
        int path1;
        int path2;

        for(int i = 1; i < N + 2; i++)
        {
            for(int j = 0; j < g[i].size(); j++)
            {
                maxPathValue = 0;
                path1 = DFS(g, g[i].get(j), i);
                maxPathValue = 0;
                path2 = DFS(g,i, g[i].get(j));
                res = Math.max(res, path1 * path2);
            }
        }
        return res;
    }
}
