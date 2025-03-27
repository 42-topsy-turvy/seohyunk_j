package baekjoon.java;

import java.io.*;
import java.util.*;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] weight = new int[N];
        int[] value = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer stt = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(stt.nextToken());
            value[i] = Integer.parseInt(stt.nextToken());
        }

        int[] dp = new int[K+1];
        
        for (int i = 0; i < N; i++) {
            for (int w = K; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
            }
        }
        
        System.out.println(dp[K]);

        // int max_worth = 0;
        // int cur_worth = 0;
        // int all_weight = 0;
        // for(int i = 0; i < N; i++){
        //     all_weight = 0;
        //     cur_worth = 0;
        //     all_weight += weight[i];
        //     cur_worth += value[i];
        //     System.out.println("all weight: " + all_weight + "cur worth: " + cur_worth);
        //     for(int j = i+1; j < N; j++){
        //         if(all_weight + weight[j] <= K){
        //             all_weight += weight[j];
        //             cur_worth += value[j];
        //         }
        //     }
        //     if(all_weight <= K) {
        //     max_worth = Math.max(max_worth, cur_worth);
        //     }
        // }
        // System.out.println(max_worth);
    }

}
