package swea.swea_1251;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Island {
    int x, y;
    double tax;

    Island() {
    }

    Island(int x, int y, double tax) {
        this.x = x;
        this.y = y;
        this.tax = tax; //가중치
    }
}

public class Solution {
    static int T, N;
    static int[] X, Y;
    static double E, answer;
    static ArrayList<Island> WeightsEachEdges;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_1251/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            // ////////////////////////입력부
            N = Integer.parseInt(br.readLine()); // 섬의 개수
            X = new int[N];
            Y = new int[N];
            parent = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) X[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) Y[i] = Integer.parseInt(st.nextToken());

            E = Double.parseDouble(br.readLine());// 세율

            WeightsEachEdges = new ArrayList<>();


            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    double dist = calculateDistance(X[i], Y[i], X[j], Y[j]);
                    WeightsEachEdges.add(new Island(i, j, calculateTax(dist)));
                }
            }

            Collections.sort(WeightsEachEdges, new Comparator<Island>() {

                @Override
                public int compare(Island o1, Island o2) {
                    if (o1.tax < o2.tax) return -1;
                    else if (o1.tax > o2.tax) return 1;
                    return 0;
                }
            });

            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            answer = 0.0;
            // ////////////////////////구현부

            for (Island Node : WeightsEachEdges) {
                if (!isSameParent(Node.x, Node.y)) {
                    union(Node.x, Node.y);
                    answer += Node.tax;
                }
            }
            // ///////////////////////출력부
            System.out.println("#" + test_case + " " + Math.round(answer));
        }
    }

    public static boolean isSameParent(int x, int y) {
        return findParent(x) == findParent(y);
    }

    public static int findParent(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void union(int x, int y) {
        if (findParent(x) != findParent(y)) parent[findParent(y)] = findParent(x);
    }

    static public double calculateDistance(long x, long y, long dx, long dy) {
        return Math.sqrt(Math.pow(dx - x, 2) + Math.pow(dy - y, 2));
    }

    static public double calculateTax(double dist) {
        return E * Math.pow(dist, 2);
    }
}
