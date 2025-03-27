// BOJ 10830 행렬 제곱
package baekjoon.java;

import java.util.*;
import java.io.*;

public class BOJ_10830 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        int[][] temp = new int[N][N];
        int[][] ans = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st_ = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st_.nextToken()) % 1000;  // 1000으로 나눈 나머지를 저장
                ans[i][j] = arr[i][j];  // ans도 처음에는 arr와 동일하게 초기화
                // arr[i][j] = Integer.parseInt(st_.nextToken());  // 왼쪽 행렬
                // temp[i][j] = arr[i][j]; // 오른쪽 행렬
            }
        }

        for(int step = 0; step < B - 1; step++){
            for (int i = 0; i < N; i++) {
                Arrays.fill(temp[i], 0);
            }
            // 행렬 곱셈 (4중 루프)
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        temp[i][j] += (ans[i][k] * arr[k][j]) % 1000;  // 행렬 곱셈
                    }
                    temp[i][j] %= 1000;  // 1000으로 나눈 나머지 저장
                }
            }

            // 곱셈 결과를 ans에 복사
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ans[i][j] = temp[i][j];
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
