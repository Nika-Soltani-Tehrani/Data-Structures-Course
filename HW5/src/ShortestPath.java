////import java.util.*;
////
////class Edge {
////    int source, dest, weight;
////
////    public Edge(int source, int dest, int weight) {
////        this.source = source;
////        this.dest = dest;
////        this.weight = weight;
////    }
////}
////
////class Graph {
////
////    List<List<Integer>> adjList = null;
////    Graph(List<Edge> edges, int x, int n) {
////        adjList = new ArrayList<>(10 * n);
////
////        for (int i = 0; i < 10 * n; i++) {
////            adjList.add(new ArrayList<>());
////        }
////
////        for (Edge edge : edges) {
////            int v = edge.source;
////            int u = edge.dest;
////            int weight = edge.weight;
////
////            if (weight == 10 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(v + 3 * n);
////                adjList.get(v + 3 * n).add(v + 4 * n);
////                adjList.get(v + 4 * n).add(v + 5 * n);
////                adjList.get(v + 5 * n).add(v + 6 * n);
////                adjList.get(v + 6 * n).add(v + 7 * n);
////                adjList.get(v + 7 * n).add(v + 8 * n);
////                adjList.get(v + 8 * n).add(v + 9 * n);
////                adjList.get(v + 9 * n).add(u);
////
////            } else if (weight == 9 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(v + 3 * n);
////                adjList.get(v + 3 * n).add(v + 4 * n);
////                adjList.get(v + 4 * n).add(v + 5 * n);
////                adjList.get(v + 5 * n).add(v + 6 * n);
////                adjList.get(v + 6 * n).add(v + 7 * n);
////                adjList.get(v + 7 * n).add(v + 8 * n);
////                adjList.get(v + 8 * n).add(u);
////            } else if (weight == 8 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(v + 3 * n);
////                adjList.get(v + 3 * n).add(v + 4 * n);
////                adjList.get(v + 4 * n).add(v + 5 * n);
////                adjList.get(v + 5 * n).add(v + 6 * n);
////                adjList.get(v + 6 * n).add(v + 7 * n);
////                adjList.get(v + 7 * n).add(u);
////            } else if (weight == 7 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(v + 3 * n);
////                adjList.get(v + 3 * n).add(v + 4 * n);
////                adjList.get(v + 4 * n).add(v + 5 * n);
////                adjList.get(v + 5 * n).add(v + 6 * n);
////                adjList.get(v + 6 * n).add(u);
////            } else if (weight == 6 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(v + 3 * n);
////                adjList.get(v + 3 * n).add(v + 4 * n);
////                adjList.get(v + 4 * n).add(v + 5 * n);
////                adjList.get(v + 5 * n).add(u);
////            } else if (weight == 5 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(v + 3 * n);
////                adjList.get(v + 3 * n).add(v + 4 * n);
////                adjList.get(v + 4 * n).add(u);
////
////            }
////            else if (weight == 4 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(v + 3 * n);
////                adjList.get(v + 3 * n).add(u);
////
////            } else if (weight == 3 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(v + 2 * n);
////                adjList.get(v + 2 * n).add(u);
////            }
////            else if (weight == 2 * x) {
////                adjList.get(v).add(v + n);
////                adjList.get(v + n).add(u);
////            }
////            else {
////                adjList.get(v).add(u);
////            }
////        }
////    }
////}
////
////class Main {
////    private static int printPath(int[] predecessor, int vertex, int cost, int n) {
////        if (vertex >= 0) {
////            cost = printPath(predecessor, predecessor[vertex], cost, n);
////            cost++;
////        }
////        return cost;
////    }
////
////    public static void findLeastPathCost(Graph graph, int source, int dest, int n) {
////        boolean[] discovered = new boolean[10 * n];
////        discovered[source] = true;
////        int[] predecessor = new int[10 * n];
////        Arrays.fill(predecessor, -1);
////        Queue<Integer> q = new ArrayDeque<>();
////        q.add(source);
////
////        while (!q.isEmpty()) {
////            int curr = q.poll();
////            if (curr == dest) {
////                System.out.print(printPath(predecessor, dest, -1, n) + " ");
////            }
////            for (int v : graph.adjList.get(curr)) {
////                if (!discovered[v]) {
////                    discovered[v] = true;
////                    q.add(v);
////                    predecessor[v] = curr;
////                }
////            }
////        }
////    }
////
////    public static void main(String[] args) {
////        int x = 1;
////
////        Scanner sc = new Scanner(System.in);
////        String str = sc.nextLine();
////        String[] tokens = str.split(" ");
////        String s1 = tokens[0];
////        String s2 = tokens[1];
////        String s3 = "";
////        int n = Integer.parseInt(s1);
////        int m = Integer.parseInt(s2);
////        List<Edge> edges = new ArrayList<>();
////
////        for (int i = 0; i < m; i++) {
////            str = sc.nextLine();
////            tokens = str.split(" ");
////            s1 = tokens[0];
////            int src = Integer.parseInt(s1);
////            s2 = tokens[1];
////            int dest = Integer.parseInt(s2);
////            s3 = tokens[2];
////            int w  = Integer.parseInt(s3);
////            Edge edge = new Edge(src, dest, w);
////            edges.add(edge);
////        }
////
////        str = sc.nextLine();
////        int source= Integer.parseInt(str);
////        Graph graph = new Graph(edges, x, n);
////        for (int i = 0; i <= n; i++)
////            findLeastPathCost(graph, source, i, n);
////    }
////
////}
//
//
//// Java to shortest path from a given source vertex 's' to
//// a given destination vertex 't'. Expected time complexity
//// is O(V+E).
//import java.util.*;
//import java.util.regex.Pattern;
//
//class GFG
//{
//    static class Graph
//    {
//        int V;
//        Vector<Integer>[] adj;
//        int maxWeight = 11;
//        static int level;
//
//        Graph(int V)
//        {
//            this.V = V;
//            this.adj = new Vector[maxWeight * V];
//
//            for (int i = 0; i < maxWeight * V; i++)
//                this.adj[i] = new Vector<>();
//        }
//
//        public void addEdge(int v, int w, int weight)
//        {
//            if (weight == 11)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(v + 4*this.V);
//                adj[v + 4*this.V].add(v + 5*this.V);
//                adj[v + 5*this.V].add(v + 6*this.V);
//                adj[v + 6*this.V].add(v + 7*this.V);
//                adj[v + 7*this.V].add(v + 8*this.V);
//                adj[v + 8*this.V].add(v + 9*this.V);
//                adj[v + 9*this.V].add(v + 10*this.V);
//                adj[v + 10*this.V].add(w);
//            }
//            else if (weight == 10)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(v + 4*this.V);
//                adj[v + 4*this.V].add(v + 5*this.V);
//                adj[v + 5*this.V].add(v + 6*this.V);
//                adj[v + 6*this.V].add(v + 7*this.V);
//                adj[v + 7*this.V].add(v + 8*this.V);
//                adj[v + 8*this.V].add(v + 9*this.V);
//                adj[v + 9*this.V].add(w);
//            }
//            else if (weight == 9)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(v + 4*this.V);
//                adj[v + 4*this.V].add(v + 5*this.V);
//                adj[v + 5*this.V].add(v + 6*this.V);
//                adj[v + 6*this.V].add(v + 7*this.V);
//                adj[v + 7*this.V].add(v + 8*this.V);
//                adj[v + 8*this.V].add(w);
//            }
//
//            else if (weight == 8)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(v + 4*this.V);
//                adj[v + 4*this.V].add(v + 5*this.V);
//                adj[v + 5*this.V].add(v + 6*this.V);
//                adj[v + 6*this.V].add(v + 7*this.V);
//                adj[v + 7*this.V].add(w);
//            }
//            else if (weight == 7)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(v + 4*this.V);
//                adj[v + 4*this.V].add(v + 5*this.V);
//                adj[v + 5*this.V].add(v + 6*this.V);
//                adj[v + 6*this.V].add(w);
//            }
//            else if (weight == 6)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(v + 4*this.V);
//                adj[v + 4*this.V].add(v + 5*this.V);
//                adj[v + 5*this.V].add(w);
//            }
//            else if (weight == 5)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(v + 4*this.V);
//                adj[v + 4*this.V].add(w);
//            }
//            else if (weight == 4)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(v + 3*this.V);
//                adj[v + 3*this.V].add(w);
//            }
//            else if (weight == 3)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(v + 2*this.V);
//                adj[v + 2*this.V].add(w);
//            }
//            else if (weight == 2)
//            {
//                adj[v].add(v + this.V);
//                adj[v + this.V].add(w);
//            } else
//                adj[v].add(w);
//        }
//        public int printShortestPath(int[] parent, int s, int d)
//        {
//            level = 0;
//            if (parent[s] == -1)
//            {
//                return level;
//            }
//
//            printShortestPath(parent, parent[s], d);
//
//            level++;
//
//            return level;
//        }
//        public int findShortestPath(int src, int dest)
//        {
//            boolean[] visited = new boolean[maxWeight * this.V];
//            int[] parent = new int[maxWeight * this.V];
//            for (int i = 0; i < maxWeight * this.V; i++)
//            {
//                visited[i] = false;
//                parent[i] = -1;
//            }
//
//            Queue<Integer> queue = new LinkedList<>();
//            visited[src] = true;
//            queue.add(src);
//
//            while (!queue.isEmpty())
//            {
//                int s = queue.peek();
//                if (s == dest)
//                    return printShortestPath(parent, s, dest);
//                queue.poll();
//                for (int i : this.adj[s])
//                {
//                    if (!visited[i])
//                    {
//                        visited[i] = true;
//                        queue.add(i);
//                        parent[i] = s;
//                    }
//                }
//            }
//            return 0;
//        }
//    }
//
//    public static void main(String[] args)
//    {
//        Scanner scanner = new Scanner(System.in);
//        String information = scanner.nextLine();
//        Pattern pattern = Pattern.compile(" ");
//        String[] words = pattern.split(" ");
//        int nodes = Integer.parseInt((words[0]).trim());
//        int edges = Integer.parseInt((words[1]).trim());
//        Graph g = new Graph(nodes);
//        for (int i = 0; i < edges; i++)
//        {
//            information = scanner.nextLine();
//            words = pattern.split(information);
//            int v = Integer.parseInt((words[0]).trim());
//            int w = Integer.parseInt((words[1]).trim());
//            int weight = Integer.parseInt((words[2]).trim());
//            g.addEdge(v, w, weight);
//        }
//        int src = scanner.nextInt();
//        scanner.nextLine();
//        for (int dest = 1; dest <= nodes ; dest++) {
//            System.out.print(g.findShortestPath(src, dest) + " ");
//        }
//
//    }
//}
//
