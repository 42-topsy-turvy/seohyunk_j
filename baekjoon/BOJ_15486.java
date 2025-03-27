// BOJ 15486 퇴사2
package baekjoon.java;

import java.util.*;
import java.io.*;
public class BOJ_15486 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedule = new int[N][2];
        int[] dp = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            int possible = 0;
            if(i == 0) dp[i] = schedule[i][1];
            else dp[i] = schedule[i - possible][1];
        }
    }
}
