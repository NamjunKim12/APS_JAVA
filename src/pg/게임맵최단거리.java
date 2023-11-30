package pg;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0 ,0};

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];

            if(x == n - 1 && y == m - 1) {
                answer = cnt;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if(visited[nx][ny] || maps[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, cnt + 1});
            }
        }

        return answer == 0 ? -1 : answer;
    }
}
