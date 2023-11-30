package algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    static final int MAX_N = 10;
    static int N, E;
    // 각 Node to Node의 거리를 기록하는 인접행렬
    static int[][] Graph = new int[MAX_N][MAX_N];

    // 모든 정점의 최단 거리를 담는 배열
    static int[] Dist = new int[MAX_N];
    // 거쳐온 경로를 표기하는 배열
    static int[] Prev = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 노드의 개수
        E = sc.nextInt(); // 간선의 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) Graph[i][j] = 0;
                else Graph[i][j] = INF;
            }
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int cost = sc.nextInt();
            Graph[u][v] = Graph[v][u] = cost;
        }
        dijkstra(0);

        int curr = 5;
        while (curr != -1) {
            System.out.print(curr + " < ");
            curr = Prev[curr];
        }

        for (int i = 0; i < N; i++) {
            System.out.print(Dist[i] + " ");
        }

    }

    static void dijkstra(int src) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        boolean[] visited = new boolean[MAX_N];

        for (int i = 0; i < N; i++) {
            Dist[i] = INF;
            Prev[i] = -1;
        }

        Dist[src] = 0;
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[1];
            if (visited[u]) continue;

            visited[u] = true;

            for (int v = 0; v < N; v++) {
                if (Dist[v] > Dist[u] + Graph[u][v]) {
                    Prev[v] = u;
                    Dist[v] = Dist[u] + Graph[u][v];
                    pq.add(new int[]{Dist[v], v});
                }
            }
        }
    }
}
