package programmers.java;

import java.util.*;
public class programmers_43162 {
    class Solution {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    bfs(i, computers, visited);
                    answer++;
                }
            }
            return answer;
        }
        public int bfs(int start, int[][] computers, boolean[] visited){
            // int n = computers[0].length;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            visited[start] = true;
            
            while(!queue.isEmpty()){
                int current = queue.poll();
                for(int j = 0; j < computers.length; j++){
                    if(computers[current][j] == 1 && visited[j] == false){
                        visited[j] = true;
                        queue.add(j);
                    }
                }
            }

            return 0;
        }
    }
}
