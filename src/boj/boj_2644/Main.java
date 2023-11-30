package boj.boj_2644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 백준2644_ 촌수계산
// https://www.acmicpc.net/problem/2644
public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer, n, start, end, m;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public void solution() throws Exception {
        answer = -1;

        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        dfs(start, 0);

        System.out.println(answer);
    }

    public static void dfs(int point, int count) {
        visited[point] = true;
        for (int x : graph.get(point)) {
            if (!visited[x]) {
                if (x == end) {
                    answer = count + 1;
                    return;
                }
                //다음 촌수로 이동
                dfs(x, count + 1);
            }
        }
    }

    public static void main
            (String[] args) throws Exception {
        new Main().solution();
    }
}
