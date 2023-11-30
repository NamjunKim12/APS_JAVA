package boj.DFSandBFS.boj_24479;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int V, E, R, order;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check, orderArr;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        check = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(st.nextToken());
            int arrival = Integer.parseInt(st.nextToken());
            // 무방향 그래프
            graph.get(departure).add(arrival);
            graph.get(arrival).add(departure);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }

        order = 1;

        dfs(R);

        for (int i = 1; i < check.length; i++) {
            sb.append(check[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int R) {
        check[R] = order;

        for (int i = 0; i < graph.get(R).size(); i++) {
            int newVertex = graph.get(R).get(i);

            if (check[newVertex] == 0) {
                order += 1;
                dfs(newVertex);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
