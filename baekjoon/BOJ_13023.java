import java.io.*;
import java.util.*;

public class BOJ_13023 {
    private static int N, M;
    private static ArrayList<Integer>[] graph;
    private static int answer = 0;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
		
        for (int i = 0; i < N; i++){
            visited[i] = true;
            if (backtracking(1, i)){
                System.out.println(1);
                System.exit(0);
            }
            visited[i] = false;
        }
        System.out.println(0);
    }

    public static boolean backtracking(int depth, int node){
        if (depth == 5){
            return true;
        }

        for (int next_node: graph[node]){
            if (!visited[next_node]){
                visited[next_node] = true;
                if (backtracking(depth+1, next_node)){
                    return true;
                }
                visited[next_node] = false;
            }
        }
        return false;
    }
}
