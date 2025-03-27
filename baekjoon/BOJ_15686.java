import java.io.*;
import java.util.*;

package baekjoon.java;

public class BOJ_15686 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maps = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer stt = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                maps[i][j] = Integer.parseInt(stt.nextToken());
            }
        }
    }
}
