//import java.util.*;
//import java.lang.*;
//import java.util.regex.Pattern;
//
//class GFG{
//
//    private static ArrayList<int[]> ans;
//    private static int flag = 1;
//
//    static int dfs(ArrayList<ArrayList<Integer>> adj, int[] order, int[] bridge_detect,boolean[] mark, int v, int l)
//    {
//        mark[v] = true;
//        order[v] = order[l] + 1;
//        bridge_detect[v] = order[v];
//
//        for(int i = 0; i < adj.get(v).size(); i++)
//        {
//            int u = adj.get(v).get(i);
//            if (u == l)
//                continue;
//
//            if (order[v] < order[u])
//                continue;
//
//            if (mark[u])
//                bridge_detect[v] = Math.min(order[u], bridge_detect[v]);
//
//            else
//                dfs(adj, order, bridge_detect, mark, u, v);
//
//            bridge_detect[v] = Math.min(bridge_detect[u],
//                    bridge_detect[v]);
//            ans.add(new int[]{v, u});
//        }
//
//        if (bridge_detect[v] == order[v] && l != 0)
//            flag = 0;
//
//        return flag;
//    }
//
//    static void createGraph(int[][] Edges, ArrayList<ArrayList<Integer>> adj, int M)
//    {
//
//        for(int i = 0; i < M; i++)
//        {
//            int u = Edges[i][0];
//            int v = Edges[i][1];
//            adj.get(u).add(v);
//            adj.get(v).add(u);
//        }
//    }
//
//    public static void main(String[] args)
//    {
//
//        Scanner scanner = new Scanner(System.in);
//        String information = scanner.nextLine();
//        String[] words = information.split(" ");
//        int nodes = Integer.parseInt((words[0]).trim());
//        int numOfEdges = Integer.parseInt((words[1]).trim());
//        ArrayList<Edge> edges = new ArrayList<>();
//        for (int i = 0; i < numOfEdges; i++) {
//            information = scanner.nextLine();
//            words = information.split(" ");
//            String s1 = words[0];
//            String s2 = words[1];
//            int node1 = Integer.parseInt(s1);
//            int node2 = Integer.parseInt(s2);
//            Edge edge = new Edge(node1, node2);
//            edges.add(edge);
//        }
//
//        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//        ans = new ArrayList<>();
//
//        for(int i = 0; i < nodes+1; i++)
//            adj.add(new ArrayList<>());
//
//        createGraph(edges, adj, numOfEdges);
//
//        int[] order = new int[nodes+1];
//        int[] bridge_detect = new int[nodes+1];
//        boolean[] mark = new boolean[nodes+1];
//
//        int flag = dfs(adj, order, bridge_detect, mark, 1, 0);
//
//        if (flag == 0)
//            System.out.print("-1");
//        else
//            System.out.println("1");
//    }
//}
//
