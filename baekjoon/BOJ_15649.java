// N과 M(1)
package baekjoon.java;

import java.io.*;
import java.util.*;

public class BOJ_15649 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        arr = new int[M];

        // dfs(N, M);
        dfs(0);
        System.out.println(sb);
    }

    public static void dfs(int depth){
        if(depth == M){
            for(int val: arr){
                sb.append(val).append(" ");
            }
            sb.append("\n");
            // System.out.println("sb =>" + sb + " <=");
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
        
        }
}
