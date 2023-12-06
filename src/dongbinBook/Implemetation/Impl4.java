package dongbinBook.Implemetation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Impl4 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    static int answer;
    static int N, M;
    static int userRow, userCol, viewDirection;

    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public void solution() throws Exception {
        answer = 0;
        // input 1st line
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        // input 2nd line;
        st = new StringTokenizer(br.readLine());
        userRow = Integer.parseInt(st.nextToken());
        userCol = Integer.parseInt(st.nextToken());
        viewDirection = Integer.parseInt(st.nextToken());

        //rest input
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // Impl
        visited[userRow][userCol] = true;
        answer += 1;
        int turn_time = 0;

        while (true){
            turn_left();
            int newRow = userRow + dr[viewDirection];
            int newCol = userCol + dc[viewDirection];

            if(!visited[newRow][newCol] && map[newRow][newCol] == 0){
                visited[newRow][newCol] = true;
                userRow = newRow;
                userCol = newCol;

                answer += 1;
                turn_time = 0;
                continue;
            } else {
                turn_time += 1;
            }

            if(turn_time == 4){
                newRow = userRow - dr[viewDirection];
                newCol = userCol -dc[viewDirection];

                if(map[newRow][newCol] == 0){
                    userRow = newRow;
                    userCol = newCol;
                } else {
                    break;
                }
                turn_time = 0;
            }
        }

        //output
        System.out.println(answer);
    }

    public static void turn_left(){
        viewDirection -= 1;
        if (viewDirection == -1)
            viewDirection = 3;
    }

    public static void main
            (String[] args) throws Exception {
        new Impl4().solution();
    }
}
