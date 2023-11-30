package swea.swea_1873;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    static int T;
    static int H, W;
    static char[][] map;
    static int N; // 사용자의 커맨드 입력 개수
    static char[] command;
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};
    static int r, c, dir;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swea/swea_1873/input.txt"));
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            H = sc.nextInt();
            W = sc.nextInt();
            map = new char[H][W];
            r = 0;
            c = 0;
            dir = 0;

            // map에 char 삽입
            for (int i = 0; i < H; i++) {
                String str = sc.next();
                for (int j = 0; j < W; j++) {
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                        r = i;
                        c = j;
                        switch (map[i][j]) {
                            case '<':
                                dir = 2;
                                break;
                            case '>':
                                dir = 3;
                                break;
                            case '^':
                                dir = 0;
                                break;
                            case 'v':
                                dir = 1;
                                break;
                        }

                    }
                }
            }

            N = sc.nextInt();
            command = new char[N];
            String str = sc.next();

            for (int i = 0; i < N; i++) {
                command[i] = str.charAt(i);
            }

            for (char userInput : command) {
                switch (userInput) {
                    case 'U':
                        dir = 0;
                        map[r][c] = '^';
                        if (r - 1 >= 0 && map[r + dr[dir]][c] == '.') {
                            map[r][c] = '.';
                            map[r + dr[dir]][c] = '^';
                            r = r + dr[dir];
                        }
                        break;
                    case 'D':
                        dir = 1;
                        map[r][c] = 'v';
                        if (r + 1 < H && map[r + dr[dir]][c] == '.') {
                            map[r][c] = '.';
                            map[r + dr[dir]][c] = 'v';
                            r = r + dr[dir];
                        }
                        break;
                    case 'L':
                        dir = 2;
                        map[r][c] = '<';
                        if (c - 1 >= 0 && map[r][c + dc[dir]] == '.') {
                            map[r][c] = '.';
                            map[r][c + dc[dir]] = '<';
                            c = c + dc[dir];
                        }
                        break;
                    case 'R':
                        dir = 3;
                        map[r][c] = '>';
                        if (c + 1 < W && map[r][c + dc[dir]] == '.') {
                            map[r][c] = '.';
                            map[r][c + dc[dir]] = '>';
                            c = c + dc[dir];
                        }
                        break;
                    case 'S':
                        int nr = r;
                        int nc = c;
                        while (true) {
                            nr += dr[dir];
                            nc += dc[dir];
                            if (nr < 0 || nr >= H || nc < 0 || nc >= W) break;
                            if (map[nr][nc] == '#') break;
                            if (map[nr][nc] == '*') {
                                map[nr][nc] = '.';
                                break;
                            }
                        }
                        break;
                }
            }

            System.out.print("#" + test_case + " ");
            for (char[] row : map) {
                for (char c : row) {
                    System.out.print(c);
                }
                System.out.println();
            }
        }
    }
}
