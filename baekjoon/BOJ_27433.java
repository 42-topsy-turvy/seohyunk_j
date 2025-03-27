// BOJ 27433 팩토리얼 2
package baekjoon.java;

import java.io.*;

public class BOJ_27433 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(recursive(N));
        
    }

    public static Long recursive(int N){
        if (N == 0 || N == 1) {
            long sum = 1;
            return sum;
        }
        else{
            long sum = N * recursive(N-1);
            return sum;
        }
    }
}
