// BOJ 2178 미로

package baekjoon.java;

import java.util.*;
import java.io.*;

public class BOJ_2178 {
    // static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int[][] visited;
    static int N, M;
    static int cnt = 0;
    // static Queue<int[]> queue = new LinkedList<>();
    static Queue<Integer[]> queue = new LinkedList<>();
    // 상 하 좌 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        // System.out.println(N);
        // System.out.println(M);

        for(int i = 0; i < N; i++){
            String string = br.readLine();
            for(int j = 0; j < M; j++){
                // arr[i][j] = int.parseInt(string.charAt(j));
                arr[i][j] = string.charAt(j) - '0';
            }
        }
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         System.out.print(arr[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        bfs(arr, N, M);
    }


    public static void bfs(int[][] graph, int row, int column){
        visited = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[i], 0);
        }
        // System.out.println(visited);
        // System.out.println(Arrays.toString(visited));   // [[I@58644d46, [I@14dad5dc, [I@18b4aac2]
        // System.out.println(Arrays.deepToString(visited));

        // queue.add(new int[]{0, 0});
        queue.add(new Integer[]{0, 0});
        visited[0][0] = 1;
        // System.out.println(Arrays.deepToString(visited));

        while (!queue.isEmpty()){
            // int current_i = queue.poll()[0];
            // int current_j = queue.poll()[1]; queue.poll() -> {0, 0} {0, 0}[1] => 0
            System.out.println(cnt++ + " " + Arrays.deepToString(visited));
            // int[] current = queue.poll();
            Integer[] current = queue.poll();
            int current_i = current[0];
            int current_j = current[1];
            // System.out.println(current_i + " " + current_j);
            // System.out.println(Arrays.deepToString(visited));

            if ((current_i == row - 1) && (current_j == column - 1)){
                System.out.println(visited[row - 1][column - 1]);
                return;
            }
            
            for(int k = 0; k < 4; k++){
                // k < N 했을 때, 예제 1, 2는 멀쩡하게 나왔음
                int next_i = current_i + dy[k];
                int next_j = current_j + dx[k];
                // visited[next_i][next_j] != 1일땐 안됨 => 특정 예시에서만
                if ((next_i >= 0 && next_i < row ) && (next_j >= 0 && next_j < column) && (visited[next_i][next_j] != 1) && (graph[next_i][next_j] == 1)){
                    visited[next_i][next_j] = visited[current_i][current_j] + 1;
                    // queue.add(new int[]{next_i, next_j});
                    queue.add(new Integer[]{next_i, next_j});
                    // System.out.println(k + " " + visited[next_i][next_j]);
                }
            }
        }
        System.out.println(visited[row - 1][column - 1]);
    }
}