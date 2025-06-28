// BOJ 1926 그림

import java.io.*;
import java.util.*;

public class BOJ_1926 {
    static int n;
    static int m;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> result = new ArrayList<>();

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int size = 1;
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for(int dir = 0; dir < 4; dir++){
                int nx = cx + dx[dir], ny = cy + dy[dir];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && !visited[nx][ny]){
                    size += 1;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return size;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            StringTokenizer st_line = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st_line.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    result.add(bfs(i, j));
                }
            }
        }

        System.out.println(result.size());
        if(result.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.max(result));
        }
    }
}
