package baekjoon.java;

import java.io.*;
import java.util.*;

public class BOJ_1874 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> stackNum = new Stack<>();    // 1~N까지 담긴 스택
        int start = 0;
        
        int N = Integer.parseInt(br.readLine());
        
        while(N > 0){
            int value = Integer.parseInt(br.readLine());
            if (value > start){
                for(int i = start + 1; i <= value; i++){
                    stackNum.push(i);
                    sb.append('+').append('\n');
                }
                start = value;
            }
            else if(stackNum.peek() != value){
                System.out.println("NO");
                return;
            }

            stackNum.pop();
            sb.append("-").append("\n");
            --N;
        }
        System.out.println(sb);
        
    }    
}
