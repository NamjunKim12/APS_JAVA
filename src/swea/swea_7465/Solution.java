package swea.swea_7465;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T, N, M, answer;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_7465/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            M = sc.nextInt();
            answer = 0;

            makeParentsNodeArray();

            for (int i = 0; i < M; i++) {
                int firstNode = sc.nextInt();
                int secondNode = sc.nextInt();

                union(firstNode, secondNode);
            }

            for (int i = 1; i <= N; i++)
                if (parents[i] == i) answer += 1;


            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void makeParentsNodeArray() {
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) parents[i] = i;
    }

    public static int findSet(int startNode) {
        if (parents[startNode] == startNode) return startNode;
        return parents[startNode] = findSet(parents[startNode]);
    }

    public static boolean isHavingSameParent(int firstNode, int secondNode) {
        firstNode = findSet(firstNode);
        secondNode = findSet(secondNode);

        return firstNode == secondNode;
    }

    public static void union(int firstNode, int secondNode) {
        firstNode = findSet(firstNode);
        secondNode = findSet(secondNode);

        if (firstNode < secondNode) parents[secondNode] = firstNode;
        if (firstNode > secondNode) parents[firstNode] = secondNode;
    }
}
