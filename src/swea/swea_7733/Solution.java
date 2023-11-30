package swea.swea_7733;

import java.io.FileInputStream;
import java.util.Scanner;

// 치즈도둑
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWrDOdQqRCUDFARG

public class Solution {
    static int T, N, answer;
    static int[][] cheeseBlock;
    static boolean[][] visited;

    // 상좌우하 시계방향
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_7733/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            answer = Integer.MIN_VALUE;

            cheeseBlock = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    cheeseBlock[i][j] = sc.nextInt();
            }

            for (int cheeseTasteLevel = 0; cheeseTasteLevel <= 100; cheeseTasteLevel++) {
                int temp = 0;
                visited = new boolean[N][N];

                eatCheese(cheeseBlock, cheeseTasteLevel);

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (visited[i][j] || cheeseBlock[i][j] == 0) continue;

                        temp += 1;
                        countCheeseBlock(i, j);
                    }
                }

                answer = Math.max(answer, temp);
            }


            System.out.println("#" + test_case + " " + answer);
        }
    }

    public static void eatCheese(int[][] cheeseBlock, int cheeseTasteLevel) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cheeseBlock[i][j] == cheeseTasteLevel) {
                    cheeseBlock[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
    }

    public static void countCheeseBlock(int row, int col) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < N && newCol >= 0 && newCol < N) {
                if (!visited[newRow][newCol] && cheeseBlock[newRow][newCol] != 0)
                    countCheeseBlock(newRow, newCol);
            }
        }
    }
}


