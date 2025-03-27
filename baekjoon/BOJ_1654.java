// BOJ 1654 랜선 자르기
package baekjoon.java;

import java.io.*;
import java.util.*;


public class BOJ_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());   // 갖고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선 개수
        
        int [] lengths = new int[K];

        for(int i = 0; i < K; i++){
            lengths[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lengths);

        // int result = 0;
        long start = 1;
        long end = lengths[K-1];
        // long result = 0;

        while(start <= end){
            long lan_counts = 0;
            long mid = (start + end) / 2;
            for (int length: lengths){
                lan_counts += length / mid;
            }
            if(lan_counts >= N) {
                start = mid + 1;
            }
            else end = mid -1;
        }
        System.out.println(end);
    }
}
