package programmers.java;

import java.util.*;

public class programmers_87694 {
    class Solution {
        static int N = 50;
        int[][] matrix = new int[N][N];
        int[][] visited = new int[N][N];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            for(int[] topography: rectangle){
                for(int i = topography[0]; i < topography[2]; i++){
                    if((i == topography[0]) || (i == topography[2] - 1)){
                        for(int j = topography[1]; j < topography[3]; j++){
                            matrix[i][j] = 1;
                        }
                    }
                    else{
                        matrix[i][topography[1] - 1] = 1;
                        matrix[i][topography[3] - 1] = 1;
                    }
                }
            }
            System.out.println(Arrays.deepToString(matrix));
            return BFS(matrix, new int[]{characterX, characterY}, new int[]{itemX, itemY});
        }
        public int BFS(int[][] grid, int[] start, int[] end){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            visited[start[0]][start[1]] = 1;
            while(!queue.isEmpty()){
                int [] current = queue.poll();
                int cx = current[0];
                int cy = current[1];
                for(int i = 0; i < 4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if(nx == end[0] && ny == end[1]){
                        return visited[cx][cy] + 1;
                    }
                    if((nx >= 0 && nx < N) && (ny >= 0 && ny < N) && grid[nx][ny] == 1){
                        if(visited[nx][ny] == 0){
                            visited[nx][ny] = visited[cx][cy] + 1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            return -1;
        }
    }
}
