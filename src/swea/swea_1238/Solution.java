package swea.swea_1238;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Contact
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD

public class Solution {
    static int N, startingPoint, from, to, answer;
    static int[][] graph; // 연락망
    static boolean[] visited;
    static Queue<Integer> queue;


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_1238/input.txt"));
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            answer = 0;

            N = sc.nextInt();
            startingPoint = sc.nextInt();

            graph = new int[101][101];
            visited = new boolean[101];

            queue = new LinkedList<>();

            for (int i = 0; i < N / 2; i++) {
                from = sc.nextInt();
                to = sc.nextInt();

                graph[from][to] = 1;
            }

            answer = bfs(startingPoint);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static int bfs(int idx) {
        queue.offer(idx);
        visited[idx] = true;
        int maxNumber = 0;
        ArrayList<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            maxNumber = 0;
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                int curNode = queue.poll();

                for (int j = 1; j < 101; j++) {
                    if (graph[curNode][j] == 1 && !visited[j]) {
                        queue.offer(j);
                        visited[j] = true;
                        maxNumber = Math.max(maxNumber, j);
                    }
                }
            }
            list.add(maxNumber);
        }
        return list.get(list.size() - 2);
    }
}
