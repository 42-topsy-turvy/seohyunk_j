// BOJ 11279 최대 힙
package baekjoon.java;

import java.util.*;
import java.io.*;

public class BOJ_11279 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());

        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x > 0) queue.add(x);
            else{
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
        }
    }
}
