// BOJ 1260 DFS와 BFS

import java.io.*;
import java.util.*;

// DFS는 재귀로
// BFS는 queue로

public class BOJ_1260 {
    static int N, M, V;
    static ArrayList<Integer> [] graph;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++){
            StringTokenizer nodes = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(nodes.nextToken());
            int node2 = Integer.parseInt(nodes.nextToken());

            graph[node1 - 1].add(node2 - 1);
            graph[node2 - 1].add(node1 - 1);
        }
        for (int i = 0; i < N; i++){
            Collections.sort(graph[i]);
        }

        dfs(V - 1);
        sb.append("\n");
        visited = new boolean[N];
        bfs(V - 1);

        System.out.println(sb);


    }
    private static void dfs(int start){
        visited[start] = true;
        sb.append(start+1 + " ");
        for (int next_node: graph[start]){
            if (!visited[next_node])
                dfs(next_node);
        }
    }

    private static void bfs(int start){
        queue.add(start);
        visited[start] = true;
        while(!queue.isEmpty()){
            start = queue.poll();
            sb.append(start+1 + " ");
            for (int next_node: graph[start]){
                if (!visited[next_node]){
                    queue.add(next_node);
                    visited[next_node] = true;
                }
            }
        }

    }
}