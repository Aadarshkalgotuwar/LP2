import java.util.*;

public class Classroom {

    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;

        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        // The edges should be added after initializing each ArrayList
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 5));
    }

    public static void bfs(ArrayList<Edge> graph[], int V) {
        Queue<Integer> q = new LinkedList<>(); // The correct class name is LinkedList, not Linkedlist
        boolean vis[] = new boolean[V];
        q.add(0);// starting node

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (vis[curr] == false) {
                System.out.println(curr + "");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.println(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (vis[e.dest] == false) {
                dfs(graph, e.dest, vis);
            }
        }

    }

    public static void main(String[] args) {
        int V = 6; // There are 6 vertices, not 7
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        bfs(graph, V);
        System.out.println();
        boolean vis[] = new boolean[V];
        dfs(graph, 0, vis);
    }
}
