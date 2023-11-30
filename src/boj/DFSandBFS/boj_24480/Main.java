package boj.DFSandBFS.boj_24480;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, order;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] check;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        check = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
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
        int size = graph.get(R).size();

        for (int i = size - 1; i >= 0; i--) {
            int newVertex = graph.get(R).get(i);

            if (check[newVertex] == 0) {
                order += 1;
                dfs(newVertex);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new boj.DFSandBFS.boj_24479.Main().solution();
    }
}
