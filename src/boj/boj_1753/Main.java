package boj.boj_1753;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static ArrayList<Node>[] graph;
    static int[] dist;

    static int V, E, K, u, v, w;

    static int answer;
    static final int INF = 987654321;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        answer = 0;
        st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(K);


        for (int i = 1; i < V + 1; i++) {
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.cost > dist[currentNode.v]) continue;

            for (Node nextNode : graph[currentNode.v]) {
                int nextDistance = nextNode.cost + dist[currentNode.v];
                int nextIndex = nextNode.v;
                if (dist[nextIndex] > nextDistance) {
                    dist[nextIndex] = nextDistance;
                    queue.add(new Node(nextIndex, nextDistance));
                }
            }
        }
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
