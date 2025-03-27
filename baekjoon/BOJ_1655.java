// BOJ 1655 가운데를 말해요

package baekjoon.java;

import java.util.*;
import java.io.*;


public class BOJ_1655 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());

            int left = 0, right = arr.size() - 1, mid = (left + right) / 2;

            while(left <= right){
                mid = (left + right) / 2;
                if(arr.get(mid) > num) right = mid - 1;
                else if(arr.get(mid) <= num){
                    left = mid + 1;
                    mid++;
                }
            }
            arr.add(mid, num);
            System.out.println(arr.size() % 2 == 0 ? arr.get(arr.size() / 2 - 1) : arr.get(arr.size() / 2));
        }
    }
}
