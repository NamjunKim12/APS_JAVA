package swea.swea_3289;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T, n, m;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_3289/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder answer = new StringBuilder();
            n = sc.nextInt();
            m = sc.nextInt();

            makeParentsNodeArray();

            for (int i = 0; i < m; i++) {
                int flag = sc.nextInt();
                int start = sc.nextInt();
                int end = sc.nextInt();

                if (flag == 1) {
                    if (isHavingSameParent(start, end)) answer.append("1");
                    else answer.append("0");
                }

                if (flag == 0) {
                    union(start, end);
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void makeParentsNodeArray() {
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) parents[i] = i;
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

        if (firstNode != secondNode) parents[secondNode] = firstNode;
    }
}
