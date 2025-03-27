// BOJ 11663 선분 위의 점
package baekjoon.java;

import java.io.*;
import java.util.*;

public class BOJ_11663 {static long[] dots;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st_N = new StringTokenizer(br.readLine());
        dots = new long[N];
        for(int i = 0; i < N; i++){
            dots[i] = Long.parseLong(st_N.nextToken());
        }
        Arrays.sort(dots);

        while(M > 0){
            // System.out.println(M);
            M--;
            StringTokenizer st_M = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st_M.nextToken());
            long end = Long.parseLong(st_M.nextToken());

            int start_idx = binarySearch(start, 0);
            int end_idx = binarySearch(end, 1);
            
            System.out.println(end_idx + 1 - start_idx);

        }
    }
    private static int binarySearch(long start, int check){  // check에 숫자를 담아 최저점을 찾는지, 최고점을 찾는지
        int left = 0;
        int right = dots.length - 1;

        if(check == 0){
            while(left <= right){
                int mid = (left+right)/2;
                if(dots[mid] < start){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            return left;
        }
        else{
            while(left <= right){
                int mid = (left+right)/2;
                if(dots[mid] > start){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            return right;

        }
    }
}