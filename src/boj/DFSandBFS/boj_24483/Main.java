import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R, order;
    static long answer;
    static ArrayList<ArrayList<Integer>> graph;
    static long[] visit, orderArr;
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public void solution() throws Exception {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visit = new long[N + 1];
        orderArr = new long[N + 1];

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

        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        for (int i = 1; i < N + 1; i++) {
            visit[i] = -1;
        }
        order = 1;
        answer = 0;
        visit[R] = 0;
        dfs(R, 0);
        for (int i = 1; i < N + 1; i++) {
            answer += visit[i] * orderArr[i];
        }

        bw.write(String.valueOf(answer));
        bw.flush();//남아있는 데이터를 모두 출력시킴
        bw.close();//스트림을 닫음
    }

    private static void dfs(int R, int depth) {
        int size = graph.get(R).size();
        if (size == 0) return;
        visit[R] = depth;
        orderArr[R] = order++;

        for (int i = 0; i < size; i++) {
            int newVertex = graph.get(R).get(i);
            if (visit[newVertex] != -1) continue;

            dfs(newVertex, depth + 1);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
