package baekjoon.java;

import java.io.*;
import java.util.*;

// DFS는 재귀로
// BFS는 queue로

public class BOJ_1260 {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[] visited;
    static int N, M, V;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++){
            StringTokenizer nodes = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(nodes.nextToken());
            int node2 = Integer.parseInt(nodes.nextToken());

            arr[node1][node2] = arr[node2][node1] = 1;
        }

        dfs(V);
        sb.append("\n");
        
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }
    
    public static void dfs(int start){
        visited[start] = true;
        sb.append(start + " ");
        for (int i = 0; i <= N; i++){
            if(arr[start][i] == 1 && !visited[i])
                dfs(i);
        }

    }

    public static void bfs(int start){
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            start = queue.poll();
            sb.append(start + " ");
            for (int i = 0; i <= N; i++){
                if(arr[start][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
