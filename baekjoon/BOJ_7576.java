// BOJ 7476 토마토
import java.io.*;
import java.util.*;
public class BOJ_7576 {
    static int M, N;
    static int[][] tomato;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st1.nextToken());
        N = Integer.parseInt(st1.nextToken());

        tomato = new int[N][M];
        for (int i = 0; i < N; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                tomato[i][j] = Integer.parseInt(st2.nextToken());
                if (tomato[i][j] == 1){
                    queue.add(new int[]{i, j});

                }
            }
        }
        bfs();
    }
    public static void bfs(){
        while (!queue.isEmpty()){
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if ((nx >= 0 && nx < N) && (ny >= 0 && ny < M) && tomato[nx][ny] == 0){
                    tomato[nx][ny] = tomato[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }   
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (tomato[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                else if (tomato[i][j] > max){
                    max = tomato[i][j];
                }
            }
        }
        System.out.println(max - 1);
    }
}
