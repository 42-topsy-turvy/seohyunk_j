// BOJ 11286 절댓값 힙
package baekjoon.java;

import java.io.*;
import java.util.*;

public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x > 0) queue.add(x);
            else if(x < 0) queue.add(-1 * x);
            else{
                if(queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            }
        }
    }
}
