// BOJ 1927 최소 힙
package baekjoon.java;

import java.util.*;
import java.io.*;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
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
